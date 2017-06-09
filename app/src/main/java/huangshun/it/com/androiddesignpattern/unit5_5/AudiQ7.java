package huangshun.it.com.androiddesignpattern.unit5_5;

/**
 * Created by hs on 2017/6/9.
 */

public class AudiQ7 extends AudiCar {
    @Override
    void drive() {
        System.out.println("Q7开跑了");
    }

    @Override
    void selfNavigation() {
        System.out.println("Q7开启自动导航");
    }
}
