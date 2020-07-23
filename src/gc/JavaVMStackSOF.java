package gc;

public class JavaVMStackSOF {

    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable throwable){
            System.out.println("satcklength"+oom.stackLength);
            throw throwable;
        }
    }
}
