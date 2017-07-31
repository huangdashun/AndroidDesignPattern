package huangshun.it.com.androiddesignpattern.unit16_1;

import java.util.Random;

/**
 * Created by hs on 2017/7/31.
 */

class Manager extends Staff {
    private int products;

    public Manager(String name) {
        super(name);
        products = new Random().nextInt(10);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getProducts() {
        return products;
    }
}
