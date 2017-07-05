package huangshun.it.com.androiddesignpattern.unit10_5;

/**
 * Created by hs on 2017/7/4.
 * 数字解释器,仅仅为了解释数字
 */

public class NumExpression extends ArithmeticExpression {
    private int num;

    public NumExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpreter() {
        return num;
    }
}
