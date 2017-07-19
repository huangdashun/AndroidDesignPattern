package huangshun.it.com.androiddesignpattern.unit12_1;

/**
 * Created by hs on 2017/7/16.
 * 抽象的被观察者
 */

public abstract class Observable {
    abstract void postNewPublication(String content);

    abstract void addObserver(Observer observer);
}
