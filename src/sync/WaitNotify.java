package sync;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static Object lock = new Object();
    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Wait(),"WaitThread").start();
        TimeUnit.SECONDS.sleep(1);

        new Thread(new Notify(),"notifyThread").start();
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while (flag){
                    System.out.println(Thread.currentThread()+" flag is true.wait@ "+
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread()+" flag is false.running@ "+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock.notify@ "+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock again.slepp@ "+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
