package huangshun.it.com.androiddesignpattern.test.baodian.await;

/**
 * Created by hs on 2017/12/7.
 */

public class Add {
    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyThing");
            lock.notifyAll();

        }
    }
}
