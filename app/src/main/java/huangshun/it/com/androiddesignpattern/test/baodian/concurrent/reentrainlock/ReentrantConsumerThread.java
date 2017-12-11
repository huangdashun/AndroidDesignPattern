package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.reentrainlock;

/**
 * Created by hs on 2017/12/8.
 */

public class ReentrantConsumerThread extends Thread {

    private ReentrantConsumer mReentrantConsumer;

    public ReentrantConsumerThread(ReentrantConsumer consumer) {
        mReentrantConsumer = consumer;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            mReentrantConsumer.getValue();
        }
    }
}
