package sync.sys;

public class mutexDemo {
    static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(()->{
            int times = 10000000;
            while (times-->0){
                synchronized (lock) {
                    num++;
                }
            }
        });
        Thread t2 = new Thread(()->{
            int times = 10000000;
            while (times-->0){
                synchronized (lock) {
                    num--;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(num);
    }

}
