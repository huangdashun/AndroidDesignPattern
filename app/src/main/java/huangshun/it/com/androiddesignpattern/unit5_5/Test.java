package huangshun.it.com.androiddesignpattern.unit5_5;

/**
 * Created by hs on 2017/6/9.
 */

public class Test {
    public static void main(String[] args) {
        AudiCarFactory audiCarFactory = new AudiCarFactory();
        AudiQ3 audiQ3 = audiCarFactory.createCar(AudiQ3.class);
        audiQ3.drive();
        audiQ3.selfNavigation();
        AudiQ5 audiQ5 = audiCarFactory.createCar(AudiQ5.class);
        audiQ5.drive();
        audiQ5.selfNavigation();
        AudiQ7 audiQ7 = audiCarFactory.createCar(AudiQ7.class);
        audiQ7.drive();
        audiQ7.selfNavigation();
    }
}
