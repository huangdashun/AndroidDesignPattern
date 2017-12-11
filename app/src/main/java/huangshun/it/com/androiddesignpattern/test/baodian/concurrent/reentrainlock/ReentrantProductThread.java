package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.reentrainlock;

/**
 * Created by hs on 2017/12/8.
 */

public class ReentrantProductThread extends Thread {

    private ReentrantProduct mReentrantProduct;

    public ReentrantProductThread(ReentrantProduct product) {
        mReentrantProduct = product;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            mReentrantProduct.setValue();
        }
    }
}
