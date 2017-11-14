package huangshun.it.com.androiddesignpattern.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hs on 2017/11/12.
 */

public class EvenGeneratorUseLock extends IntGenerator {
    private int num;

    @Override
    public synchronized int next() {
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
            num++;
            num++;
            return num;

        } finally {
            reentrantLock.unlock();
        }

    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGeneratorUseLock(), 5);
    }
}
