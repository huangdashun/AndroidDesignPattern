package huangshun.it.com.androiddesignpattern.unit12_1;

/**
 * Created by hs on 2017/7/16.
 * 抽象的观察者
 */

public abstract class Observer {
    abstract void update(String content);//当被观察者发生了改变,观察者将更新
}
