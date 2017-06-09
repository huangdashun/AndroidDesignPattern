package huangshun.it.com.androiddesignpattern.unit5_4;

import huangshun.it.com.androiddesignpattern.unit5_1.Product;

/**
 * Created by hs on 2017/6/9.
 */

public abstract class Factory {
    abstract <T extends Product> T createProduct(Class<T> clz);
}
