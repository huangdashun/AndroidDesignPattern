package huangshun.it.com.androiddesignpattern.test.algorithm.unit2.stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by hs on 2017/12/10.
 */

public class StackTest {
    public static void main(String[] args) {
//        printData();
//        test1();

    }

    private static void test1() {
        ResizingArrayStack<Integer> integers = new ResizingArrayStack<>();
        integers.push(10);
        integers.push(20);
//        Integer pop = integers.pop();
//        System.out.println(pop);
//        Integer pop2 = integers.pop();
//        System.out.println(pop2);
        for (Integer num : integers) {
            System.out.println(num);

        }
        ReverseArrayIterator<Integer> iterator = (ReverseArrayIterator<Integer>) integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
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
