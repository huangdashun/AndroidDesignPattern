package huangshun.it.com.androiddesignpattern.test;

/**
 * Created by hs on 2017/11/14.
 */

public class ThreadTest implements Runnable {
    private String result;
    private Object prev;
    private Object self;

    public ThreadTest(String result, Object prev, Object self) {
        this.result = result;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.println(result);
                    count--;

                    self.notify();
                }
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        }
    }
}
