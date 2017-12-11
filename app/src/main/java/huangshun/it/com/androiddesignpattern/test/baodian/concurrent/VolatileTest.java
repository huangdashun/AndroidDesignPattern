package huangshun.it.com.androiddesignpattern.test.baodian.concurrent;

/**
 * Created by hs on 2017/12/8.
 */

public class VolatileTest {
    private static int x;
    private static int y;

    public static void main(String[] args) {
        x = 1;//原子性操作
        y = x;//非，要先去读取x的值，在去赋值
        x++;//非，要先去读取x的值，在进行加1操作
        x = x + 1;//非 ，同上
    }
}
