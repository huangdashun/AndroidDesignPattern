package huangshun.it.com.androiddesignpattern.suanfa.sort;

import huangshun.it.com.androiddesignpattern.suanfa.RandomHelper;

/**
 * Created by hs on 2017/11/16.
 */

public class SelectSortTest {
    public static void main(String[] args) {
        int[] random = RandomHelper.getRandom(2000, 0, 100);
        //0  1    2   3   4   5   6   7
//        int[] random = {5, 3, 7, 2, 1, 4, 6, 8, 13, 15, 17, 20, 23, 41, 10, 51, 5, 53};
//        selectSort(random, rand
// om.length);
        //从大到小
//        long a = System.currentTimeMillis();
//        selectSort(random, random.length);
//        long b = System.currentTimeMillis();
//        System.out.println(b - a);
//        long c = System.currentTimeMillis();
//        insertSort(random, random.length);
//        long d = System.currentTimeMillis();
//        System.out.println(d - c);
//        syso(random);
//        insertSortOptimize(random, random.length);
//        bubblingSort(random, random.length);
//        _mergeSort(random, 0, random.length-1);
//        _merge(random, 0, random.length / 2, random.length);
//        mergeSort(random, random.length);
//        _mergeSort(random, 0, random.length - 1);
        _mergeSort(random, 0, random.length - 1);
    }


    //归并排序
    public static void mergeSort(int[] arr, int n) {
        _mergeSort(arr, 0, n - 1);
    }

    /**
     * 对arr[l....r]前闭后闭的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void _mergeSort(int[] arr, int l, int r) {
        if (r - l <= 10) {//当前需要处理的数据为空  新增优化:例如当r-l<=15时使用插入法排序一下
            inserSort(arr, l, r);
            return;
        } else {
            int mid = (l + r) / 2;
            _mergeSort(arr, l, mid);
            _mergeSort(arr, mid + 1, r);
            _merge(arr, l, mid, r);
        }
    }

    //将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void _merge(int[] arr, int l, int mid, int r) {
        //开辟一个新的空间,把数组copy过去
        int[] temp = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            temp[i - l] = arr[i];
        }
        //指针指向
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l] < temp[j - l]) {//前一个数组比后一个数组小
                arr[k] = temp[i - l];
                i++;
            } else {//前一个数组比后一个数组大
                arr[k] = temp[j - l];
                j++;
            }
        }
        syso(arr);
    }

    //从大到小
    private static void selectSortBigToSmall(int[] random, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (random[i] > random[j]) {
                    int temp;
                    temp = random[i];
                    random[i] = random[j];
                    random[j] = temp;
                }
            }
        }
//        syso(random);
    }

    //从小到大
    private static void selectSort(int[] random, int n) {
//        int[] random = {10, 2, 13, 14, 6};
        int temp;
        for (int i = 0; i < n; i++) {
            //最小值的角标
            for (int j = i + 1; j < n; j++) {
                if (random[j] < random[i]) {
                    temp = random[i];
                    random[i] = random[j];
                    random[j] = temp;
                }
            }
//            random[i]与minIndex换位置
        }
//        syso(random);
    }

    private static void syso(int[] arr) {
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }

    //插入式排序
    private static void insertSort(int[] random, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (random[j] < random[j - 1]) {
                    temp = random[j];
                    random[j] = random[j - 1];
                    random[j - 1] = temp;
                }
            }
        }
        syso(random);
    }

    //插入式排序 三个参数 random,left,right   int[] random = {5, 3, 7, 2, 1, 4, 6, 8};
    private static void inserSort(int[] random, int left, int right) {
        for (int i = left; i <= right; i++) {
            int current = random[i];
            int j;
            for (j = i; j > left; j--) {
                if (random[j - 1] > current) {
                    random[j] = random[j - 1];
                } else {
                    break;
                }
            }
            random[j] = current;
        }
        syso(random);
    }

    /**
     * //插入式排序 优化版
     *
     * @param random
     * @param n
     */
    private static void insertSortOptimize(int[] random, int n) {
        for (int i = 1; i < n; i++) {
            int current = random[i];
            int j;//j保存元素e应该插入的位置
            for (j = i; j > 0; j--) {
                if (random[j - 1] > current) {
                    random[j] = random[j - 1];
                } else {
                    break;
                }
            }
            random[j] = current;
        }
        syso(random);
    }

    //冒泡排序法
    public static void bubblingSort(int[] random, int n) {
        int temp;
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < n; j++) {

                if (random[j] < random[j - 1]) {
                    temp = random[j];
                    random[j] = random[j - 1];
                    random[j - 1] = temp;
                }
            }
        }
        syso(random);
    }


}
