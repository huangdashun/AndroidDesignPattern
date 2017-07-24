package huangshun.it.com.androiddesignpattern.rxjava.demo;

/**
 * Created by hs on 2017/7/20.
 */

public class TripObservable extends Observable {
    public void change(String state) {
        notifyObserver(state);
    }
}
