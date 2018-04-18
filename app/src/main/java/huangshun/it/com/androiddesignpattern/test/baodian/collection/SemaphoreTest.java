package huangshun.it.com.androiddesignpattern.test.baodian.collection;

import java.util.concurrent.Semaphore;

/**
 * Created by hs on 2018/3/14.
 * 信号量，控制某个方法允许并发访问的个数
 */

public class SemaphoreTest {

    private static Semaphore sSemaphore = new Semaphore(5, true);//限制5个


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            }).start();

        }
    }

    public static void test() {
        try {
            sSemaphore.acquire();//请求一个信号量
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sSemaphore.release();//释放一个请求

    }
}
