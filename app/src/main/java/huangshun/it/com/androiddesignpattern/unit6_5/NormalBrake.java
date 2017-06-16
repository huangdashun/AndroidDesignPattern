package huangshun.it.com.androiddesignpattern.unit6_5;

/**
 * Created by hs on 2017/6/16.
 */

public class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("普通制动");
    }
}
