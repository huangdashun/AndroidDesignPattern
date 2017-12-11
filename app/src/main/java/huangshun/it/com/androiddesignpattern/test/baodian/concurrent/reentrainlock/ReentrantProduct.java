package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.reentrainlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import huangshun.it.com.androiddesignpattern.test.baodian.product.StringObject;

/**
 * Created by hs on 2017/12/8.
 */

public class ReentrantProduct {
    private ReentrantLock mLock;
    private Condition mCondition;

    public ReentrantProduct(ReentrantLock lock, Condition condition) {
        mLock = lock;
        mCondition = condition;
    }

    public void setValue() {
        try {
            mLock.lock();
            while (!StringObject.value.equals("")) {
                //有值，不生产
                mCondition.await();
            }
            String value = System.currentTimeMillis() + "" + System.nanoTime();
            System.out.println("set的值是：" + value);
            StringObject.value = value;
            mCondition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }
}
