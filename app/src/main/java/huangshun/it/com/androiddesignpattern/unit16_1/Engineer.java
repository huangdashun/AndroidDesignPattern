package huangshun.it.com.androiddesignpattern.unit16_1;

import java.util.Random;

/**
 * Created by hs on 2017/7/31.
 */

class Engineer extends Staff {
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
