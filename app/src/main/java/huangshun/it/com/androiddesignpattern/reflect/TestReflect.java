package huangshun.it.com.androiddesignpattern.reflect;

/**
 * Created by hs on 2017/7/21.
 * 通过一个对象获得完整的包名和类名
 */

public class TestReflect {
    public static void main(String[] args) {
        TestReflect testReflect = new TestReflect();
        System.out.println(testReflect.getClass().getName());
        System.out.println(testReflect.getClass().getSimpleName());
        System.out.println(testReflect.getClass().getCanonicalName());
    }

}
