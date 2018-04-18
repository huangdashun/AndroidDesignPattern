package huangshun.it.com.androiddesignpattern.test.baodian.collection;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hs on 2018/3/14.
 */

public class Deadlock {

    public int flag = 1;

    //静态对象是类的，所有对象共享
    private final static Object o1 = new Object(), o2 = new Object();
    private static Lock mLock = new ReentrantLock();


    public void money(int flag) {
        this.flag = flag;
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o2) {
                    System.out.println("当前的线程：" + Thread.currentThread().getName());
                }
            }
        }

        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("当前的线程：" + Thread.currentThread().getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        Deadlock deadlock1 = new Deadlock();
        Deadlock deadlock2 = new Deadlock();
        deadlock1.flag = 1;
        deadlock2.flag = 0;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadlock1.flag = 1;
                deadlock1.money(1);
            }
        });
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();//等thread1结束后，
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                deadlock2.flag = 0;
                deadlock2.money(0);
            }
        }).start();
    }

    public static void way2() {
        Deadlock deadlock1 = new Deadlock();
        Deadlock deadlock2 = new Deadlock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadlock1.flag = 1;
                try {
                    if (mLock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                        System.out.println("获取到了锁");
                    } else {
                        System.out.println("没有获取到锁");
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {

                    deadlock1.money(1);
                } catch (Exception e) {

                } finally {
                    System.out.println("释放了锁");
                    mLock.unlock();
                }
            }
        });

        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadlock2.flag = 0;

                try {
                    if (mLock.tryLock(5000, TimeUnit.MILLISECONDS)) {

                    } else {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    deadlock2.money(0);
                } catch (Exception e) {

                } finally {
                    mLock.unlock();
                }
            }
        }).start();
    }

}
