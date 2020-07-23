package sync.AQS;

import java.util.concurrent.TimeUnit;

public class Demo01 {
    private static int value;

    public static void modify(){
        synchronized (Demo01.class){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = 1;
            System.out.println(value);
        }
    }

    public static void read(){
        System.out.println(value);
    }


    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
////            Demo01.modify();
//            Demo01.value = 1;
//            System.out.println(Demo01.value);
//        System.out.println("modify");
//        }).start();
        // TimeUnit.SECONDS.sleep(1);
        int a = 0;
        Thread t1 = new Thread(()->{
            System.out.println(value);
        });

         Thread t2 =       new Thread(()->{
//            Demo01.modify();
            value = 1;
//            System.out.println(Demo01.value);
        System.out.println("modify");
        });

         t2.start();
         t1.start();
        TimeUnit.SECONDS.sleep(2);
    }
}
