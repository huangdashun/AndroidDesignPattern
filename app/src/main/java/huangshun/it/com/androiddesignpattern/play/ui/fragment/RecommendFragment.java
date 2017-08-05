package huangshun.it.com.androiddesignpattern.play.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.play.bean.PageBean;
import huangshun.it.com.androiddesignpattern.play.presenter.RecommendPresenter;
import huangshun.it.com.androiddesignpattern.play.presenter.contract.RecommendContract;
import huangshun.it.com.androiddesignpattern.play.ui.adapter.RecommendAdapter;

/**
 * Created by hs on 2017/8/2.
 */

public class RecommendFragment extends Fragment implements RecommendContract.view {
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    private static final String TAG = "RecommendFragment";

    private RecommendContract.presenter mPresenter;
    private RecommendPresenter mRecommendPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recomend, container, false);
        ButterKnife.bind(this, view);

        mRecommendPresenter = new RecommendPresenter(this);
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setCanceledOnTouchOutside(false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecommendPresenter.getResult();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void setPresenter(RecommendContract.presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
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
