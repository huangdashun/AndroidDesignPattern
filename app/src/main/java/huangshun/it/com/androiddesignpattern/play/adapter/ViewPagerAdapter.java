package huangshun.it.com.androiddesignpattern.play.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import huangshun.it.com.androiddesignpattern.play.bean.FragmentInfo;
import huangshun.it.com.androiddesignpattern.play.fragment.CategoryFragment;
import huangshun.it.com.androiddesignpattern.play.fragment.GamesFragment;
import huangshun.it.com.androiddesignpattern.play.fragment.RankingFragment;
import huangshun.it.com.androiddesignpattern.play.fragment.RecommendFragment;

/**
 * Created by hs on 2017/8/2.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment() {
        mFragmentList.add(new FragmentInfo("推荐", new RecommendFragment()));
        mFragmentList.add(new FragmentInfo("排行", new RankingFragment()));
        mFragmentList.add(new FragmentInfo("游戏", new GamesFragment()));
        mFragmentList.add(new FragmentInfo("分类", new CategoryFragment()));


    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentList.get(position).getTitle();
    }
}
