package sync.conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
    private static ConnectionPool pool = new ConnectionPool(10);

    static CountDownLatch start = new CountDownLatch(1);

    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;
        //
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        //
        for (int i=0;i<threadCount;i++){
            Thread thread = new Thread(new ConnectionRunner(got, notGot, count),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: "+ (threadCount*count));
        System.out.println("got: "+got);
        System.out.println("notGot: "+notGot);
    }

    static class ConnectionRunner implements Runnable{
        int count ;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(AtomicInteger got, AtomicInteger notGot,int count) {
            this.got = got;
            this.notGot = notGot;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count>0){
                try {
                    //从连接池中获取连接，超时无法获取，返回null
                    //分别统计连接获取的数量got 为获取到的 notGot
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            got.incrementAndGet();
                            pool.releaseConnection(connection);
                        }
                    }
                    else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
