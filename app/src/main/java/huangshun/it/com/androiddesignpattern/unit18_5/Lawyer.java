package huangshun.it.com.androiddesignpattern.unit18_5;

/**
 * Created by hs on 2017/8/14.
 */

public class Lawyer implements ILawsuit {
    private ILawsuit mXiaoMin;

    public Lawyer(ILawsuit xiaoMin) {
        mXiaoMin = xiaoMin;
    }

    @Override
    public void submit() {
        mXiaoMin.submit();
    }

    @Override
    public void burden() {
        mXiaoMin.burden();
    }

    @Override
    public void defend() {
        mXiaoMin.defend();
    }

    @Override
    public void finish() {
        mXiaoMin.finish();
    }
}
