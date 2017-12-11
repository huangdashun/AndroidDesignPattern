package huangshun.it.com.androiddesignpattern.test.algorithm.unit1;

/**
 * Created by hs on 2017/11/30.
 * 二分查找
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 34, 54, 78, 78, 78, 100, 130, 150, 150, 170};
//        System.out.println(rank(arr, 170));
//        System.out.println(rank(arr, 111));
        System.out.println(lessthanNumberCount(arr, 78));
        System.out.println(equalsNumberCount(arr, 150));
    }

    public static int rank(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] > n) {//查找[left,middle]
                right = middle - 1;
            } else if (arr[middle] < n) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 返回小于number的数量
     *
     * @param arr
     * @param number
     * @return
     */
    public static int lessthanNumberCount(int[] arr, int number) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < number) {
                count++;
            }
        }
        return count;
    }

    /**
     * 返回和number相等的数量
     *
     * @param arr
     * @param number
     * @return
     */
    public static int equalsNumberCount(int[] arr, int number) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                count++;
            }
        }
        return count;
    }
}
