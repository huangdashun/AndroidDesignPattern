package huangshun.it.com.androiddesignpattern.test.algorithm.unit2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by hs on 2017/12/10.
 */

public class Calculate {
    public static void main(String[] args) {
//        calculate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        System.out.println(calculate());
    }

    private static Double calculate() {
        //需要两个栈，一个是操作数栈，一个运算符栈
        //操作数栈
        Stack<Double> numberStack = new Stack<>();
        //运算符栈
        Stack<String> operatorStack = new Stack<>();
        In in = new In("/Users/huangshun/Desktop/test/new2");

        while (!in.isEmpty()) {
            String temp = in.readString();
            if (temp.equals("+") || temp.equals("-") ||
                    temp.equals("*") || temp.equals("/")
                    || temp.equals("sqrt")) {
                operatorStack.push(temp);
            } else if (temp.equals(")")) {
                String operator = operatorStack.pop();
                Double number = numberStack.pop();
                if (operator.equals("+")) {
                    numberStack.push(number + numberStack.pop());
                } else if (operator.equals("-")) {
                    numberStack.push(numberStack.pop() - number);
                } else if (operator.equals("*")) {
                    numberStack.push(number * numberStack.pop());
                } else if (operator.equals("/")) {
                    numberStack.push(numberStack.pop() / number);
                } else if (operator.equals("sqrt")) {
                    numberStack.push(Math.sqrt(number));
                }
            } else if (temp.equals("(")) {

            } else {
                numberStack.push(Double.parseDouble(temp));
            }
        }
        return numberStack.pop();
    }

}
