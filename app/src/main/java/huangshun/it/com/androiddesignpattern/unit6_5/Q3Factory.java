package huangshun.it.com.androiddesignpattern.unit6_5;

/**
 * Created by hs on 2017/6/16.
 */

public class Q3Factory extends CarFactory {
    @Override
    public ITire createTire() {
        return new NormalTire();
    }

    @Override
    public IEngine createEngine() {
        return new DomesticEngline();
    }

    @Override
    public IBrake createBrake() {
        return new NormalBrake();
    }
}
