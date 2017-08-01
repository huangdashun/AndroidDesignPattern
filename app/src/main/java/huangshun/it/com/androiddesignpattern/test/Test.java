package huangshun.it.com.androiddesignpattern.test;

import java.util.List;

/**
 * Created by hs on 2017/7/31.
 */

public class Test {
    public static void main(String[] args) {
//        List<String> data = new ArrayList<>();
//        if (insertData(data)) {
//            System.out.println(data);
//            System.out.println("main");
//            for (String s : data) {
//                System.out.println(s);
//            }
//        }
        int[] a = new int[100];
        a[0] = 100;
        a[1] = 110;
        System.out.println(a.length);
    }

    public static boolean insertData(List<String> data) {
        data.add("abc");
        data.add("ccc");
        data.add("我试试");
        for (String s : data) {
            System.out.println("insertData");
            System.out.println(s);
        }
        return true;
    }
}
