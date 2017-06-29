package huangshun.it.com.androiddesignpattern.unit8_1;

/**
 * Created by hs on 2017/6/29.
 */

public class Test {
    public static void main(String[] args) {
        TvController tvController = new TvController();
        tvController.powerOff();
        tvController.nextChannel();
        tvController.prevChannel();
        tvController.turnUp();
        tvController.turnDown();
        tvController.powerOn();
        tvController.nextChannel();
        tvController.prevChannel();
        tvController.turnUp();
        tvController.turnDown();
    }
}
