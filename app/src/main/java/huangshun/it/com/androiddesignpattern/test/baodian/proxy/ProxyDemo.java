package huangshun.it.com.androiddesignpattern.test.baodian.proxy;

/**
 * Created by hs on 2017/11/23.
 */

public class ProxyDemo {
    public static void main(String[] args) {
        //5,客户端想调用目标对象的行为接口,只能通过代理类
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.doWork();
    }
}

//1.创建一个行为接口,由目标对象和代理对象共同实现
interface Subject {
    void doWork();
}

//2.1  目标对象实现接口逻辑
class RealSubject implements Subject {

    @Override
    public void doWork() {
        System.out.println("real doWork");
    }
}

//2.1 代理对象实现逻辑接口
class Proxy implements Subject {
    private Subject mSubject;

    //3.在代理类中实例化一个目标对象
    public Proxy(Subject subject) {
        mSubject = subject;
    }

    @Override
    public void doWork() {
        System.out.println("PreProcess");
        //4.在代理类中调用目标对象的行为接口
        mSubject.doWork();
        System.out.println("PostProcess");
    }
}
