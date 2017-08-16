package huangshun.it.com.androiddesignpattern.unit18_5;

/**
 * Created by hs on 2017/8/14.
 * 具体诉讼人
 */

public class XiaoMin implements ILawsuit {
    @Override
    public void submit() {
        System.out.println("老板拖欠工资,申请仲裁");
    }

    @Override
    public void burden() {
        System.out.println("合同书");
    }

    @Override
    public void defend() {
        System.out.println("证据确凿");
    }

    @Override
    public void finish() {
        System.out.println("诉讼成功.");
    }
}
