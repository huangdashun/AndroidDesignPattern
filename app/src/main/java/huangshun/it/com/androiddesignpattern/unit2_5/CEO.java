package huangshun.it.com.androiddesignpattern.unit2_5;

/**
 * Created by hs on 2017/5/28.
 * CEO
 * 饿汉式单例者模式
 */

public class CEO extends Staff {
    private static CEO mCeo = new CEO();

    private CEO() {

    }

    @Override
    public void work() {

    }

    public static CEO getCeo() {
        return mCeo;
    }

}
