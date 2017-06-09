package huangshun.it.com.androiddesignpattern.unit5_1;

/**
 * Created by hs on 2017/6/9.
 */

public class Client {
    public static void main(String[] args) {
        ConcreteFactory concreteFactory = new ConcreteFactory();
        Product product = concreteFactory.createProduct();
        product.method();
    }
}
