package LC2026;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liutingfeng
 * @Date 2026/7/31 10:58
 *
 * 三个线程交替打印 1、2、3（循环 ROUNDS 轮）
 * 期望输出：123123123...
 *
 * 四种解法：
 * 1. synchronized + wait/notifyAll（共享状态变量，通知所有人，由线程自己判断是否轮到自己）
 * 2. ReentrantLock + Condition（三个条件队列，精准唤醒下一个线程）
 * 3. Semaphore（三个信号量，许可依次为 1/0/0，打印完放行下一个）
 * 4. LockSupport.park/unpark（每个线程持有下一个线程的引用，打印完直接 unpark 它）
 */
public class LCzijie002 {

    // 每个线程打印的次数，总输出为 123... 重复 ROUNDS 轮
    private static final int ROUNDS = 5;

    // ==================== 解法一：synchronized + wait/notifyAll ====================
    // 核心：一个共享变量 state 表示"当前轮到谁"（state % 3 == 线程id）
    // 线程抢同一把锁，没轮到自己就 wait 释放锁，打印完 notifyAll 让大家重新竞争
    static class Solution1 {
        private int state = 0; // 全局打印序号，state % 3 决定轮到哪个线程

        public void print(int id) throws InterruptedException {
            for (int i = 0; i < ROUNDS; i++) {
                synchronized (this) {
                    // 用 while 防止虚假唤醒：不是自己就继续等（等待时会释放锁）
                    while (state % 3 != id) {
                        this.wait();
                    }
                    System.out.print(id + 1);
                    state++;              // 轮到下一个线程
                    this.notifyAll();     // 唤醒所有等待线程，它们重新竞争锁并自检
                }
            }
        }

        public void print2(int id) throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (state % 3 != id) {
                        this.wait();
                    }
                    System.out.println(id + 1);
                    state++;
                    this.notifyAll();
                }
            }
        }
    }

    // ==================== 解法二：ReentrantLock + Condition ====================
    // 核心：一把锁配三个 Condition（等待队列），每个线程只在自己的队列上等，
    // 打印完只 signal "下一个"线程的队列，精准唤醒，避免 notifyAll 的无效竞争
    static class Solution2 {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition[] conditions = new Condition[3];
        private int state = 0;

        public Solution2() {
            for (int i = 0; i < 3; i++) {
                conditions[i] = lock.newCondition(); // 每个线程一个等待队列
            }
        }

        public void print(int id) throws InterruptedException {
            for (int i = 0; i < ROUNDS; i++) {
                lock.lock();
                try {
                    // 没轮到自己就在自己的条件队列上 await（释放锁）
                    while (state % 3 != id) {
                        conditions[id].await();
                    }
                    System.out.print(id + 1);
                    state++;
                    // 只唤醒下一个线程，精准传递"执行权"
                    conditions[(id + 1) % 3].signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // ==================== 解法三：Semaphore ====================
    // 核心：三个信号量代表"三个线程的执行许可"，初始 1/0/0（只有线程1能跑），
    // 每个线程 acquire 自己的许可 -> 打印 -> release 下一个线程的许可
    static class Solution3 {
        // sems[0]=1 保证线程1先执行，其余为 0 阻塞等待
        private final Semaphore[] sems = {new Semaphore(1), new Semaphore(0), new Semaphore(0)};

        public void print(int id) throws InterruptedException {
            for (int i = 0; i < ROUNDS; i++) {
                sems[id].acquire();          // 等自己的执行许可（没许可就阻塞）
                System.out.print(id + 1);
                sems[(id + 1) % 3].release(); // 把许可交给下一个线程
            }
        }
    }

    // ==================== 解法四：LockSupport.park/unpark ====================
    // 核心：每个线程持有"下一个线程"的引用，
    // 先 park 阻塞自己，被 unpark 唤醒后打印，再 unpark 下一个线程，像击鼓传花
    // 注意：unpark 先于 park 调用也有效（许可制），所以无需关心线程启动顺序
    static class Solution4 {
        private final Thread[] threads = new Thread[3];

        // 这个解法需要在线程内部拿到彼此的引用，所以线程由本类自己创建
        public void run() throws InterruptedException {
            for (int i = 0; i < 3; i++) {
                final int id = i;
                threads[i] = new Thread(() -> {
                    for (int r = 0; r < ROUNDS; r++) {
                        LockSupport.park();              // 阻塞自己，等上一个线程 unpark
                        System.out.print(id + 1);
                        LockSupport.unpark(threads[(id + 1) % 3]); // 唤醒下一个线程
                    }
                });
            }
            // 三个线程的引用都填好后统一启动
            for (Thread t : threads) {
                t.start();
            }
            // 踢第一脚：唤醒线程1，开始传花
            LockSupport.unpark(threads[0]);
            for (Thread t : threads) {
                t.join();
            }
        }
    }

    // 通用运行器：为解法1/2/3 创建三个线程并等待结束
    private static void run(String name, Printer printer) throws InterruptedException {
        System.out.println(name);
        Thread[] ts = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int id = i;
            ts[i] = new Thread(() -> {
                try {
                    printer.print(id);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            ts[i].start();
        }
        for (Thread t : ts) {
            t.join();
        }
        System.out.println(); // 换行
    }

    @FunctionalInterface
    private interface Printer {
        void print(int id) throws InterruptedException;
    }

    public static void main(String[] args) throws InterruptedException {
        run("解法一 synchronized + wait/notifyAll:", new Solution1()::print);
        run("解法二 ReentrantLock + Condition:   ", new Solution2()::print);
        run("解法三 Semaphore:                   ", new Solution3()::print);
        System.out.println("解法四 LockSupport.park/unpark:    ");
        new Solution4().run();
        System.out.println();
    }
}
