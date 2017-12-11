package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.reentrainlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import huangshun.it.com.androiddesignpattern.test.baodian.product.StringObject;

/**
 * Created by hs on 2017/12/8.
 */

public class ReentrantConsumer {
    private ReentrantLock mLock;
    private Condition mCondition;

    public ReentrantConsumer(ReentrantLock lock, Condition condition) {
        mLock = lock;
        mCondition = condition;
    }

    public void getValue() {
        try {
            mLock.lock();
            while (StringObject.value.equals("")) {
                //仓库为空，不进行消费，在此等待
                mCondition.await();
            }
            System.out.println("get的值是：" + StringObject.value);
            StringObject.value = "";
            mCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            mLock.unlock();
        }

    }
}
