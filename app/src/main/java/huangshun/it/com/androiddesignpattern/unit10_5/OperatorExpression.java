package huangshun.it.com.androiddesignpattern.unit10_5;

/**
 * Created by hs on 2017/7/4.
 */

public abstract class OperatorExpression extends ArithmeticExpression {
    protected ArithmeticExpression exp1, exp2;

    public OperatorExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

}
