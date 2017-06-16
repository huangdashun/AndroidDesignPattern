package huangshun.it.com.androiddesignpattern.unit6_5;

/**
 * Created by hs on 2017/6/16.
 * 生产车的抽象工厂
 */

public abstract class CarFactory {
    //生产轮胎
    public abstract ITire createTire();
    //生产发动机
    public abstract IEngine createEngine();
    //生产制动系统
    public abstract IBrake createBrake();
}
