package huangshun.it.com.androiddesignpattern.test.baodian.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * Created by hs on 2017/11/23.
 */

public class DynamicProxy {
    public static void main(String[] args) {
        //1.创建目标对象
        RealSubject realSubject = new RealSubject();
        //2.创建调用处理器对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        //3.动态生成代理对象
        //参数1.需要代理的对象的ClassLoader,2.需要代理的对象实现的接口.3.InvocationHandler
        DynamicSubject subject = (DynamicSubject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), myInvocationHandler);
        //通过代理对象调用方法
//        subject.doWork();
        subject.sleep();
    }

    //目标对象
    static class RealSubject implements DynamicSubject {

        @Override
        public void doWork() {
            System.out.println("RealSubject doWork");
        }

        @Override
        public void sleep() {
            System.out.println("RealSubject sleep");
        }
    }

    //创建一个行为接口
    interface DynamicSubject {
        void doWork();

        void sleep();
    }

    //创建一个调用处理器,当调用动态代理的方法时,将会直接转接到invoke方法
    static class MyInvocationHandler implements InvocationHandler {
        private Object mSubject;

        public MyInvocationHandler(Object subject) {
            mSubject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //可以根据Method的不同处理不同的预处理工作
            if (method.getName().equals("sleep")) {
                //可以添加预处理代码
                System.out.println("before sleep  invoke method");
                Object obj = method.invoke(mSubject, args);
                //可以添加收尾代码
                System.out.println("after sleep invoke method");
            } else {
                //可以添加预处理代码
                System.out.println("before invoke method");
                method.invoke(mSubject, args);
                //可以添加收尾代码
                System.out.println("after invoke method");
            }

            return mSubject;
        }
    }
}
