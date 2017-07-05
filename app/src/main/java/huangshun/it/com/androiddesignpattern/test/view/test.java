package huangshun.it.com.androiddesignpattern.test.view;

import java.util.TimeZone;

/**
 * Created by hs on 2017/7/5.
 */

public class test {
    public static void main(String[] args) {
//        int num = 20;
//        String min = String.format("%04x", num);
//        String second = String.format("%02x", num);
//        System.out.println("min:" + min + "    " + "second:" + second);
        TimeZone timeZone = TimeZone.getDefault();

        int offset = timeZone.getOffset(System.currentTimeMillis());

        int zoneH = offset / 3600000;
        int zoneM = (offset / 60000) % 60;
        System.out.println("zoneH:" + (byte)zoneH + "    " + "zoneM:" + (byte)zoneM);
    }
}
