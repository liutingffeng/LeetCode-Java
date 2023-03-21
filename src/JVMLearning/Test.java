package JVMLearning;

public class Test {

    public static void main(String[] args) {
        Runnable r = ()->{
            System.out.println("hello, lambda");
        };
        r.run();
    }
}
