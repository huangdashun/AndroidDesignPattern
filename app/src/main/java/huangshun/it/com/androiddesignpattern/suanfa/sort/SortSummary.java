package huangshun.it.com.androiddesignpattern.suanfa.sort;

/**
 * Created by hs on 2017/11/27.
 * 总结一下前几天学的排序算法
 */

public class SortSummary {
    public static void main(String[] args) {
//        int arr[] = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int arr[] = new int[]{1, 3, 4, 12,19, 22, 34, 46, 18, 10};
//        selectSort(arr, arr.length);//选择排序
//        bubbling(arr, arr.length);//冒泡排序
//        insertSort(arr, arr.length);//插入排序
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 插入排序
     *
     * @param arr
     * @param n
     */
    public static void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            //记录当前的元素
            int current = arr[i];
            //记录j的位置
            int j;
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > current) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = current;
            syso(arr);
        }
    }


    /**
     * 选择排序
     *
     * @param arr
     * @param n   数组的长度
     */
    public static void selectSort(int arr[], int n) {
        if (arr == null || arr.length == 0 || n == 0)
            return;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
            syso(arr);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @param n
     */
    public static void bubbling(int[] arr, int n) {
        if (arr == null || arr.length == 0 || n == 0)
            return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
            syso(arr);
        }
    }

    /**
     * 交换位置
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 输出数组
     *
     * @param arr
     */
    public static void syso(int[] arr) {
        System.out.println("每一轮输出的结果");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 对arr[l....r]前闭后闭的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        } else {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    //将arr[l...mid]和arr[mid+1...r]两部分进行归并
    public static void merge(int[] arr, int l, int middle, int r) {
        //开辟一个新的空间
        int[] temp = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            temp[i - l] = arr[i];//temp的角标一定是i-l
        }
        //标记指向
        int i = l, j = middle + 1;
        for (int k = l; k <= r; k++) {
            if (i > middle) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l] < temp[j - l]) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l] > temp[j - l]) {
                arr[k] = temp[j - l];
                j++;
            }
        }
        syso(arr);
    }
}
