package huangshun.it.com.androiddesignpattern.test.baodian.product;

/**
 * Created by hs on 2017/12/8.
 */

public class ConsumerThread extends Thread {

    private Consumer mConsumer;

    public ConsumerThread(Consumer consumer) {
        mConsumer = consumer;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            mConsumer.consumerProduct();
        }

    }
}
