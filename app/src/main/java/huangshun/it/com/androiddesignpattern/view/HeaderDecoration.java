package huangshun.it.com.androiddesignpattern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import huangshun.it.com.androiddesignpattern.brainview.DisplayUtil;

/**
 * Created by hs on 2018/1/10.
 */

public class HeaderDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "HeaderDecoration";
    private GroupInfoCallback mGroupInfoCallback;
    private Context mContext;
    //普通的分割线高度
    private int mDividerHeight;
    //header的头部
    private int mHeaderHeight;
    //title距离左边的距离
    private int mTitleOffsetLeft;
    //用来绘制Header上的文字
    private TextPaint mTextPaint;
    //用来绘制背景
    private Paint mPaint;
    //用来绘制底线
    private Paint mLinePaint;

    public HeaderDecoration(Context context, GroupInfoCallback groupInfoCallback) {
        mGroupInfoCallback = groupInfoCallback;
        mContext = context;
        mDividerHeight = 1;
        mHeaderHeight = (int) DisplayUtil.dp2Px(context, 24);
        mTitleOffsetLeft = (int) DisplayUtil.dp2Px(context, 20);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(DisplayUtil.dp2Px(context, 16));

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);

        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setColor(Color.BLACK);
        mLinePaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);
        if (mGroupInfoCallback != null) {
            GroupInfo groupInfo = mGroupInfoCallback.getGroupInfo(position);
            if (groupInfo != null && groupInfo.isFirstViewInGroup()) {
                outRect.top = mHeaderHeight;
            } else {
                outRect.top = mDividerHeight;
            }
        }
    }

//    @Override
//    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        super.onDraw(c, parent, state);
//        int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View view = parent.getChildAt(i);
//            int index = parent.getChildAdapterPosition(view);
//
//            if (mGroupInfoCallback != null) {
//                GroupInfo groupInfo = mGroupInfoCallback.getGroupInfo(index);
//                //header只绘制在组内的第一个ItemView
//                if (groupInfo.isFirstViewInGroup()) {
//                    int left = parent.getPaddingLeft();
//                    int top = view.getTop() - mHeaderHeight;
//                    int right = parent.getWidth() - parent.getPaddingRight();
//                    int bottom = view.getTop();
//
//                    //绘制header
//                    c.drawRect(left, top, right, bottom, mPaint);
//                    //绘制文字
//
//                    Rect bound = new Rect();
//                    String title = groupInfo.getTitle();
//                    mTextPaint.getTextBounds(title, 0, title.length(), bound);
//                    int textMiddle = (bound.top + bound.bottom) / 2;
//                    float middle = (top + bottom) / 2;
//                    int yOffset = -textMiddle;
//                    c.drawText(title, 0, title.length(), mTitleOffsetLeft, middle + yOffset, mTextPaint);
//                }
//            }
//        }
//    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        //获取当前可见的item的数量
        int childCount = parent.getChildCount();
        //绘制悬浮标题
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);//获取view在Adapter中的position

            if (mGroupInfoCallback != null) {
                GroupInfo groupInfo = mGroupInfoCallback.getGroupInfo(index);

                //绘制底线
                if (groupInfo.isLastViewInGroup()) {//如果是最后一个itemView
                    c.drawLine(0, view.getBottom() - mDividerHeight, parent.getWidth(), view.getBottom() - mDividerHeight, mLinePaint);
                } else {
                    c.drawLine(mTitleOffsetLeft, view.getBottom() - mDividerHeight, parent.getWidth(), view.getBottom() - mDividerHeight, mLinePaint);
                }


                Log.i(TAG, "index:" + index + "group:" + groupInfo.toString());
                int left = parent.getPaddingLeft();
                int right = parent.getWidth() - parent.getPaddingRight();
                //屏幕第一个可见的itemView的i为0
                if (i != 0) {
                    if (groupInfo.isFirstViewInGroup()) {
                        int top = view.getTop() - mHeaderHeight;
                        int bottom = view.getTop();

                        drawHeaderRect(c, groupInfo, left, top, right, bottom);
                    }
                } else {
                    //当 ItemView 是屏幕上第一个可见的View 时，不管它是不是组内第一个View
                    //它都需要绘制它对应的 StickyHeader。

                    int top = parent.getPaddingTop();
                    //判断当前的ItemView是不是它组内的最后一个view
                    if (groupInfo.isLastViewInGroup()) {
                        int suggestTop = view.getBottom() - mHeaderHeight;

                        if (suggestTop < top) {
                            top = suggestTop;
                        }
                    }
                    int bottom = top + mHeaderHeight;
                    drawHeaderRect(c, groupInfo, left, top, right, bottom);


                }
            }

        }
    }

    /**
     * 绘制头部
     *
     * @param c
     * @param groupInfo
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    private void drawHeaderRect(Canvas c, GroupInfo groupInfo, int left, int top, int right, int bottom) {


        //绘制header
        c.drawRect(left, top, right, bottom, mPaint);
        //绘制文字

        Rect bound = new Rect();
        String title = groupInfo.getTitle();
        mTextPaint.getTextBounds(title, 0, title.length(), bound);
        int textMiddle = (bound.top + bound.bottom) / 2;
        float middle = (top + bottom) / 2;
        int yOffset = -textMiddle;
        c.drawText(title, 0, title.length(), mTitleOffsetLeft, middle + yOffset, mTextPaint);
    }

    public interface GroupInfoCallback {
        GroupInfo getGroupInfo(int position);
    }

}
