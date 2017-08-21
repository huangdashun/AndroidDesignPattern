package huangshun.it.com.androiddesignpattern.play.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/8/19.
 */

public class GuideFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentList;

    public List<Fragment> getFragmentList() {
        return mFragmentList;
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        if (fragmentList == null) {
            mFragmentList = new ArrayList<>();
        }
        mFragmentList = fragmentList;
    }

    public GuideFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        if (mFragmentList != null) {
            return mFragmentList.size();
        } else {

            return 0;
        }
    }
}
