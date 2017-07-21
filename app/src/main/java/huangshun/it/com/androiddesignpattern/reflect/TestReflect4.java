package huangshun.it.com.androiddesignpattern.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import huangshun.it.com.androiddesignpattern.unit14_1.Iterator;

/**
 * Created by hs on 2017/7/21.
 * 获取某个类的全部属性
 *
 *
 */

public class TestReflect4 extends Test4 implements Iterator{
//    private static final long serialVersionUID = -2862585049955236662L;
    public int a = 123;
    public String str = "234";

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("huangshun.it.com.androiddesignpattern.reflect.TestReflect4");
        System.out.println("============本类属性============");
        //取得本类的全部属性
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            //权限修饰符
            int modifiers = fields[i].getModifiers();
            String modifierStr = Modifier.toString(modifiers);
            System.out.println(modifierStr);
            //属性类型
            Class<?> type = fields[i].getType();
            System.out.println(type.getName());
            System.out.println(modifierStr + " " + type.getName() + " " + fields[i].getName() + ";");

        }

        System.out.println("============实现的父类的属性============");
//        Class<?> superclass = clazz.getSuperclass();
        Field[] fields1 = clazz.getFields();
        for (int i = 0; i < fields1.length; i++) {
            //权限修饰符
            int modifiers = fields1[i].getModifiers();
            String modifierStr = Modifier.toString(modifiers);
            Class<?> type = fields1[i].getType();
            System.out.println(modifierStr + " " + type.getName() + " " + fields1[i].getName() + ";");

        }

        System.out.println("============实现的接口或者父类的属性============");
        Class<?>[] interfaces = clazz.getInterfaces();

    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
