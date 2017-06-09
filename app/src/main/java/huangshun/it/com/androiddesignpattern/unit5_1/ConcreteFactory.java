package huangshun.it.com.androiddesignpattern.unit5_1;

/**
 * Created by hs on 2017/6/9.
 */

public class ConcreteFactory extends Factory {
    @Override
    public Product createProduct() {
//        return new ConcreteProductA();
        return new ConcreteProductB();
    }
}
