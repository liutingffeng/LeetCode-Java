package sync;

import java.util.concurrent.TimeUnit;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        Thread thread1 = new Thread(new Domino(previous), "String.valueOf(i)");
        thread1.start();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+ " terminated.");
    }


    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" terminated.");
        }
    }
}
