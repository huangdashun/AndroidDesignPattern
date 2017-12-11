package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.reentrainlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hs on 2017/12/8.
 */

public class ReentrantTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        ReentrantProduct reentrantProduct = new ReentrantProduct(reentrantLock, condition);
        ReentrantConsumer reentrantConsumer = new ReentrantConsumer(reentrantLock, condition);

        for (int i = 0; i < 3; i++) {
            ReentrantProductThread pThread = new ReentrantProductThread(reentrantProduct);
            ReentrantConsumerThread cThread = new ReentrantConsumerThread(reentrantConsumer);
            pThread.start();
            cThread.start();
        }
    }
}
