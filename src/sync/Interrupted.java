package sync;

import java.util.concurrent.TimeUnit;

public class Interrupted {

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread sthread = new Thread(new SleepRunner(), "SleepThread");
        sthread.setDaemon(true);

        Thread bthread = new Thread(new BusyRunner(),"BusyThread");
        bthread.setDaemon(true);

        sthread.start();
        bthread.start();
        //
        Thread.sleep(5000);
        //
        sthread.interrupt();
        bthread.interrupt();
        System.out.println("sleep "+sthread.isInterrupted());
        System.out.println("busy "+bthread.isInterrupted());
        Thread.sleep(2000);
    }
}
