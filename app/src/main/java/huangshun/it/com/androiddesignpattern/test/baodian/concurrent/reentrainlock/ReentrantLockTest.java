package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.reentrainlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hs on 2017/12/5.
 */

public class ReentrantLockTest implements Runnable {
    private static ReentrantLock mLock = new ReentrantLock(true);
    private static int number = 20;

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest).start();
        new Thread(reentrantLockTest).start();
    }

    private static void fairTest() {
        mLock.lock();
        System.out.println(Thread.currentThread().getName() + "获得锁");
        number--;
        mLock.unlock();
    }

    @Override
    public void run() {
        while (number > 0)
            fairTest();
    }
}
