package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by hs on 2017/12/10.
 */

public class StackTest {
    public static void main(String[] args) {
        printData();
    }

    private static void printData() {
        In in = new In("/Users/huangshun/Desktop/test/new1");
        Stack<Integer> stack = new Stack<>();
        while (!in.isEmpty()) {
            stack.push(in.readInt());
        }

        for (int num : stack
                ) {
            System.out.println(num);
        }
    }
}
