package huangshun.it.com.androiddesignpattern.test.algorithm;

/**
 * Created by hs on 2017/11/28.
 */

public class ExtraTest {
    public static void main(String[] args) {
        //颠倒数组元素的顺序
        int[] arr = {1, 3, 5, 2, 4, 6};
//        reverse(arr);
        System.out.println(primeNumber(2));
        System.out.println(primeNumber(3));
        System.out.println(primeNumber(4));
        System.out.println(primeNumber(19));
        System.out.println(primeNumber(100));
    }

    /**
     * 颠倒数组元素的顺序
     *
     * @param arr
     */
    public static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp;
            temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        syso(arr);

    }

    /**
     * 判断一个数是否是素数
     *
     * @param n
     * @return
     */
    public static boolean primeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void syso(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
