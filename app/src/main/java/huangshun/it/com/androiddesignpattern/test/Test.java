package huangshun.it.com.androiddesignpattern.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/7/31.
 */

public class Test {
    public static void main(String[] args) {
//        threadTest();
//        assertTest();
        testArrayList();
    }

    private static void testArrayList() {
        List<Integer> mList = new ArrayList<>();
        mList.add(0, 1);
        mList.add(0, 2);
        mList.add(0, 3);
        mList.add(0, 4);

        for (int i = 0; i < mList.size(); i++) {
            System.out.println(mList.get(i));
        }

    }

    private static void assertTest() {
        int a = -3;
        assert a >= 0 : "negative index in method";
    }

    private static void threadTest() {
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
