package sync.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {
    private Object[] items;
    //
    private int addIndex,removeIndex,count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size){
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length){
                notFull.await();
            }
            items[addIndex++] = t;
            count++;
            if (++addIndex == items.length)
                addIndex = 0;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            Object x = items[removeIndex];
            count--;
            if (++removeIndex == items.length)
                removeIndex = 0;
            notEmpty.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }

}
