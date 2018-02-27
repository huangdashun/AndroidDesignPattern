package huangshun.it.com.androiddesignpattern.timeline;

/**
 * Created by hs on 2018/2/26.
 */

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.databinding.FragTimelineBinding;
import huangshun.it.com.androiddesignpattern.timeline.anim.TimeLimeSwitchTransformer;

public class HomeTimeLineFragment extends Fragment {
    private static final String TAG = "HomeTimeLineFragment";
    private FragTimelineBinding mBinding;
    private View mStepView;//步数
    private View mSleepView;//睡眠
    private View mWeightView;//体重

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.frag_timeline, container, false);
        mBinding.setFragment(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mStepView = View.inflate(getContext(), R.layout.timeline_top_step, null);
        mSleepView = View.inflate(getContext(), R.layout.timeline_top_sleep, null);
        mWeightView = View.inflate(getContext(), R.layout.timeline_top_weight, null);
        List<View> mViewList = new ArrayList<>();
        mViewList.add(mStepView);
        mViewList.add(mSleepView);
        mViewList.add(mWeightView);
        TimeLineViewpager timeLineViewpager = new TimeLineViewpager(mViewList);
        //设置切换的动画
        mBinding.vpTopPreview.setPageTransformer(false, new TimeLimeSwitchTransformer());
        mBinding.vpTopPreview.setAdapter(timeLineViewpager);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
