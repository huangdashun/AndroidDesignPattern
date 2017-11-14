package huangshun.it.com.androiddesignpattern.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hs on 2017/11/12.
 */

public class EvenChecker implements Runnable {
    private IntGenerator mGenerator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        mGenerator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!mGenerator.isCanceled()) {
            int val = mGenerator.next();
            if (val % 2 != 0) {//奇数
                System.out.println(val + "not event");
                mGenerator.cancel();
            }
            if (val == 1000) {
                System.out.println(val + "等于1000");
                mGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            service.execute(new EvenChecker(generator, count));
        }
        service.shutdown();
    }
}
