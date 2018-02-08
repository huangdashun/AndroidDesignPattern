package huangshun.it.com.androiddesignpattern.view.myexpandable;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;

/**
 * Created by hs on 2018/2/6.
 */

public class PinnedHeaderExpandableListView extends ExpandableListView implements AbsListView.OnScrollListener {
    private static final String TAG = "PinnedHeader";
    //粘性TitleView
    private View mHeaderView;
    private int mHeaderWidth;
    private int mHeaderHeight;

    private OnHeaderUpdateListener mOnHeaderUpdateListener;

    private View mTouchTarget;//
    private boolean mHeaderGroupClickable = true;//头部是否可点击

    public PinnedHeaderExpandableListView(Context context) {
        this(context, null);
    }

    public PinnedHeaderExpandableListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PinnedHeaderExpandableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //去除view的上下边的黑色阴影
        setFadingEdgeLength(0);
        //监听滑动事件
        setOnScrollListener(this);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mHeaderView == null) {
            return;
        }
        measureChild(mHeaderView, widthMeasureSpec, heightMeasureSpec);
        mHeaderWidth = mHeaderView.getMeasuredWidth();
        mHeaderHeight = mHeaderView.getMeasuredHeight();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (mHeaderView == null) {
            return;
        }
        mHeaderView.layout(0, 0, mHeaderWidth, mHeaderHeight);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (mHeaderView != null) {//绘制HeaderView
            drawChild(canvas, mHeaderView, getDrawingTime());
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (totalItemCount > 0) {
//            Log.i(TAG, "totalItemCount:" + totalItemCount);
            refreshHeader();
        }

    }


    public void setOnHeaderUpdateListener(OnHeaderUpdateListener onHeaderUpdateListener) {
        mOnHeaderUpdateListener = onHeaderUpdateListener;
        if (onHeaderUpdateListener == null) {
            return;
        }
        mHeaderView = onHeaderUpdateListener.getPinnedHeader();
        int firstVisiblePosition = getFirstVisiblePosition();//获取屏幕上显示的第一个item
        int firstVisibleGroupPos = getPackedPositionGroup(getExpandableListPosition(firstVisiblePosition));//获取屏幕上显示的第一个item属于哪个组

        onHeaderUpdateListener.updatePinnedHeader(mHeaderView, firstVisibleGroupPos);//将组号回调出去

    }

    /**
     * 接口回调
     */
    public interface OnHeaderUpdateListener {
        /**
         * 采用单例模式返回同一个view对象即可
         * 注意:view必须要有LayoutParams
         *
         * @return
         */
        public View getPinnedHeader();

        /**
         * 更新头部view数据
         *
         * @param headerView
         * @param firstVisibleGroupPos
         */
        public void updatePinnedHeader(View headerView, int firstVisibleGroupPos);
    }

    /**
     * 刷新group header数据
     */
    private void refreshHeader() {
        if (mHeaderView == null) {
            return;
        }
        //获取当前第一个可见的childView
        int firstVisiblePosition = getFirstVisiblePosition();
        //获取当前第一个可见childView所在的group
        int firstVisibleGroupPos = getPackedPositionGroup(getExpandableListPosition(firstVisiblePosition));

//        Log.i(TAG, "firstVisiblePosition:" + firstVisiblePosition + "---" + "firstVisibleGroupPos:" + firstVisibleGroupPos);
        int pos = firstVisiblePosition + 1;//下一个子view的position
        int group = getPackedPositionGroup(getExpandableListPosition(pos));//下一个子view所属的group的position
//        Log.i(TAG, "pos:" + pos + "---" + "group:" + group);
        if (group == firstVisibleGroupPos + 1) {//如果下一个group即将到来的时候
            View view = getChildAt(1);
            if (view == null) {
                Log.w(TAG, "Warning : refreshHeader getChildAt(1)=null");
                return;
            }
            if (view.getTop() <= mHeaderHeight) {//将上一个group推出去
                int delta = mHeaderHeight - view.getTop();
                mHeaderView.layout(0, -delta, mHeaderWidth, mHeaderHeight - delta);
            } else {
                //TODO : note it, when cause bug, remove it
                mHeaderView.layout(0, 0, mHeaderWidth, mHeaderHeight);
            }
        } else {
            mHeaderView.layout(0, 0, mHeaderWidth, mHeaderHeight);
        }
        if (mOnHeaderUpdateListener != null) {
            mOnHeaderUpdateListener.updatePinnedHeader(mHeaderView, firstVisibleGroupPos);
        }

    }


    /**
     * 处理悬浮title的点击事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent");
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        //手指点的位置处于第一个view
        int position = pointToPosition(x, y);
        if (mHeaderView != null && y >= mHeaderView.getTop() && y <= mHeaderView.getBottom()) {//只有悬浮title生效
            Log.i(TAG, "位置属于悬浮头部");
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                mTouchTarget = getTouchTarget(mHeaderView, x, y);
            } else {
                if (ev.getAction() == MotionEvent.ACTION_UP) {
                    View touchTarget = getTouchTarget(mHeaderView, x, y);
                    if (touchTarget == mTouchTarget && mHeaderGroupClickable) {
                        int group = getPackedPositionGroup(getExpandableListPosition(position));//获取点击的groupPosition
                        if (group != INVALID_POSITION) {
                            if (isGroupExpanded(group)) {
                                collapseGroup(group);
                            } else {
                                expandGroup(group);
                            }
                        }
                    }

                }
            }
            return true;
        }
        /**
         * 当孩子滑动上面的时候外层拦截
         */
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int firstVisibleGroupPos = getPackedPositionGroup(getExpandableListPosition(firstVisiblePosition));
            Log.i(TAG, "firstVisiblePosition:" + firstVisiblePosition + "==" + "firstVisibleGroupPos:" + firstVisibleGroupPos);
            View view = getChildAt(0);
            if (view == null) {
                return false;
            }
            if (view.getTop() == 0 && firstVisiblePosition == 0 && firstVisibleGroupPos == 0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private View getTouchTarget(View view, int x, int y) {

        return view;
    }

    private boolean intercept = true;

    public void setIntercept(boolean intercept) {
        this.intercept = intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);

    }
}
