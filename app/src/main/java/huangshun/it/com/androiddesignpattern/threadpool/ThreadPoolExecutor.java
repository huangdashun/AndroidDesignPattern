package huangshun.it.com.androiddesignpattern.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by hs on 2017/10/31.
 */

public class ThreadPoolExecutor {
    //线程池的核心线程数,除非将allowCoreThreadTimeOut设置为true(则由keepAliveTime指定超时时间,超时会被终止)
    //否则核心线程会即时闲置也不会终止
    int corePoolSize;
    //最大线程数,活动线程数超过该数量,后续会排队
    int maximumPoolSize;
    //超时时长,作用于非核心线程和将allowCoreThreadTimeOut设置为true的核心线程
    long keepAliveTime;
    //时间单位,用于指定keepAliveTime,单位有TimeUnit.MILLISECONDS,TimeUnit.SECONDS等
    TimeUnit unit;
    //线程池的任务队列,通过线程池的execute方法提交的Runnable会储存该队列
    BlockingQueue<Runnable> workQueue;
    //线程工厂接口,只有一个方法Thread new Thread(Runnable r),可以为线程池创建新线程
    ThreadFactory threadFactory;

    public void Test() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是newSingleThreadExecutor");
            }
        };
        Executors.newSingleThreadExecutor().execute(task);
    }

    public static void main(String[] args) {
        String str = "12.32_123";
        String[] split = str.split("_");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }
}
