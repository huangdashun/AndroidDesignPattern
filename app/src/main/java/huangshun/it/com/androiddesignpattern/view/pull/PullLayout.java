package huangshun.it.com.androiddesignpattern.view.pull;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2018/2/1.
 */

public class PullLayout extends ViewGroup {
    private static final String TAG = "PullLayout";
    private View mHeader;
    private View mFooter;
    private int mLayoutContentHeight;
    private int mLastMoveY;
    private TextView mTvPullHeader;
    private int effectiveScrollY;

    public PullLayout(Context context) {
        this(context, null);
    }

    public PullLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHeader = LayoutInflater.from(context).inflate(R.layout.pull_header, null);
        mFooter = LayoutInflater.from(context).inflate(R.layout.pull_footer, null);

        mTvPullHeader = (TextView) mHeader.findViewById(R.id.tv_pull_header);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mHeader.setLayoutParams(layoutParams);
        mFooter.setLayoutParams(layoutParams);
        addView(mHeader);
        addView(mFooter);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);


        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mLayoutContentHeight = 0;
        //布局
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            if (childView == mHeader) {//头部隐藏在顶端
                childView.layout(0, 0 - childView.getMeasuredHeight(), childView.getMeasuredWidth(), 0);
                effectiveScrollY = childView.getMeasuredHeight() / 6;
            } else if (childView == mFooter) {//footer隐藏在layout所有内容视图之后
                childView.layout(0, mLayoutContentHeight, childView.getMeasuredWidth(), mLayoutContentHeight + childView.getMeasuredHeight());
            } else {
                childView.layout(0, mLayoutContentHeight, childView.getMeasuredWidth(), mLayoutContentHeight + childView.getMeasuredHeight());
                mLayoutContentHeight += childView.getMeasuredHeight();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastMoveY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int dy = mLastMoveY - y;
                //dy小于0代表下拉刷新的操作
                Log.i(TAG, "getScrollY():" + getScrollY());
                if (dy < 0) {
                    if (Math.abs(getScrollY()) <= mHeader.getMeasuredHeight() / 2) {
                        scrollBy(0, dy);
                        if (Math.abs(getScrollY()) >= effectiveScrollY) {
                            mTvPullHeader.setText("松开刷新");
                        }
                    }

                }
                break;
        }
        mLastMoveY = y;
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
