package sync.threadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    //
    private static final int MIN_WORKER_NUMBERS = 1;
    //
    private final LinkedList<Job> jobs = new LinkedList<>();
    //
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    //
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS: num <
                MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS:num;
        initializeWorkers(workerNum);
    }

    //初始化线程工作者
    private void initializeWorkers(int num){
        for (int i=0;i<num;i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool=Worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable{

        //是否工作
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //感知到外部对workerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job!=null){
                    try {
                        job.run();
                    } catch (Exception e) {
                       //忽略异常
                    }
                }
            }
        }

        public void shutdown(){
            running = false;
        }
    }

    @Override
    public void execute(Job job) {
        if (job!=null){
            //添加一个工作，然后进行通知
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker:workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            //限制新增的worker数量不能超过最大值
            if (num+this.workerNum> MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS-workerNum;
            }
            initializeWorkers(num);
            this.workerNum+=num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if (num>=this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }
            //
            int count = 0;
            while (count < num){
                Worker worker = workers.get(count);
                if (workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum = workerNum-count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
}
