package huangshun.it.com.androiddesignpattern.test.baodian.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by hs on 2017/12/5.
 */

//第一步：创建Callable的实现类,并实现call方法
public class CallableTest implements Callable<Integer> {
    public static void main(String[] args) {
        //第二步：创建Callable的实例，并使用FutureTask类来包装Callable的实例
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new CallableTest());
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "循环变量i的值" + i);
            if (i == 8) {
                //第三步：使用FutureTask作为Thread对象的target创建并启动新线程
                new Thread(integerFutureTask, "有返回值的线程").start();
            }
        }
        try {
            //第四步：使用FeatureTask的get方法来获取子线程结束后的返回值
            System.out.println("子线程返回的值：" + integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "" + i);

        }
        return i;
    }
}
