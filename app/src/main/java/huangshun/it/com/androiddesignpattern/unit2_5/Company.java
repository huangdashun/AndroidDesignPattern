package huangshun.it.com.androiddesignpattern.unit2_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/5/28.
 * 公司类
 */

public class Company {
    private static final String TAG = "Company";
    private List<Staff> mStaffList = new ArrayList<>();

    public void addStaff(Staff staff) {
        mStaffList.add(staff);
    }

    public void showAllStaff() {
        for (Staff staff : mStaffList) {
//            Log.i(TAG, staff.toString());
            System.out.println(staff.toString());
        }
    }
}
