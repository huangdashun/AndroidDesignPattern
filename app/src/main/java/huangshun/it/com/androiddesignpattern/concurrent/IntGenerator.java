package huangshun.it.com.androiddesignpattern.concurrent;

/**
 * Created by hs on 2017/11/12.
 */

public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public boolean isCanceled() {
        return canceled;
    }

    public void cancel() {
        canceled = true;
    }
}
