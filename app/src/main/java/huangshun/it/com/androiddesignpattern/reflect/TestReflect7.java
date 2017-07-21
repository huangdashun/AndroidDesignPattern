package huangshun.it.com.androiddesignpattern.reflect;

import java.lang.reflect.Field;

/**
 * Created by hs on 2017/7/21.
 * 通过反射机制操作某个类的属性
 */

public class TestReflect7 {
    private String property = null;

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("huangshun.it.com.androiddesignpattern.reflect.TestReflect7");
        Object object = (TestReflect7) clazz.newInstance();

        Field property = clazz.getDeclaredField("property");
        property.setAccessible(true);
        property.set(object, "黄顺");

        System.out.println(property.get(object));
    }
}
