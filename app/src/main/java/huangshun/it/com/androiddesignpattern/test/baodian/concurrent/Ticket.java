package huangshun.it.com.androiddesignpattern.test.baodian.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hs on 2017/12/5.
 */

public class Ticket implements Runnable {

    //一共一百张票
    private int mTicketCount = 100;

    private ReentrantLock mLock = new ReentrantLock();
    //解决方式
    @Override
    public void run() {
        while (mTicketCount > 0) {
            try {
                Thread.sleep(100);
                mLock.lock();
                if (mTicketCount > 0) {
                    //输出卖票信息
                    System.out.println(Thread.currentThread().getName() + " 剩余" + --mTicketCount);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        //创建一个线程任务对象
        Ticket ticket = new Ticket();
        //创建4个线程同时卖票
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);
        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
