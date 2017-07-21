package huangshun.it.com.androiddesignpattern.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hs on 2017/7/21.
 * 反射机制的动态代理
 */

public class TestReflect8 {

    public static void main(String[] args) throws Exception {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Subject sub = (Subject) myInvocationHandler.bind(new RealSubject());
        String say = sub.say("黄顺", 20);
        System.out.println(say);
    }
}

//定义项目接口
interface Subject {
    public String say(String name, int age);
}

//定义真实项目

class RealSubject implements Subject {

    @Override
    public String say(String name, int age) {
        return name + " " + age;
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj = null;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object temp = method.invoke(this.obj, args);
        return temp;
    }
}