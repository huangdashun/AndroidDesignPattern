package huangshun.it.com.androiddesignpattern.unit3_1;

/**
 * Created by hs on 2017/6/3.
 * 抽象的builder类
 */

public abstract class Builder {
    //设置主机
    public abstract void buildBoard(String board);

    //设置显示器
    public abstract void buildDisplay(String display);

    //设置操作系统
    public abstract void buildOS();

    //创建 Computer
    public abstract Computer create();
}
