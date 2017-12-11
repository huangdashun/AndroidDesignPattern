package huangshun.it.com.androiddesignpattern.test.baodian.product;

/**
 * Created by hs on 2017/12/8.
 */

public class ProductThread extends Thread {

    private Product mProduct;

    public ProductThread(Product product) {
        mProduct = product;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            mProduct.productValue();
        }
    }
}
