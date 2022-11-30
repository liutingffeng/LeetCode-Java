package sync.threadPool2;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    static class SimpleJob implements Job{

        @Override
        public Object run() {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+": this is a job1");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+": this is a job2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    static class AsyncJob extends AsyncTask<Integer>{

        @Override
        public Integer run() {
            int sum = 0;
            for (int i=1;i<=100;i++)
                sum += i;
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        for (int i=0;i<20;i++){
            AsyncTask task = new AsyncJob();
            pool.put(task);
            System.out.println(task.getResult());
        }
    }

    @Test
    public void test(){
        ThreadPool pool = new ThreadPool();
        for (int i=0;i<20;i++){
            AsyncTask task = new AsyncJob();
            pool.put(task);
            System.out.println(System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = task.getResult();
            System.out.println(System.currentTimeMillis()+":"+result);
        }
    }
}
