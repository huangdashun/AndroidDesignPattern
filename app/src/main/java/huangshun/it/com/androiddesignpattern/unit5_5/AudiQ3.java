package huangshun.it.com.androiddesignpattern.unit5_5;

/**
 * Created by hs on 2017/6/9.
 */

public class AudiQ3 extends AudiCar {
    @Override
    void drive() {
        System.out.println("Q3开跑了");
    }

    @Override
    void selfNavigation() {
        System.out.println("Q3开启自动导航");
    }
}
