package huangshun.it.com.androiddesignpattern.test.algorithm.unit2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by hs on 2017/12/8.
 */

public class Practice2 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        CircularRotation();
//        test3();
//        test4();
//        test5();
//        String pop = "(";
//        String pop2 = pop + ")";
//        System.out.println(pop2);
//        System.out.println(pop2.equals("()"));
//        test6();
        test7();
    }

    private static void test7() {
    }

    private static void test6() {
        //1.3.9
        In in = new In("/Users/huangshun/Desktop/test/new2");
        Stack<String> operator = new Stack<>();//存放运算符
        Stack<String> values = new Stack<>();//存放操作数
        while (!in.isEmpty()) {//如果不为空
            String s = in.readString();
//            System.out.println("s:" + s);
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                operator.push(s);
            } else if (s.equals("(")) {//忽略

            } else if (s.equals(")")) {
                //从操作栈里弹出来两个，从运算符中弹出来一个
                String secondValue = values.pop();
                String firstValue = values.pop();
                String tempOper = operator.pop();
                String res = "(" + firstValue + tempOper + secondValue + ")";
                System.out.println("res:" + res);
                values.push(res);

            } else {
                //将操作数add进栈
                values.push(s);
            }
//            System.out.println(s);
        }
        System.out.println(values.pop());
    }

    private static void test5() {
        //1.3.4

        In in = new In("/Users/huangshun/Desktop/test/new2");
        Stack<String> leftOperator = new Stack<>();//左符号

        while (!in.isEmpty()) {
            String letter = in.readString();//读取每一个字母
            System.out.println("letter:" + letter);
            if (letter.equals("{")) {
                leftOperator.push("{");
            } else if (letter.equals("[")) {
                leftOperator.push("[");
            } else if (letter.equals("(")) {
                leftOperator.push("(");
            } else {
                String pop = leftOperator.pop();
                System.out.println("POP:" + pop);
//                if (pop.equals("(") && letter.equals(")")) {
//
//                } else if (pop.equals("[") && letter.equals("]")) {
//
//                } else if (pop.equals("{") && letter.equals("}")) {
//
//                } else {
//                    System.out.println("false");
//                    return;
//                }
                if ((pop + ")").equals("()") || ((pop + "]").equals("[]")) || ((pop + "}").equals("{}"))) {

                } else {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println(leftOperator.isEmpty());
    }

    private static void test4() {
        //1.2.9
        int[] arr = new int[]{1, 2, 3, 5, 12, 13};
        Counter counter = new Counter();
        System.out.println(binerySearch(arr, 13, counter));
        System.out.println(counter.toString());
    }

    private static int binerySearch(int[] arr, int n, Counter counter) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            counter.increment();
            if (n > arr[middle]) {//去右边找
                left = middle + 1;
            } else if (n < arr[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static void test3() {
        System.out.println(mystery("HelloWorld"));
    }

    private static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(a) + mystery(b);

    }

    private static void CircularRotation() {
        //1.2.6回环变位
        String s = "ACTGACG";
        String t = "GACTGAC";
        int i = s.length();
        System.out.println(test3(s, t, i));
    }

    private static Boolean test3(String s, String t, int i) {
        if (i <= 0) {
            return false;
        }
        String str = s.concat(s.charAt(t.length() - i) + "");
        System.out.println(str);
        if (str.contains(t)) {
            return true;
        } else {
            return test3(str, t, --i);
        }
    }

    private static void test2() {
        String str = "Hello World";
        str = str.toUpperCase();
        str = str.substring(6, 11);
        System.out.println(str);
        System.out.println();
    }

    private static void test1() {
        //1.2.4
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1);
        System.out.println(string2);
    }
}
