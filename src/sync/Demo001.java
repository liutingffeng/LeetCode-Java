package sync;

public class Demo001 {
    private String name;
    private int count;

    public synchronized void set(){
        this.name = "zhangsan";
        System.out.println(Thread.currentThread().getName()+" "+name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count = 100;
        System.out.println(Thread.currentThread().getName()+" "+count);

    }

    public void get(){
        System.out.println(Thread.currentThread().getName()+" "+count);
    }

    public static void main(String[] args) {
        Demo001 demo001 = new Demo001();
        new Thread(()->demo001.set()).start();
        new Thread(()->demo001.get()).start();
    }
}
