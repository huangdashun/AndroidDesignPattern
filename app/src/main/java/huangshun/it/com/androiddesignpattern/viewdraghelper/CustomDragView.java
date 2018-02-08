package huangshun.it.com.androiddesignpattern.viewdraghelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by hs on 2017/12/19.
 */

public class CustomDragView extends FrameLayout {

    private ViewDragHelper mViewDragHelper;
    private int mDragOriLeft;
    private int mDragOriTop;

    public CustomDragView(@NonNull Context context) {
        this(context, null);
    }

    public CustomDragView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomDragView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mViewDragHelper = ViewDragHelper.create(this, 1.0f, callback);
        mViewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_ALL);
    }

    ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return top;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
//            mViewDragHelper.settleCapturedViewAt(mDragOriLeft, mDragOriTop);
            View child = getChildAt(0);
            if (child != null && child == releasedChild) {
                mViewDragHelper.flingCapturedView(getPaddingLeft(), getPaddingTop(),
                        getWidth() - getPaddingRight() - child.getWidth(),
                        getHeight() - getPaddingBottom() - child.getHeight());
            } else {

                mViewDragHelper.settleCapturedViewAt((int) mDragOriLeft, (int) mDragOriTop);
            }
            invalidate();
        }

        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
            mDragOriLeft = capturedChild.getLeft();
            mDragOriTop = capturedChild.getTop();
        }

        @Override
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            super.onEdgeDragStarted(edgeFlags, pointerId);
            mViewDragHelper.captureChildView(getChildAt(getChildCount() - 1), pointerId);
        }

        @Override
        public void onEdgeTouched(int edgeFlags, int pointerId) {
            super.onEdgeTouched(edgeFlags, pointerId);
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return 1;
        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return 1;
        }
    };

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return mViewDragHelper.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mViewDragHelper != null && mViewDragHelper.continueSettling(true)) {
            invalidate();
        }
    }
}
