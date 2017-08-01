package huangshun.it.com.androiddesignpattern.test.extend;

/**
 * Created by hs on 2017/7/31.
 */

public class Test2 {
    public static void main(String[] args) {
        Bong3 bong3 = new Bong3();
        Bong4 bong4 = new Bong4();

        bong4.setStepOver();
        bong4.next();

        bong3.setStepOver();

    }
}
