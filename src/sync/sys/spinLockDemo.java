package sync.sys;

import java.util.concurrent.atomic.AtomicInteger;

public class spinLockDemo {

    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            int times = 10000000;
            while (times-->0){
                num.incrementAndGet();
            }
        });
        Thread t2 = new Thread(()->{
            int times = 10000000;
            while (times-->0){
                num.decrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(num);
    }
}
