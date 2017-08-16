package huangshun.it.com.androiddesignpattern.unit18_5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hs on 2017/8/14.
 */

public class DynamicProxy implements InvocationHandler {
    private Object mObject;//被代理的引用

    public DynamicProxy(Object object) {
        mObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(mObject, args);
        return result;
    }
}
