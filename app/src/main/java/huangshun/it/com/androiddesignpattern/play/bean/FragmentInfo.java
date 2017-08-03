package huangshun.it.com.androiddesignpattern.play.bean;


import android.support.v4.app.Fragment;

/**
 * Created by hs on 2017/8/2.
 */

public class FragmentInfo {
    private String title;
    private Fragment fragment;

    public FragmentInfo(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
