package huangshun.it.com.androiddesignpattern.unit3_1;

/**
 * Created by hs on 2017/6/3.
 * Director类,负责构造Computer
 */

public class Director {
    Builder mBuilder = null;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public void construct(String board, String display) {
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}
