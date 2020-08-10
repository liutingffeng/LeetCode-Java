package stringlearning;

import org.junit.Test;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class StringDemo3 {

    @Test
    public void test1(){
        String s1 = new String("ab");
        s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2);  //false
    }

    @Test
    public void test2(){
        String s1 = new String("a")+new String("b");
        s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2);  //true;
    }

    @Test
    public void test3(){

        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new String(String.valueOf(i));
        }

        String s1 = String.valueOf(0);

        new String(s1 + "add");

        System.out.println(s1 == arr[0]);

    }

    @Test
    public void test4(){
        Thread.currentThread().interrupt();

        System.out.println(Thread.interrupted());
//        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
    }

    @Test
    public void test5(){
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj, referenceQueue);
        obj = null;
        System.out.println(phantomReference.get());
        new Thread(()->{
            while (true){
                Object obj1 = null;
                try {
                    obj1 = referenceQueue.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (obj1!= null){
                    System.out.println("虚引用");
                }
                else {
                    System.out.println("null");
                }
            }
        }).start();
        System.gc();
        try {
            System.out.println(referenceQueue.remove());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interrupt!");
                System.out.println(Thread.interrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.interrupted());
                System.out.println(Thread.interrupted());

                e.printStackTrace();
            }
//            Thread.currentThread().interrupt();

            while (true){

            }
        });

        t1.start();
        Thread.sleep(50);
        t1.interrupt();
        Thread.sleep(500);
//        t1.interrupt();

        System.out.println("main"+"  "+t1.isInterrupted());
        System.out.println();
    }
}
