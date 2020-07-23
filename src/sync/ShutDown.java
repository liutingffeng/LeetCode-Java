package sync;

import java.util.concurrent.TimeUnit;

public class ShutDown {

    static class Runner implements Runnable{

        private long count;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                count ++;
            }

            System.out.println("count "+count);
        }

        public void cancle(){
            on = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one,"countThread");
        countThread.start();
        //
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        //
        Runner two = new Runner();
        countThread = new Thread(two, "countThread");
        countThread.start();
        //
        TimeUnit.SECONDS.sleep(1);
        two.cancle();
    }
}
