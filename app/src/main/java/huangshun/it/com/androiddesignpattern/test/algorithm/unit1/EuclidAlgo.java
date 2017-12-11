package huangshun.it.com.androiddesignpattern.test.algorithm.unit1;

import java.util.Calendar;

/**
 * Created by hs on 2017/11/28.
 * 欧几里德
 * 求两个数的最大公约数
 * 提示：p是被除数，q是除数，如果q为0，直接return p
 * 否则将p与q取余的r,在将q作为被除数，r作为除数，进行递归
 */

public class EuclidAlgo {
    public static void main(String[] args) {
//        System.out.println(euclid(10, 5));
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
    }

    public static int euclid(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;//求余数
        return euclid(q, r);
    }
}
