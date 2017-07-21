package huangshun.it.com.androiddesignpattern.reflect;

/**
 * Created by hs on 2017/7/21.
 * 实例化Class类对象
 */

public class TestReflect1 {
    public static void main(String[] args) {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;

        try {
            class1 = Class.forName("huangshun.it.com.androiddesignpattern.reflect.TestReflect1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        class2 = new TestReflect1().getClass();
        class3 = TestReflect1.class;
        System.out.println("类名称   " + class1.getName());
        System.out.println("类名称   " + class2.getName());
        System.out.println("类名称   " + class3.getName());

    }

}
