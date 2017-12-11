package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.deadlock;

/**
 * Created by hs on 2017/12/5.
 * 静态的锁顺序死锁
 */

public class StaticDeadLock {
    //有两个锁A锁和B锁
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    //该方法锁的顺序是lockA,lockB
    private void funA() {
        synchronized (lockA) {
            synchronized (lockB) {
                System.out.println("function A");
            }
        }
    }

    //之前该方法锁的顺序是lockB,lockA,修改后为lockA,lockB
    private void funB() {
        synchronized (lockA) {
            synchronized (lockB) {
                System.out.println("function B");
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        for (int i = 0; i < 50; i++) {
            new Thread(task).start();
        }
    }

    static class Task implements Runnable {
        //共用同一份资源
        private StaticDeadLock staticDeadLock = new StaticDeadLock();

        @Override
        public void run() {
            staticDeadLock.funA();
            staticDeadLock.funB();
        }
    }
}
