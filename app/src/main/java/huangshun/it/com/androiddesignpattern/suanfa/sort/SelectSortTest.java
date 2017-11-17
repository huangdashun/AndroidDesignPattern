package huangshun.it.com.androiddesignpattern.suanfa.sort;

import huangshun.it.com.androiddesignpattern.suanfa.RandomHelper;

/**
 * Created by hs on 2017/11/16.
 */

public class SelectSortTest {
    public static void main(String[] args) {
        int[] random = RandomHelper.getRandom(10, 1, 50);
//        selectSort(random, random.length);
        //从大到小
        selectSortBigToSmall(random, random.length);
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
        syso(random);
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
        syso(random);
    }

    private static void syso(int[] arr) {
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }
}
