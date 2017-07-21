package huangshun.it.com.androiddesignpattern.reflect;

import java.io.Serializable;

/**
 * Created by hs on 2017/7/21.
 * 获取一个对象的父类与实现的接口
 */

public class TestReflect2 implements Serializable {
    private static final long serialVersionUID = -2862585049955236662L;


    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("huangshun.it.com.androiddesignpattern.reflect.TestReflect2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //取得父类
        Class<?> superclass = clazz.getSuperclass();
        System.out.println("clazz的父类为:" + superclass.getName());
        if (clazz.getInterfaces() == null) {
            System.out.println("没有实现任何接口");
        }
        //获取所有的接口
        Class<?>[] interfaces = clazz.getInterfaces();
//        for (Class<?> anInterface : interfaces) {
//            System.out.println("clazz实现的接口有" + anInterface.getName());
//        }
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i]);
        }

    }

}
