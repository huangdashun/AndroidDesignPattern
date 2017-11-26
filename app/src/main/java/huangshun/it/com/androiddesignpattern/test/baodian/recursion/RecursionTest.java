package huangshun.it.com.androiddesignpattern.test.baodian.recursion;

/**
 * Created by hs on 2017/11/21.
 */

public class RecursionTest {
    public static void main(String[] args) {
//        getNumber(3, "你猜");


//        Boolean level = isHuiWen("level", 5);
//        System.out.println(level);
//        int arr[] = new int[]{15, 17, 20, 23, 25, 26, 27, 53, 63, 99};
//        Boolean aBoolean = binarySearch(arr, arr.length, 10);
//        System.out.println(aBoolean);
    }


    public static void getNumber(int n, String desc) {
        if (n == 0) {
//            System.out.println("n等于0");
        } else {
            getNumber(n - 1, "我是第一个");
            System.out.println(n + desc);
            getNumber(n - 1, "我是第二个");
        }
    }

    //回文
    public static Boolean isHuiWen(String str, int n) {
        System.out.println("str:" + str);
        System.out.println(str.charAt(0) + "-----" + str.charAt(str.length() - 1));
        if (n == 0 || n == 1) {
            return true;
        } else {
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);
            String temp = str.substring(1, str.length() - 1);
            return first == last ? isHuiWen(temp, temp.length()) : false;
        }
    }

    //二分查找

    public static Boolean binarySearch(int[] arr, int n, int key) {
        int middle;
        if (n == 1) {
            return key == arr[0];
        } else {
            middle = n / 2;
            if (arr[middle] > key) {//取前半段
                return binarySearch(getArray(arr, 0, middle), middle, key);
            } else {//去后半段
                return binarySearch(getArray(arr, middle, arr.length), n - middle, key);
            }
        }
    }

    public static int[] getArray(int arr[], int start, int end) {
        int[] temp = new int[arr.length / 2 + 1];
        for (int i = start, j = 0; i < end; i++, j++) {
            temp[j] = arr[i];
        }
        return temp;
    }
}