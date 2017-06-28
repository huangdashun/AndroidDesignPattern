package huangshun.it.com.androiddesignpattern.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import huangshun.it.com.androiddesignpattern.R;

/**
 * 第一个是View接口的反应,第二个是Presenter的具体类型
 *
 * @param <B>
 * @param <T>
 */
public abstract class MVPBaseActivity<B, T extends BasePresenter<B>> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpbase);
        mPresenter = createPresenter();
        mPresenter.attachView((B) this);
    }

    protected abstract T createPresenter();

    protected T mPresenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
