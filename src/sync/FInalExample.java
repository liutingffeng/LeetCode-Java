package sync;

public class FInalExample {

    final int a;
    static FInalExample obj;

    public FInalExample() {
        a = 1;
    }


    public static void write(){
        obj = new FInalExample();
    }

    public static void read(){
        FInalExample object = obj;
        System.out.println(object.a);
    }

    public static void main(String[] args) {
        FInalExample.read();
    }
}
