package huangshun.it.com.androiddesignpattern.unit5_5;

/**
 * Created by hs on 2017/6/9.
 */

public class AudiQ5 extends AudiCar {
    @Override
    void drive() {
        System.out.println("Q5开跑了");
    }

    @Override
    void selfNavigation() {
        System.out.println("Q5开启自动导航");
    }
}
