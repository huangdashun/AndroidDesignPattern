package huangshun.it.com.androiddesignpattern.test.algorithm.unit1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by hs on 2017/11/30.
 */

public class practice1 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        System.out.println(test15(6));
//        System.out.println(test16(2, 25));
//        System.out.println(test16(3, 11));
//        for (int i = 0; i < 100; i++) {
//            StdOut.println(i + "" + test17(i));
//        }
//        StdOut.println(test18(5));
//        System.out.println(test19(5));
//        test20();
//        int[] arr = new int[]{1, 4, 5, 6, 7, 8, 10};
//        System.out.println(rank(arr, 10, 0, arr.length - 1));
//        test21();
//        test22();
//        test23();
//        test24();
//        test25();
//        test26();
//        test27();
//        test28();
//        double[][] mult = mult(new double[][]{{1, 2}, {1, -1}}, new double[][]{{1, 2 - 3}, {-1, 1, 2}});
        double[] mult = mult(new double[][]{{1, 2}, {1, 2}}, new double[]{1, 2});
        for (int i = 0; i < (mult != null ? mult.length : 0); i++) {
            System.out.println(mult[i]);
        }
    }

    private static void test28() {
//        1.1 .33

    }

    /**
     * 矩阵和向量相乘
     *
     * @param a
     * @return
     */
    private static double[] mult(double[][] a, double[] b) {
        if (a[0].length != b.length) {
            return null;
        }

        double[] result = new double[b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i] += a[i][j] * b[j];
            }
        }
        return result;
    }

    /**
     * 矩阵与矩阵相乘
     *
     * @return
     */
    private static double[][] mult(double[][] a, double[][] b) {
        if (a.length == b[0].length) {
            //创建要返回的矩阵
            double[][] result = new double[a.length][b[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    for (int k = 0; k < b.length; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return result;
        } else {
            return null;
        }

    }

    private static void test27() {
        //1.1.32
        //一系列的double值
        double[] arr = new double[]{0.13, 1.23, 1.23, 1.42, 2.34, 5.21, 1.24, 1.23, 1.23, 0.13, 1.23};
        //N
        int N = 10;
        //两个double值l和r
        double l = 1.11, r = 5.11;
        //每份占
        double each = (r - l) / N;
        //最大值
        double max = 0;
//        StdDraw.setPenRadius(0.01);
//        StdDraw.setPenColor(Color.Red);
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i] >= l && arr[i] <= r && arr[i] > (each * j) && arr[i] <= (each * (j + 1))) {
                    number[j]++;
                    if (max < arr[j]) {
                        max = arr[j];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
//            StdDraw.filledRectangle(i * each, number[i] / (max * 2), each, number[i] / (max * 2));
            System.out.println(number[i]);
        }

        //绘制直方图
//        StdDraw.filledRectangle();
    }

    private static void test26() {
        //1.1.31
//        int N = StdIn.readInt();
//        double p = StdIn.readDouble();
//        //角度
//        int angle = 360 / N;
//        //画圆
//        StdDraw.circle(0.5, 0.5, 0.5);
//        StdDraw.setPenRadius(0.5);
//        //点
//        Point[] points = new Point[N];
//
//        for (int i = 0; i < N; i++) {
//            points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
//                    0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
//            StdDraw.point(points[i].x, points[i].y);
//        }
//        StdDraw.setPenRadius(0.05);
////        StdDraw.setPenColor(Color.GRAY);
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = i + 1; j < N; j++) {
//                if (StdRandom.bernoulli(p)) {
//                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
//                }
//            }
//        }
    }

    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void test25() {
        //1.1.30
        Boolean[][] arr = new Boolean[5][11];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i > j) {
                    arr[i][j] = isRelativePrime(j, i);
                } else {
                    arr[i][j] = isRelativePrime(i, j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    //两个数是否互质
    private static Boolean isRelativePrime(int n, int m) {
//        System.out.print("n:" + n + "m:" + m);
        if (n == 1 || m == 1 || n == 0 || m == 0) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0 && m % i == 0) {
                return true;
            }
        }
        return false;
    }

    private static void test24() {
        //1.1.28
        int[] arr = new int[]{1, 5, 3, 4, 54, 78, 100, 54, 150, 170};
        //第一步排序
        Arrays.sort(arr);
        int[] result = deleteRepeat(arr);
        //第二步去重
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        int index = BinarySearch.rank(arr, 100);
        System.out.println(index);

    }

    private static int[] deleteRepeat(int[] arr) {
        int[] result = new int[arr.length];
        int num = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                num++;
                result[num] = arr[i];
            }
        }
        result[num + 1] = arr[arr.length - 1];
        return result;
    }

    private static double[] doubleArr = new double[1024];
    private static int sum = 0;

    public static double binomial(int N, int k, double p) {

        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }

        doubleArr[sum] = (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, (1 - p));
        sum++;
        return doubleArr[sum];

    }

    private static void test23() {
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        int t;
        if (a > b) {//a和b换下位置
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        System.out.println(a + " " + b + " " + c);
    }

    private static void test22() {
        //1.1.24
//        euclid(105, 24);
        euclid(1111111, 1234567);
    }

    private static int euclid(int p, int q) {
        System.out.println("p:" + p + " " + "q:" + q);
        if (q == 0) {
            return p;
        }
        return euclid(q, p % q);
    }


    private static void test21() {
        //1.1.23
        int[] arr = new int[]{1, 4, 5, 6, 7, 8, 10};
        char c = StdIn.readChar();

        String str = StdIn.readLine();
        String[] split = str.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (c == '-' && (rank(arr, Integer.valueOf(split[i]), 0, split.length - 1) != -1)) {
                System.out.println("在白名单的是" + split[i]);
            } else if (c == '+' && (rank(arr, Integer.valueOf(split[i]), 0, split.length - 1) == -1)) {
                System.out.println("不在白名单的是" + split[i]);
            }
        }

    }

    private static int rank(int[] arr, int n, int left, int right) {
        StdOut.println("left:" + left + "right:" + right);
        //1.1.22
        if (left > right) {
            return -1;
        } else {
            int middle = left + (right - left) / 2;
            if (n > arr[middle]) {
                return rank(arr, n, middle + 1, right);
            } else if (n < arr[middle]) {
                return rank(arr, n, left, middle - 1);
            } else {
                return middle;
            }
        }
    }

    private static void test20() {
        //1.1.21
        String[] nameArr = new String[5];
        int[][] numArr = new int[5][3];

        for (int i = 0; i < nameArr.length; i++) {
            if (i < nameArr.length) {
                String raw = StdIn.readLine();
                String[] split = raw.split(" ");
                nameArr[i] = split[0];
                numArr[i][0] = Integer.valueOf(split[1]);
                numArr[i][1] = Integer.valueOf(split[2]);
            } else {
                break;
            }
        }

        for (int i = 0; i < nameArr.length; i++) {
            System.out.println(nameArr[i] + " " + numArr[i][0] + " " + numArr[i][1] + " " + String.format("%.3f", numArr[i][0] * 1.0f / numArr[i][1]));
        }
    }

    private static int test19(int i) {
        //1.1.20
        if (i <= 0) {
            return 1;
        }
        return i * test19(i - 1);
    }

    private static int test18(int n) {
        //1.1.20
        int sum = 1;
        while (n > 0) {
            sum = sum * n;
            n--;
        }
        return sum;
    }

    private static int test17(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return test17(n - 1) + test17(n - 2);
    }

    private static int test16(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return test16(a + a, b / 2);
        }
        return test16(a + a, b / 2) + a;
    }


    private static String test15(int n) {
        if (n <= 0) {
            return "";
        }
        String s = test15(n - 3) + n + test15(n - 2) + n;
        return s;
    }

    private static void test14() {
        //1.1.15
        int a[] = new int[]{2, 4, 2, 1, 1, 5, 1, 3};
        int m = 6;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int n = 0;
            for (int j = 0; j < a.length; j++) {
                if (i == a[j]) {
                    n++;
                }
            }
            arr[i] = n;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void test13() {
        //1.1.14
        int n = 10;
        int num = 0;
        while (n >= 2) {
            n = n / 2;
            num++;
        }
//        int sum = 2;
//        for (int i = 0; i < num; i++) {
//            sum += 2;
//        }
        System.out.println(num);
    }


    private static void test12() {
        //1.1.13
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] b = new int[4][3];

        for (int i = 0; i < a.length; i++) {//行
            for (int j = 0; j < a[i].length; j++) {//列
                b[j][i] = a[i][j];
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + "");
                if (j == b[i].length - 1) {
                    System.out.println();
                }
            }
        }
    }

    private static void test11() {
        //1.1.12  0-9
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }

    private static void test10() {
        //1.1.11
        boolean[][] arr = new boolean[][]{{true, true, false}, {true, true, false, false}, {true, true, false}};
        StdOut.println("一共有" + arr.length + "行");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + i + "行有" + arr[i].length + "列");
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]) {
                    StdOut.println("true");
                } else {
                    StdOut.println("false");
                }
            }
        }

    }

    private static void test9() {
        //1.1.9
        String s = "";
        for (int i = 10; i > 0; i /= 2) {
            s = i % 2 + s;
        }
        System.out.println(s);
    }

    private static void test8() {
        //1.1.8.a  98
        System.out.println('b');
        //197
        System.out.println('b' + 'c');
        //e
        System.out.println((char) ('a' + 4));
    }

    private static void test7() {
        //1.1.7 a
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);
        //1.1.7 b
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
        //1.1.7 c
        int sum2 = 0;
        for (int i = 0; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum2++;
            }
        }
        System.out.println(System.currentTimeMillis());
        StdOut.println(sum2);
        System.out.println(System.currentTimeMillis());
    }

    private static void test6() {
        //1.1.6
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    private static void test1() {
        //1.1.1.a  7
        System.out.println((0 + 15) / 2);
        //1.1.1.b 200.0000002
        System.out.println(2.0e-6 * 100000000.1);
        //1.1.1.c true
        System.out.println(true && false || true && true);
    }

    private static void test2() {
        //1.1.2 a 1.618
        System.out.println((1 + 2.236) / 2);
        //10.0
        System.out.println(1 + 2 + 3 + 4.0);
        //true
        System.out.println(4.1 >= 4);
        //33
        System.out.println(1 + 2 + "3");
    }

    private static void test3() {
        //1.1.3
//        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int[] arr = new int[3];
        while (i < 3) {
            arr[i] = Integer.valueOf(StdIn.readInt());
            i++;
        }

        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static void test5() {
        //1.1.5
        int i = 0;
        double[] arr = new double[2];
        while (i < 2) {
            arr[i] = StdIn.readDouble();
            i++;
        }
        System.out.println(arr[0] < 1 && arr[0] > 0 && arr[1] < 1 && arr[0] > 0 ? "true" : "false");
    }
}
