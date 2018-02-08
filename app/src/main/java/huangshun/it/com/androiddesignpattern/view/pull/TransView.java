package huangshun.it.com.androiddesignpattern.view.pull;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by hs on 2018/2/2.
 */

public class TransView extends View {
    private static final String TAG = "TransView";
    int mLastX;
    int mLastY;
    private Scroller mScroller;

    public TransView(Context context) {
        this(context, null);
    }

    public TransView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TransView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;//x方向移动的距离
                int deltaY = y - mLastY;//y方向移动的距离
                int translationX = (int) getTranslationX();
                int translationY = (int) getTranslationY();
//                Log.i(TAG, "translationX:" + translationX + "---------" + "translationY:" + translationY);
                setTranslationX(translationX + deltaX);
                setTranslationY(translationY + deltaY);
                break;
            case MotionEvent.ACTION_UP:
                break;

            default:
                break;
        }
        mLastX = x;
        mLastY = y;
//        Log.i(TAG, "mLastX:" + x + "--------" + "mLastY:" + mLastY);
        return true;
    }

    public void startScroll() {
        Log.d(TAG, "startScroll() called with " + "");
        mScroller.startScroll(getScrollX(), 0, 500, 0, 3000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            Log.d(TAG, "computeScroll() called with " + "" + mScroller.getCurrX() + "---" + mScroller.getCurrX());

            postInvalidate();
        }
    }
}
