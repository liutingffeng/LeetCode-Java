package sync;

import java.util.concurrent.locks.ReentrantLock;

public class VolatileExample {
    int a = 0;
    boolean flag = false;

    public void write(){
        a = 1;
        flag = true;
        System.out.println(a);
    }

    public void read(){
        if (flag){
            int i = a;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        final int a ;
        a = 1;

        Thread t1 = new Thread(() -> {
            example.write();
        });

        Thread t2 = new Thread(()->{
            example.read();
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
