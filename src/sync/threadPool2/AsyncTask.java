package sync.threadPool2;

public abstract class AsyncTask<E>  {

    private E result ;

    public abstract  E run();

    public void setResult(E result){
        synchronized (this){
            //设置结果
            this.result = result;
            this.notify();
        }
    }

    public E getResult(){
        synchronized (this){
            while (result == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }
}
