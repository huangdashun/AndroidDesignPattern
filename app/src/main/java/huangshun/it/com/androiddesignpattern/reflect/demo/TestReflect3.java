package huangshun.it.com.androiddesignpattern.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hs on 2017/7/21.
 */

public class TestReflect3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("huangshun.it.com.androiddesignpattern.reflect.demo.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //第一种方法,实例化默认构造方法,调用set赋值
        User user = (User) clazz.newInstance();
        user.setAge(22);
        user.setName("黄顺");
        System.out.println(user);

        //第二种方法 取得全部的构造函数 使用构造函数赋值
        Constructor<?>[] constructors = clazz.getConstructors();
        //查看每个构造方法需要的参数
        for (int i = 0; i < constructors.length; i++) {
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();
            System.out.print("constructors[" + i + "](¬");
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j < parameterTypes.length - 1) {
                    System.out.print(parameterTypes[j].getName());
                } else {
                    System.out.println(parameterTypes[j].getName() + ",");
                }
                System.out.println(")");
            }
        }

        user = (User) constructors[0].newInstance(22,"黄顺");
        System.out.println(user);
        user = (User) constructors[1].newInstance("黄顺");
        System.out.println(user);


    }
}
