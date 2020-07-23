package sync.threadPool2;


import java.util.List;

public class ThreadPool<T extends AsyncTask & Job> {
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    private ThreadSafeQueue<T> jobQueue;
    private ThreadSafeQueue workerQueue;

    public ThreadPool(){
        this(DEFAULT_WORKER_NUMBERS);
    }

    public ThreadPool(int num){
        workerNum = num;
        jobQueue = new ThreadSafeQueue();
        workerQueue = new ThreadSafeQueue();
        initializeWorkers(num);
    }

    private void initializeWorkers(int num){
        for (int i=0;i<num;i++){
            Thread worker = new ProcessThread(jobQueue);
            workerQueue.put(worker);
            worker.start();
        }
    }

    public void shutdown() {
        int size = workerNum;
        while (size-->0){
            ProcessThread worker = (ProcessThread) workerQueue.pop(true, 0);
            worker.shutdown();
        }
    }

    public void put(T item){
        jobQueue.put(item);
    }

    public void batchPut(List<T> itemlsit){
        for (T item:itemlsit)
            put(item);
    }

    public int getSize(){
        return workerQueue.getSize();
    }
}
