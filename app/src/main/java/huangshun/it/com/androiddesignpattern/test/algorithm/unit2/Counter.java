package huangshun.it.com.androiddesignpattern.test.algorithm.unit2;

/**
 * Created by hs on 2017/12/10.
 * 计数器
 */

public class Counter {
    private int mCount;


    public void increment() {
        mCount++;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "mCount=" + mCount +
                '}';
    }
}
