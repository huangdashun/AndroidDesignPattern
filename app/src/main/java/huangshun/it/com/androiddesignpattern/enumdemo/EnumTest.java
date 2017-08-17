package huangshun.it.com.androiddesignpattern.enumdemo;

import static huangshun.it.com.androiddesignpattern.enumdemo.Color.RED;

/**
 * Created by hs on 2017/8/16.
 */

public class EnumTest {
    Color mColor = RED;

    public void change() {
        switch (mColor) {
            case RED:
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {

    }
}
