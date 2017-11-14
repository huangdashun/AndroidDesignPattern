package huangshun.it.com.androiddesignpattern.concurrent;

/**
 * Created by hs on 2017/11/12.
 */

public class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair tmp;
        synchronized (PairManager2.this) {
            p.incrementX();
            p.incrementY();
            tmp = getPair();
        }
        store(tmp);
    }
}
