package huangshun.it.com.androiddesignpattern.unit12_1;

/**
 * Created by hs on 2017/7/16.
 */

public class Test {
    public static void main(String args[]) {
        Coder coder1 = new Coder("安卓爱好者");
        Coder coder2 = new Coder("前端爱好者");
        Coder coder3 = new Coder("ios爱好者");

        Observable observable = new ConcreteObservable();
        observable.addObserver(coder1);
        observable.addObserver(coder2);
        observable.addObserver(coder3);

        observable.postNewPublication("CSDN");
    }
}
