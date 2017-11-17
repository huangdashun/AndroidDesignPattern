package huangshun.it.com.androiddesignpattern.suanfa;

/**
 * Created by hs on 2017/11/16.
 * 排序
 */

public class SortArithmeticTest {
    public static void main(String[] args) {

        //找出随机生成的数组里最小的数
        int[] random = RandomHelper.getRandom(10000, 4, 20);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < random.length; i++) {
            if (min > random[i]) {
                min = random[i];
            }
        }
        System.out.println(min);
//        syso();
    }

    public static void syso() {
        int[] random = RandomHelper.getRandom(10, 4, 20);
        for (int i = 0; i < random.length; i++) {
            System.out.println(random[i]);
        }
    }
}
