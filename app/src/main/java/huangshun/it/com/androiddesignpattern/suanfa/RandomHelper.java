package huangshun.it.com.androiddesignpattern.suanfa;

import java.util.Random;

/**
 * Created by hs on 2017/11/16.
 */

public class RandomHelper {
    public static int[] getRandom(int n, int min, int max) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            ints[i] = random.nextInt(1000) % (max - min + 1) + min;
//            System.out.println(ints[i]);
        }
        return ints;
    }
}
