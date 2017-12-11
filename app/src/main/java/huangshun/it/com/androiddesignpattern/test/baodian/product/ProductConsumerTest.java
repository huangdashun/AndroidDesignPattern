package huangshun.it.com.androiddesignpattern.test.baodian.product;

/**
 * Created by hs on 2017/12/8.
 */

public class ProductConsumerTest {
    public static void main(String[] args) {
        String lock = new String("");
        Product product = new Product(lock);
        Consumer consumer = new Consumer(lock);

        new ProductThread(product).start();
        new ConsumerThread(consumer).start();
    }
}
