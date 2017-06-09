package huangshun.it.com.androiddesignpattern.unit5_4;

import huangshun.it.com.androiddesignpattern.unit5_1.Product;

/**
 * Created by hs on 2017/6/9.
 */

public class ConcreteFactory extends Factory {
    @Override
    <T extends Product> T createProduct(Class<T> clz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
