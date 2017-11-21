package huangshun.it.com.androiddesignpattern.test.baodian.reflect;

import org.greenrobot.greendao.annotation.Entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by hs on 2017/11/21.
 */

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //执行静态块,不执行动态块
        Class classForName = Class.forName("huangshun.it.com.androiddesignpattern.test.baodian.reflect.People");
        //不执行静态块和动态构造块
        Class<People> peopleClass = People.class;
        //需要创建对象,静态块和动态块都执行
        People people = new People();
        Class<? extends People> peopleGetClass = people.getClass();
        //获取class对象所有的属性
        Field[] declaredFields = peopleClass.getDeclaredFields();
        //获取class对象公共的属性
        Field[] publicFields = peopleClass.getFields();
        //获取class对象指定属性
        Field nameField = peopleClass.getDeclaredField("name");
        //获取class对象指定的公共属性
        Field idField = peopleClass.getField("id");

        //获取class对象所有的方法
        Method[] declaredMethods = peopleClass.getDeclaredMethods();
        //获取class对象公共的方法
        Method[] publicMethods = peopleClass.getMethods();
        //获取class对象指定的方法
        Method getNameMethod = peopleClass.getDeclaredMethod("getName", String.class);
        //获取class对象指定的公共方法
        Method getAgeMethod = peopleClass.getMethod("getAge", String.class);

        //获取class对象所有的构造函数
        Constructor<?>[] declaredConstructors = peopleClass.getDeclaredConstructors();
        //获取class对象所有的公共的函数
        Constructor<?>[] publicConstructors = peopleClass.getConstructors();
        //获取指定声明参数的构造函数
        Constructor<People> declaredConstructor = peopleClass.getDeclaredConstructor(String.class);
        //获取指定声明参数的public构造函数
        Constructor<People> publicConstructor = peopleClass.getConstructor(String.class);

        //获取class对象的所有注解
        Annotation[] annotations = peopleClass.getAnnotations();
        //获取class对象的执行注解
        Entity annotation = peopleClass.getAnnotation(Entity.class);
        //获取class对象的直接超类的Type(即带有泛型的父类)
        Type genericSuperclass = peopleClass.getGenericSuperclass();
        //获取class对象的所有接口的type集合
        Type[] genericInterfaces = peopleClass.getGenericInterfaces();

        //第一种:会调用默认的构造器来创建实例
//        People peopleObject = peopleClass.newInstance();
        //第二种:先获得对应的Constructor对象,在通过该Constructor对象的newInstance创建实例
        Constructor<People> constructor = peopleClass.getDeclaredConstructor(String.class);
        constructor.newInstance("我是人");

        //1.首先要生成对象
//        Object peopleObject = peopleClass.newInstance();
        //2.获取Method方法
        Method setAgeMethod = peopleClass.getDeclaredMethod("setAge", int.class);
        //调用invoke
//        setAgeMethod.invoke(peopleObject, 23);

        setAgeMethod.setAccessible(true);


        //1.首先要生成对象
        Object peopleObject = peopleClass.newInstance();
        //2.获取成员变量
        Field ageField = peopleClass.getDeclaredField("age");
        //3.设置值
        ageField.setInt(peopleObject, 23);
        //4.获取值
        int age = ageField.getInt(peopleObject);
    }
}
