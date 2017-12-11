package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.synchronize;

/**
 * Created by hs on 2017/12/5.
 */

public class SynchronizedTest {
    public static void main(String[] args) {
        new SynchronizedTest().method1();
    }

    private static void method1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("方法1获得SynchronizedTest的锁了");
            method2();
        }
    }

    private static void method2() {
        synchronized (SynchronizedTest.class) {
            System.out.println("方法2获得SynchronizedTest的锁了");
        }
    }
}
