package huangshun.it.com.androiddesignpattern.unit16_1;

/**
 * Created by hs on 2017/7/31.
 */

public class CTOVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师:" + engineer.name + "代码量:" + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理:" + manager.name + "产品:" + manager.getProducts());
    }
}
