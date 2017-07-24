package huangshun.it.com.androiddesignpattern.rxjava.demo;

/**
 * Created by hs on 2017/7/20.
 */

public class Client {
    public static void main(String[] args) {
        HaHaObserver haHaObserver = new HaHaObserver();
        TripObservable tripObservable = new TripObservable();
        tripObservable.attach(haHaObserver);
        tripObservable.change("去玩了哈");

    }
}
