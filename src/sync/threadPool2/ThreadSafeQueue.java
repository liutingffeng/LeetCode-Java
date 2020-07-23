package sync.threadPool2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThreadSafeQueue<T> {
    private int maxSize;
    private Queue<T> queue;

    public ThreadSafeQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new LinkedList();
    }

    public ThreadSafeQueue(){
        queue = new LinkedList();
    }

    public int getSize(){
        synchronized (queue){
            return queue.size();
        }
    }

    public void put(T item){
        if (queue != null){
            synchronized (queue){
                queue.add(item);
                queue.notify();
            }
        }
    }

    public void baychPut(List<T> list){
        for (T item : list){
            put(item);
        }
    }

    //从队列中取出元素
    public T pop(boolean blocked,long timeout){
        synchronized (queue){
            while (queue.isEmpty()){
                if (blocked){
                    try {
                        queue.wait(timeout);
                    } catch (InterruptedException e) {
                        //感知到外部对workerThread的中断操作，返回
                        Thread.currentThread().interrupt();
                        return null;
                    }
                }
                else
                    return null;
            }
            return queue.poll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeQueue<Object> queue = new ThreadSafeQueue<>(100);
        Thread t1 = new Thread(()->{
            while (true){
                queue.put(new Object());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            while (true){
                Object o = queue.pop(true, 0);
                System.out.println("get item: "+o);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
