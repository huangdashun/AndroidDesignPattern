package huangshun.it.com.androiddesignpattern.unit13_1;

/**
 * Created by hs on 2017/7/19.
 * 备忘录类
 * 用于存储Originator的内部状态,并且可以防止Originator以外的对象访问Memento
 */

public class Memoto {
    public int mCheckPoint ;
    public int mLifeValue ;
    public String mWeapon;

    @Override
    public String toString() {
        return "Memoto{" +
                "mCheckPoint=" + mCheckPoint +
                ", mLifeValue=" + mLifeValue +
                ", mWeapon='" + mWeapon + '\'' +
                '}';
    }
}
