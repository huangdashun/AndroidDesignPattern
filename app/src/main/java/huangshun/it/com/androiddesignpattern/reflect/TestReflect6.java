package huangshun.it.com.androiddesignpattern.reflect;

import java.lang.reflect.Method;

/**
 * Created by hs on 2017/7/21.
 * 通过反射机制调用某个类的方法
 */

public class TestReflect6 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("huangshun.it.com.androiddesignpattern.reflect.TestReflect6");
        //调用reflect1的方法
        Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());
        //调用reflect2的方法
        method = clazz.getMethod("reflect2", int.class, String.class);
        method.invoke(clazz.newInstance(), 22, "黄顺");

    }

    public void reflect1() {
        System.out.println("Java 反射机制 - 调用某个类的方法1.");
    }

    public void reflect2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }
}
