package huangshun.it.com.androiddesignpattern.view.myexpandable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.NoSuchElementException;

/**
 * Created by hs on 2018/2/7.
 */

public class MyStickyLayout extends LinearLayout {
    private static final String TAG = "MyStickyLayout";
    //需要两个view
    private View mHeader;
    private ViewGroup mContent;
    //header的高度
    private int mOriHeaderHeight;//默认原始高度
    private int mHeaderHeight;//实时的高度
    //最小的移动距离
    private int mScaledTouchSlop;
    //分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;
    //分别记录上次滑动的坐标（onInterceptTouchEvent）
    private int mLastInterceptX = 0;
    private int mLastInterceptY = 0;
    //状态：展开，收缩
    private int mStatus = STATUS_EXPANDED;//默认是展开
    public static final int STATUS_EXPANDED = 1;
    public static final int STATUS_COLLAPSED = 2;
    private PinnedHeaderExpandableListView mPinnedHeaderExpandableListView;

    public MyStickyLayout(Context context) {
        this(context, null);
    }

    public MyStickyLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyStickyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && (mHeader == null || mContent == null)) {
            initView();
        }

    }

    private void initView() {
        //动态获取header和content的id
        int headerId = getResources().getIdentifier("sticky_header", "id", getContext().getPackageName());
        int contentId = getResources().getIdentifier("sticky_content", "id", getContext().getPackageName());
        if (headerId != 0 && contentId != 0) {
            mHeader = findViewById(headerId);
            mContent = (ViewGroup) findViewById(contentId);
            mOriHeaderHeight = mHeader.getMeasuredHeight();
            mHeaderHeight = mOriHeaderHeight;
            mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            mPinnedHeaderExpandableListView = (PinnedHeaderExpandableListView) mContent.getChildAt(0);
        } else {
            throw new NoSuchElementException("Did your view with id \"sticky_header\" or \"sticky_content\" exists?");
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.i(TAG, "父亲拦截");
        boolean interceptFlag = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                Log.i(TAG, "intercept  DOWN:");
                mLastX = x;
                mLastY = y;
                mLastInterceptX = x;
                mLastInterceptY = y;
                interceptFlag = false;
                break;
            case MotionEvent.ACTION_MOVE:
                //x ,y 偏移量
                int deltaX = x - mLastInterceptX;
                int deltaY = y - mLastInterceptY;
                //判断如何滑动的时候拦截 *****
//                Log.i(TAG, "deletaX:" + deltaX + "====" + "deletaY:" + deltaY + "=====" + "x:" + x + "======" + "y:" + y);
                Log.i(TAG, "y:" + y + "=====" + "mHeaderHeight：" + mHeaderHeight);
                if (y <= mHeaderHeight) {//当手指在header上面不拦截
                    interceptFlag = false;
                } else if (Math.abs(deltaY) <= Math.abs(deltaX)) {
                    interceptFlag = false;
                } else if (mStatus == STATUS_EXPANDED && deltaY <= -mScaledTouchSlop) {//当是展开状态，向上滑动的时候
                    interceptFlag = true;
                } else if (mGiveUpTouchEventListener != null) {
                    if (mGiveUpTouchEventListener.intercept(ev) && deltaY >= mScaledTouchSlop) {
                        interceptFlag = true;
                    }
                }
                //当content滑动到顶的时候内层拦截
                int firstVisiblePosition = mPinnedHeaderExpandableListView.getFirstVisiblePosition();
                int firstVisibleGroupPos = mPinnedHeaderExpandableListView.getPackedPositionGroup(mPinnedHeaderExpandableListView.getExpandableListPosition(firstVisiblePosition));
                View view = (View) mPinnedHeaderExpandableListView.getParent();
                if (mStatus == STATUS_COLLAPSED && view.getTop() == 0 && firstVisiblePosition == 0 && firstVisibleGroupPos == 0 && deltaY < 0) {
                    Log.i(TAG, "执行到了这里" + view.getTop());
                    interceptFlag = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                interceptFlag = false;
                mLastInterceptY = mLastInterceptX = 0;
                break;
            default:
                break;
        }

        return interceptFlag;

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.i(TAG, "dispatchTouchEvent:" + "Sticky");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (y <= mHeaderHeight) {//触摸header禁止滑动
            return false;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                mHeaderHeight += deltaY;
                setHeaderHeight(mHeaderHeight);
                //当content滑动到顶的时候内层拦截
                int firstVisiblePosition = mPinnedHeaderExpandableListView.getFirstVisiblePosition();
                int firstVisibleGroupPos = mPinnedHeaderExpandableListView.getPackedPositionGroup(mPinnedHeaderExpandableListView.getExpandableListPosition(firstVisiblePosition));
                View view = (View) mPinnedHeaderExpandableListView.getParent();
                if (mStatus == STATUS_COLLAPSED && view.getTop() == 0 && firstVisiblePosition == 0 && firstVisibleGroupPos == 0 && deltaY < 0) {
                    Log.i(TAG, "执行到了这里 onTouchEvent");
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                //这里做判断，当松开手的时候，会自动向两边滑动，具体向那边滑要根据所处的位置
                int destHeight = 0;
                if (mHeaderHeight <= mOriHeaderHeight * 0.5) {
                    destHeight = 0;
                    mStatus = STATUS_COLLAPSED;
                } else {
                    destHeight = mOriHeaderHeight;
                    mStatus = STATUS_EXPANDED;
                }
                smoothHeader(mHeaderHeight, destHeight, 500);
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }

    /**
     * 动画view
     *
     * @param height
     * @param destHeight
     * @param duration
     */
    private void smoothHeader(int height, int destHeight, int duration) {
        ValueAnimator animator = ValueAnimator.ofInt(height, destHeight);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int tempHeight = (int) animation.getAnimatedValue();
                setHeaderHeight(tempHeight);
            }
        });
        animator.setDuration(duration);
        animator.start();
    }

    /**
     * 设置header高度
     *
     * @param height
     */
    private void setHeaderHeight(int height) {
        if (height <= 0) {
            height = 0;
        }
//        else if (height > mOriHeaderHeight) {
//            height = mOriHeaderHeight;
//        }

        if (height == 0) {
            mStatus = STATUS_COLLAPSED;
        } else {
            mStatus = STATUS_EXPANDED;
        }
        if (mHeader != null && mHeader.getLayoutParams() != null) {
            mHeader.getLayoutParams().height = height;
            mHeader.requestLayout();
            mHeaderHeight = height;
        } else {

        }

    }

    private OnGiveUpTouchEventListener mGiveUpTouchEventListener;

    public void setOnGiveUpTouchEventListener(OnGiveUpTouchEventListener l) {
        mGiveUpTouchEventListener = l;
    }

    public interface OnGiveUpTouchEventListener {
        boolean intercept(MotionEvent event);//是否放弃拦截
    }

}
