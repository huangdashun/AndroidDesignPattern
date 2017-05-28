package huangshun.it.com.androiddesignpattern.unit2_6;

/**
 * Created by hs on 2017/5/28.
 * 懒汉式
 */

public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    //Double CheckLock
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
