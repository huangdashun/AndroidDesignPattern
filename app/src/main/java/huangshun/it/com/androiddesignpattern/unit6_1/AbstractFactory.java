package huangshun.it.com.androiddesignpattern.unit6_1;

/**
 * Created by hs on 2017/6/16.
 */

public abstract class AbstractFactory {
    /**
     * 创建产品A的方法
     *
     * @return
     */
    public abstract AbstractProductA createProductA();

    /**
     * 创建产品B的方法
     *
     * @return
     */
    public abstract AbstractProductB createProductB();
}
