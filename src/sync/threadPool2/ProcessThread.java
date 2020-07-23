package sync.threadPool2;


public class ProcessThread extends Thread {

    private volatile boolean isRunning = true;
    private ThreadSafeQueue queue;

    public ProcessThread(ThreadSafeQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (isRunning){
            Object o = queue.pop(true, 0);
            if (o instanceof AsyncTask) {
                AsyncTask task = (AsyncTask) o;
                Object res = task.run();
                task.setResult(res);
            }
            else
                ((Job) o).run();
        }
    }

    public void shutdown(){
        isRunning = false;
    }
}
