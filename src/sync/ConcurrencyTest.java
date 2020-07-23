package sync;

public class ConcurrencyTest {

    private static long count = 10000000;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread t = new Thread(()->{
            int a = 0;
            for (int i=0;i<count;i++){
                a += 5;
            }
        });
        t.start();
        int b = 0;
        for (int i=0;i<count;i++){
            b--;
        }
        t.join();

        long time = System.currentTimeMillis()-start;
        System.out.println("concurrency:"+time+"  "+b);

    }

    private static void serial(){
        long start = System.currentTimeMillis();

        int a = 0;
        for (int i=0;i<count;i++){
            a += 5;
        }

        int b = 0;
        for (int i=0;i<count;i++){
            b--;
        }

        long time = System.currentTimeMillis()-start;
        System.out.println("serial:"+time+"   "+a+"  "+b);


    }

}
