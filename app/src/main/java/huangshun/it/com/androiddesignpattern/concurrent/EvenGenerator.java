package huangshun.it.com.androiddesignpattern.concurrent;

/**
 * Created by hs on 2017/11/12.
 */

public class EvenGenerator extends IntGenerator {
    private int num;

    @Override
    public synchronized int next() {
        num++;
        Thread.yield();
        num++;
        return num;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator(), 2);
    }
}
