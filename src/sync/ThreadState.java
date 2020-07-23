package sync;

import java.util.concurrent.TimeUnit;

public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaiting").start();
        new Thread(new Waiting(),"Waiting").start();

        new Thread(new Blocked(),"Blocked()-1").start();
        new Thread(new Blocked(),"Blocked()-2").start();
    }

    //该进程不断地进行睡眠
    static class TimeWaiting implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //该进程在Waiting.class 实例上等待
    static class Waiting implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //
    static class Blocked implements Runnable{

        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
