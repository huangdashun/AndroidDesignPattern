package huangshun.it.com.androiddesignpattern.unit18_5;

import java.lang.reflect.Proxy;

/**
 * Created by hs on 2017/8/14.
 */

public class Test182 {
    public static void main(String[] args) {
        ILawsuit xiaoming = new XiaoMin();

        DynamicProxy dynamicProxy = new DynamicProxy(xiaoming);

        ILawsuit lawsuit = (ILawsuit) Proxy.newProxyInstance(xiaoming.getClass().getClassLoader(), new Class[]{ILawsuit.class}, dynamicProxy);

        lawsuit.submit();
        lawsuit.burden();
        lawsuit.defend();
        lawsuit.finish();

    }
}
