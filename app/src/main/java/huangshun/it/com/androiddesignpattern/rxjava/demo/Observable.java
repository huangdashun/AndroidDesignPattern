package huangshun.it.com.androiddesignpattern.rxjava.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/7/20.
 */

public abstract class Observable {
    private static final String TAG = "Observable";
    private List<Observer> observers = new ArrayList<>();

    /**
     * 添加女朋友
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("新交了一个女朋友");

    }

    /**
     * 和女朋友白白了
     *
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("跟她白白");;
    }

    /**
     * 通知所有的女朋友更新状态
     *
     * @param state
     */
    public void notifyObserver(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
