package huangshun.it.com.androiddesignpattern.view.pull;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by hs on 2018/2/2.
 */

public class ScrollerLayout extends ViewGroup {
    private static final String TAG = "ScrollerLayout";
    private Scroller mScroller;
    //获取判定为拖动的最小移动像素
    private int mTouchSlop;
    //左右边界值
    private int mLeftBorder;
    private int mRightBorder;

    //手指按下的坐标
    private float mPressX;
    //手指滑动后的坐标
    private float mMoveX;
    //手指最后离开的坐标
    private float mLastMoveX;


    public ScrollerLayout(Context context) {
        this(context, null);
    }

    public ScrollerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
        ViewConfiguration viewConfiguration = new ViewConfiguration();
        mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            childView.layout(i * childView.getMeasuredWidth(), 0, (i + 1) * childView.getMeasuredWidth(), childView.getMeasuredHeight());
        }
        mLeftBorder = getChildAt(0).getLeft();
        mRightBorder = getChildAt(childCount - 1).getRight();
    }

    /**
     * 如果onInterceptTouchEvent的down返回false,说明不拦截，那么该方法的down,move，up都会执行
     * 如果down返回true，说明拦截，那么move,up都不会再执行，会执行onTouchEvent的down，如果onTouchEvent的down返回false，那么onTouchEvent的
     * move,up也不会执行
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "执行了down");
                mPressX = ev.getRawX();
                mLastMoveX = ev.getRawX();
                return false;
            case MotionEvent.ACTION_MOVE:
//                mMoveX = ev.getRawX();
//                float diff = Math.abs(mMoveX - mPressX);
//                //当手指拖动值大于TouchSlop值时，认为应该进行滚动，拦截子控件的事件
//                if (diff > mTouchSlop) {
//                    return true;
//                }
                Log.i(TAG, "执行了Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "执行了up");
//                break;
                return true;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent DOWN");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "onTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onTouchEvent UP");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            /**
//             * 其实有bug， 把内部View换成一个不可点击按钮(Button -> TextView)会发现不可以移动，
//             * 原因是ViewGroup的OnTouchEvent默认返回false, TextView 的OnTouchEvent默认返回也是false,
//             * 这样down事件往上传的时候ViewGroup也不能消费，后续的的一系列事件都不会传给该ViewGroup，导致不可移动，
//             * 解决方案就是让ViewGroup的OnTouchEvent方法里在处理down事件时返回true就行啦。
//             */
//            case MotionEvent.ACTION_DOWN:
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                mMoveX = event.getRawX();
//                //x方向手指移动的距离
//                int scrolledX = (int) (mLastMoveX - mMoveX);
////                Log.i(TAG, "getScrollX：==" + getScrollX() + "====" + "scrolledX:" + scrolledX);
//                if (getScrollX() + scrolledX < mLeftBorder) {//左边界
//                    scrollTo(mLeftBorder, 0);
////                    Log.i(TAG, "到达了左边界");
//                    return true;
//                } else if (getScrollX() + scrolledX + getWidth() > mRightBorder) {//右边界
////                    Log.i(TAG, "到达了右边界--" + "getScrollX：==" + getScrollX() + "====" + "scrolledX:" + scrolledX);
//                    scrollTo(mRightBorder - getWidth(), 0);
//                    return true;
//                }
//                scrollBy(scrolledX, 0);
//                mLastMoveX = mMoveX;
//                break;
//            case MotionEvent.ACTION_UP:
//                // 当手指抬起时，根据当前的滚动值来判定应该滚动到哪个子控件的界面
//                int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();//0,1,2
//                Log.i(TAG, "targetIndex:" + targetIndex);
//                int dx = targetIndex * getWidth() - getScrollX();
//                Log.i(TAG, "dx:" + dx + "-----------" + getScrollX());
//                // 第二步，调用startScroll()方法来初始化滚动数据并刷新界面
//                mScroller.startScroll(getScrollX(), 0, dx, 0);
//                invalidate();
//                break;
//
//            default:
//                break;
//
//        }
////        Log.i(TAG, "mRightBorder:" + mRightBorder + "------" + "mWidth:" + getWidth());
//
//        return super.onTouchEvent(event);
//    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    /**
     * (1)同一个事件序列是指从手指接触屏幕的那一刻起，到手指离开屏幕的那一刻结束，在这个过程中所产生的一系列事件，
     * 这个事件序列以down事件开始，中间含有数量不定的move事件，最终以up事件结束。
     * (2)正常情况下，一个事件序列只能被一个View拦截且消耗。这一条的原因可以参考(3)，因为一旦一个元素拦截了某此事件，那么同一个
     * 事件序列内的所有事件都会直接交给它处理，因此同一个事件序列中的事件不能分别由两个View同时处理，但是通过
     * 特殊手段可以做到，比如一个View将本该自己处理的事件通过onTouchEvent强行传递给其它View处理。
     * (3)某个View一旦决定拦截，那么这一个事件序列都只能由它来处理（如果事件序列能够传递给它的话），并且它的onInterceptTouchEvent
     * 不会在被调用。也就是说当一个View决定拦截一个事件后，那么系统会把同一个事件序列内的其他方法都直接交给它处理，因此
     * 就不用再调用这个View的onInterceptTouchEvent去询问它是否要拦截了。
     * (4)某个View一旦开始处理事件，如果它不消耗ACTION_DOWN事件(onTouchEvent返回了false),那么同一事件序列中的其他事件
     * 都不会再交给它来处理，并且事件将重新交给它的父元素去处理，即父元素的onTouchEvent会被调用。意思就是事件一旦交给一个
     * View处理，那么它就必须消耗掉，否则同一个事件序列中剩下的事件就不再交给它来处理了，这就好比上级交给程序员一件事，如果这件事
     * 没有处理好，短期内上级就不敢再把事情交给这个程序员做了，二者类似的道理。
     * (5)如果View不消耗除Action_down意外的其他事件，那么这个点击事件会消失，此时父元素的onTouchEvent并不会被调用，并且当前View
     * 可以持续收到后续的事件，最终这些消失的点击事件会传递给Activity处理。
     * (6)ViewGroup默认不拦截任何事件。Android源码中ViewGroup的onInterceptTouchEvent方法默认返回false;
     * (7)View没有onInterceptTouchEvent，一旦有点击事件传递给它，那么它的onTouchEvent一定会被调用。
     * (8)View的onTouchEvent默认都会消耗事件(返回true)，除非它是不可点击的(clickable和longClickable同时为false).
     * View的longClickable默认都为false,clickable分情况，比如Button默认为true，TextView默认为false
     * (9)View的enable属性不影响onTouchEvent的默认返回值。
     * (10)onClick会发生的前提是当前View是可点击的，并且受到了down和up的事件；
     * (11)时间传递过程是由外向内的，即事件总是先传递给父元素，再由父元素传递给子View，通过requestDisallowInterceptTouchEvent
     * 方法可以在子元素中干预父元素的事件分发过程，但是Action_down事件除外。
     */
}
