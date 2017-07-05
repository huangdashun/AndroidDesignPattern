package huangshun.it.com.androiddesignpattern.unit10_5;

/**
 * Created by hs on 2017/7/4.
 * 加法运算抽象解释器
 */

public class AdditionExpression extends OperatorExpression {

    public AdditionExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        super(exp1, exp2);
    }

    @Override
    public int interpreter() {
        return exp1.interpreter() + exp2.interpreter();
    }
}
