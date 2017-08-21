package huangshun.it.com.androiddesignpattern.play.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.play.bean.PageBean;
import huangshun.it.com.androiddesignpattern.play.di.component.AppComponent;
import huangshun.it.com.androiddesignpattern.play.di.component.DaggerRecommendComponent;
import huangshun.it.com.androiddesignpattern.play.di.module.RecommendModule;
import huangshun.it.com.androiddesignpattern.play.presenter.RecommendPresenter;
import huangshun.it.com.androiddesignpattern.play.presenter.contract.RecommendContract;
import huangshun.it.com.androiddesignpattern.play.ui.adapter.RecommendAdapter;

/**
 * Created by hs on 2017/8/2.
 */

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.view {
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    private static final String TAG = "RecommendFragment";
    @Inject
    ProgressDialog mProgressDialog;
    private boolean mVisble =false;

    @Override
    public int getContentView() {
        return R.layout.fragment_recomend;
    }

    @Override
    public void init() {
        mBasePresent.getResult();

        mProgressDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void setAppComponent(AppComponent appcomponent) {
        DaggerRecommendComponent.builder().
                recommendModule(new RecommendModule(this))
                .appComponent(appcomponent)
                .build().inject(this);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mVisble = isVisibleToUser;

    }

    @Override
    public void showLoading() {
        if(mVisble){
            mProgressDialog.show();
        }
    }

    @Override
    public void dismissLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), "网络出错" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayView(List<PageBean.DatasBean> datas) {
        RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(), datas);

        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecycleView.setItemAnimator(new DefaultItemAnimator());

        mRecycleView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));

        mRecycleView.setAdapter(recommendAdapter);
    }

    @Override
    public void showNoData() {
        Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
    }
}
