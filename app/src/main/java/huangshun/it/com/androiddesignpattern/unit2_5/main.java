package huangshun.it.com.androiddesignpattern.unit2_5;

/**
 * Created by hs on 2017/5/28.
 */

public class main {
    public static void main(String[] args) {
        Company company = new Company();
        company.addStaff(CEO.getCeo());
        company.addStaff(CEO.getCeo());
        company.addStaff(new Staff());
        company.addStaff(new Staff());
        company.addStaff(new Staff());
        company.addStaff(new VP());
        company.addStaff(new VP());
        company.addStaff(new VP());
        company.showAllStaff();
    }
}
