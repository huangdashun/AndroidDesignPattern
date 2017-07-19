package huangshun.it.com.androiddesignpattern.unit12_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/7/16.
 * 具体的被观察者
 */

public class ConcreteObservable extends Observable {
    private List<Observer> mObserverList = new ArrayList<>();

    @Override
    void postNewPublication(String content) {
        for (Observer observer : mObserverList) {
            observer.update(content);
        }
    }

    @Override
    void addObserver(Observer observer) {
        mObserverList.add(observer);
    }
}
