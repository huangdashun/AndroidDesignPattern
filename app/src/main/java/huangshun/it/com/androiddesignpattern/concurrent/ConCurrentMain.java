package huangshun.it.com.androiddesignpattern.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by hs on 2017/11/11.
 */

public class ConCurrentMain {
    private static List<Future<String>> data = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService mCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            data.add(mCachedThreadPool.submit(new CallableTest(i)));
        }

        for (int i = 0; i < 5; i++) {
            try {
                String s = data.get(i).get();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                mCachedThreadPool.shutdown();
            }

        }
    }
}
