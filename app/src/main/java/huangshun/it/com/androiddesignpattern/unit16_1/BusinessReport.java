package huangshun.it.com.androiddesignpattern.unit16_1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hs on 2017/7/31.
 */

public class BusinessReport {
    private List<Staff> mStaffs = new LinkedList();

    public BusinessReport() {
        mStaffs.add(new Manager("王1"));
        mStaffs.add(new Engineer("王2"));
        mStaffs.add(new Engineer("王3"));
        mStaffs.add(new Engineer("王4"));
    }

    //为访问者展示报表
    public void showReport(Visitor visitor) {
        for (Staff staff : mStaffs) {
            staff.accept(visitor);
        }
    }
}
