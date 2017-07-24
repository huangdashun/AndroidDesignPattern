package huangshun.it.com.androiddesignpattern.rxjava.demo;

/**
 * Created by hs on 2017/7/20.
 */

public class HaHaObserver implements Observer {
    private static final String TAG = "HaHaObserver";

    @Override
    public void update(String content) {
        System.out.println("update() called with " + "content = [" + content + "]");

    }
}
