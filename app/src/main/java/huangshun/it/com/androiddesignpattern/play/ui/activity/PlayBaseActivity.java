package huangshun.it.com.androiddesignpattern.play.ui.activity;

import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

import com.mikepenz.iconics.context.IconicsLayoutInflater;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import huangshun.it.com.androiddesignpattern.play.MyApplication;
import huangshun.it.com.androiddesignpattern.play.di.component.AppComponent;
import huangshun.it.com.androiddesignpattern.play.presenter.BasePresenter;

/**
 * 基类
 */
public abstract class PlayBaseActivity<T extends BasePresenter> extends AppCompatActivity {


    private MyApplication mMyApplication;

    @Inject
    T mPresent;
    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));//iconics
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mBind = ButterKnife.bind(this);
        mMyApplication = (MyApplication) getApplication();
        setAppComponent(mMyApplication.getAppComponent());
        init();
    }

    //布局
    public abstract int getContentView();

    //初始化的操作
    public abstract void init();

    public abstract void setAppComponent(AppComponent appComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind !=  Unbinder.EMPTY) {
            mBind.unbind();
        }
    }
}
