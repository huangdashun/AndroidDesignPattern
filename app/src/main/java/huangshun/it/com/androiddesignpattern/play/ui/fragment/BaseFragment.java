package huangshun.it.com.androiddesignpattern.play.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import huangshun.it.com.androiddesignpattern.play.MyApplication;
import huangshun.it.com.androiddesignpattern.play.di.component.AppComponent;
import huangshun.it.com.androiddesignpattern.play.presenter.BasePresenter;

/**
 * Created by hs on 2017/8/17.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    private View mRootView;
    private Unbinder mBind;

    private MyApplication mMyApplication;

    @Inject
    T mBasePresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentView(), container, false);
        mBind = ButterKnife.bind(this, mRootView);

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMyApplication = (MyApplication) getActivity().getApplication();
        setAppComponent(mMyApplication.getAppComponent());
        init();
    }

    public abstract int getContentView();

    public abstract void init();

    public abstract void setAppComponent(AppComponent appcomponent);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mBind != Unbinder.EMPTY) {
            mBind.unbind();
        }
    }
}
