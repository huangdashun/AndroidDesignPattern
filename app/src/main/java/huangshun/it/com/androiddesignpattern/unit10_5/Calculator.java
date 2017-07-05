package huangshun.it.com.androiddesignpattern.unit10_5;

import java.util.Stack;

/**
 * Created by hs on 2017/7/4.
 * 处理与解释相关的一些业务
 */

public class Calculator {
    private Stack<ArithmeticExpression> mExpressionStack = new Stack<>();

    public Calculator(String expression) {
        //声明两个ArithmeticExpression类型的临时变量,存储云算符左右两边的数字解释器
        ArithmeticExpression exp1, exp2;
        String[] elements = expression.split(" ");
        for (int i = 0; i < elements.length; i++) {
            switch (elements[i].charAt(0)) {
                case '+':
                    exp1 = mExpressionStack.pop();
                    exp2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mExpressionStack.push(new AdditionExpression(exp1, exp2));
                    break;
                default:
                    mExpressionStack.push(new NumExpression(Integer.valueOf(elements[i])));
                    break;
            }
        }

    }

    public int calculate() {
        return mExpressionStack.pop().interpreter();
    }
}
