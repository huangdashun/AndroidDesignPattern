package huangshun.it.com.androiddesignpattern.concurrent;

/**
 * Created by hs on 2017/11/12.
 */

public class PairChecker implements Runnable {
    PairManager mPairManager;

    public PairChecker(PairManager pairManager) {
        mPairManager = pairManager;
    }

    @Override
    public void run() {
        while (true){
           mPairManager.checkCounter.incrementAndGet();
            mPairManager.getPair().checkState();
        }
    }
}
