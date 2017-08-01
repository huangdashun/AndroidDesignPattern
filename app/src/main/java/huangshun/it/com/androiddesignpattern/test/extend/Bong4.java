package huangshun.it.com.androiddesignpattern.test.extend;

/**
 * Created by hs on 2017/7/31.
 */

public class Bong4 extends Bong3 {

    protected void setStepOver() {
        System.out.println("我是bong4");
    }

    protected void next() {
        super.setStepOver();
    }
}
