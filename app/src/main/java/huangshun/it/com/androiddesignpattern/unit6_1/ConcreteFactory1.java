package huangshun.it.com.androiddesignpattern.unit6_1;

/**
 * Created by hs on 2017/6/16.
 */

public class ConcreteFactory1 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}
