package huangshun.it.com.androiddesignpattern.unit2_6;

/**
 * Created by hs on 2017/5/28.
 * 静态内部类的单例模式
 */

public class SingletonInner {
    private SingletonInner() {

    }

    public static SingletonInner getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final SingletonInner sInstance = new SingletonInner();
    }
}
