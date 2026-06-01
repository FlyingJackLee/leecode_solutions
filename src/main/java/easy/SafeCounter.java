package easy;

import java.util.concurrent.locks.ReentrantLock;

public class SafeCounter {
    private ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    private void increment(){
        lock.lock();

        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    private int getCount(){
        lock.lock();

        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
