package huangshun.it.com.androiddesignpattern.test.genericity;

/**
 * Created by hs on 2017/7/4.
 */

public class Box<T> {
    private T data;

    public Box() {

    }

    public void setDataK(T t) {
        data = t;
    }


    public T getData() {
        return data;
    }

    public <V> V test(V s) {
        return s;
    }
}
