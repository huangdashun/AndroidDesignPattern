package huangshun.it.com.androiddesignpattern.concurrent;

import java.util.concurrent.Callable;

/**
 * Created by hs on 2017/11/11.
 */

public class CallableTest implements Callable<String> {

    private int id;

    public CallableTest(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "id的值为" + id;
    }
}
