package huangshun.it.com.androiddesignpattern.concurrent;

/**
 * Created by hs on 2017/11/11.
 */

public class YieldTest implements Runnable {

    private static int taskCount = 0;
    private final int id = taskCount++;

    public static void main(String[] args) {
        Runnable runnable = new YieldTest();
    }

    @Override
    public void run() {

    }
}
