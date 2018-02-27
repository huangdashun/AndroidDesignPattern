package huangshun.it.com.androiddesignpattern.timeline;

/**
 * Created by hs on 2018/2/26.
 */

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

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
    private SummaryType mSummaryType = SummaryType.Step;
    private float mViewDistance;

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
        initListener();
    }


    /**
     * 根据viewpager的滑动设置背景和字体颜色
     */
    private void setTypeBg(SummaryType summaryType) {
//        mBinding.timelineTop.tvTipStep.setBackground(null);
//        mBinding.timelineTop.tvTipSleep.setBackground(null);
//        mBinding.timelineTop.tvTipWeight.setBackground(null);
        if (summaryType == SummaryType.Step) {
            mBinding.timelineTop.tvTipStep.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
            mBinding.timelineTop.tvTipSleep.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            mBinding.timelineTop.tvTipWeight.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
//            mBinding.timelineTop.tvTipStep.setBackgroundResource(R.drawable.bg_timeline_shape);

        } else if (summaryType == SummaryType.Sleep) {
            mBinding.timelineTop.tvTipStep.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            mBinding.timelineTop.tvTipSleep.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
            mBinding.timelineTop.tvTipWeight.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
//            mBinding.timelineTop.tvTipSleep.setBackgroundResource(R.drawable.bg_timeline_shape);
        } else {
            mBinding.timelineTop.tvTipStep.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            mBinding.timelineTop.tvTipSleep.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            mBinding.timelineTop.tvTipWeight.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
//            mBinding.timelineTop.tvTipWeight.setBackgroundResource(R.drawable.bg_timeline_shape);
        }

    }

    private void initListener() {
        mBinding.timelineTop.rlSummaryType.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mBinding.timelineTop.rlSummaryType.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float firstRight = mBinding.timelineTop.tvTipStep.getRight();
                int secondRight = mBinding.timelineTop.tvTipSleep.getRight();
                mViewDistance = secondRight - firstRight;

            }
        });
        mBinding.vpTopPreview.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0) {
                    mBinding.timelineTop.viewBg.setTranslationX(mViewDistance * (position + positionOffset));
                }
                Log.d(TAG, "onPageScrolled() called with " + "position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
            }

            @Override
            public void onPageSelected(int position) {
                setTypeBg(SummaryType.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public enum SummaryType {
        Step(0), Sleep(1), Weight(2);
        private int typeInt;

        SummaryType(int typeInt) {
            this.typeInt = typeInt;
        }

        public int getTypeInt() {
            return typeInt;
        }

        public static SummaryType valueOf(int i) {
            if (Step.getTypeInt() == i) {
                return SummaryType.Step;
            } else if (Sleep.getTypeInt() == i) {
                return SummaryType.Sleep;
            } else {
                return SummaryType.Weight;
            }
        }
    }
}
