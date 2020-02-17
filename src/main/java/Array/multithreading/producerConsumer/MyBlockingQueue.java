package Array.multithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    private Queue<E> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();

    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public MyBlockingQueue(int size) {
        this.queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E e) {

        lock.lock();
        try {
            //check with queue is it full ?
            if(queue.size() == max) {
                //block the thread
                notFull.await();
            }
            queue.add(e);
            notEmpty.signalAll();
        } catch (Exception ae) {

        } finally {
            lock.unlock();
        }
    }

    public E take() {

        lock.lock();
        E e = null;
        try {
            //check with queue is it empty ?
            if(queue.size() == 0) {
                //block the thread
                notEmpty.await();
            }
            e = queue.remove();
            notFull.signalAll();

        } catch (Exception ae) {

        } finally {
            lock.unlock();
        }

        return e;
    }
}
