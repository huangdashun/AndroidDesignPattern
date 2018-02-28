package huangshun.it.com.androiddesignpattern.timeline.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2018/2/28.
 * 自定义TimeLine的三个Tab
 */

public class TimeLineTabLayout extends RelativeLayout {
    private static final String TAG = "TimeLineTabLayout";
    private TextView mStepTab;
    private TextView mSleepTab;
    private TextView mWeightTab;
    private TextView mTabBg;
    private float mViewDistance;

    public TimeLineTabLayout(Context context) {
        this(context, null);
    }

    public TimeLineTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeLineTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mStepTab = (TextView) findViewById(R.id.tv_tip_step);
        mSleepTab = (TextView) findViewById(R.id.tv_tip_sleep);
        mWeightTab = (TextView) findViewById(R.id.tv_tip_weight);
        mTabBg = (TextView) findViewById(R.id.view_bg);

        this.post(new Runnable() {
            @Override
            public void run() {
                float firstRight = mStepTab.getRight();
                int secondRight = mSleepTab.getRight();
                mViewDistance = secondRight - firstRight;
                Log.d(TAG, "onFinishInflate() called with " + "" + mViewDistance);
            }
        });
    }

    /**
     * 根据viewpager的滑动设置背景和字体颜色
     */
    public void setTypeBg(SummaryType summaryType) {
        if (summaryType == SummaryType.Step) {
            mStepTab.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
            mSleepTab.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            mWeightTab.setTextColor(ContextCompat.getColor(getContext(), R.color.black));

        } else if (summaryType == SummaryType.Sleep) {
            mStepTab.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            mSleepTab.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
            mWeightTab.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        } else {
            mStepTab.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            mSleepTab.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
            mWeightTab.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        }

    }

    /**
     * 移动Tab
     *
     * @param position
     */
    public void translateTab(int position) {
        float translationX = mTabBg.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTabBg, "translateX", translationX, mViewDistance * position);
        animator.setDuration(200).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mTabBg.setTranslationX(value);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                setTypeBg(SummaryType.valueOf(position));
            }
        });
    }

    enum SummaryType {
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
