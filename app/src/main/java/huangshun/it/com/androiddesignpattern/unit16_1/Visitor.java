package huangshun.it.com.androiddesignpattern.unit16_1;

/**
 * Created by hs on 2017/7/31.
 */

interface Visitor {
     void visit(Engineer engineer);

    void visit(Manager manager);
}
