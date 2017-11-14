package huangshun.it.com.androiddesignpattern.concurrent;

/**
 * Created by hs on 2017/11/12.
 */

public class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
