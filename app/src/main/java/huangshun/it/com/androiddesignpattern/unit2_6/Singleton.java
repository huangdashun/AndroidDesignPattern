package huangshun.it.com.androiddesignpattern.unit2_6;

import java.io.ObjectStreamException;

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

    /**
     * 防止单例对象在被反序列化时重新生成对象
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return singleton;
    }
}
