package huangshun.it.com.androiddesignpattern.radix;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by hs on 2017/9/19.
 * 二进制,八进制.十进制转换
 */

public class RadixMain {
    public static void main(String[] args) {
//        //十进制转为其他进制
//        System.out.println(Integer.toBinaryString(112));
//        System.out.println(Integer.toOctalString(112));
//        System.out.println(Integer.toHexString(10));
//        //其他进制转化为十进制
//        System.out.println(Integer.parseInt("1100",2));
//        System.out.println(Integer.parseInt("77",8));
//        System.out.println(Integer.parseInt("ff",16));
        getTime(System.currentTimeMillis());
    }

    public static void getTime(long currentTimeMills) {
        long start, end;
        //昨天16－6点，到明天 24点
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(currentTimeMills - TimeUnit.DAYS.toMillis(1));
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        start = calendar.getTimeInMillis() / 1000;

        //昨天10点 start

        System.out.println("prepareBongBlock start " + calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        //明天的10点 end
        end = calendar.getTimeInMillis() / 1000;


        System.out.println("prepareBongBlock end " + calendar.getTime());
    }
}
