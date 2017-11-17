package huangshun.it.com.androiddesignpattern.test;

/**
 * Created by hs on 2017/7/31.
 */

public class Test {
    public static void main(String[] args) {
        //三个锁

        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread aThread = new Thread(new ThreadTest("A", c, a));
        Thread bThread = new Thread(new ThreadTest("B", a, b));
        Thread cThread = new Thread(new ThreadTest("C", b, c));

        aThread.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        bThread.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        cThread.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }


}
