package huangshun.it.com.androiddesignpattern.unit16_1;

/**
 * Created by hs on 2017/7/31.
 */

public class Client {
    public static void main(String[] args) {
        BusinessReport businessReport = new BusinessReport();
        businessReport.showReport(new CEOVisitor());
        businessReport.showReport(new CTOVisitor());
    }
}
