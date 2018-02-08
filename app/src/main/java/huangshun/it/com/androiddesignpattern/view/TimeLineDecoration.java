package huangshun.it.com.androiddesignpattern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import huangshun.it.com.androiddesignpattern.brainview.DisplayUtil;

/**
 * Created by hs on 2018/1/10.
 */

public class TimeLineDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    private float mOffsetLeft;//ItemView距离左边的距离
    private float mOffsetTop;//ItemView距离上边的距离
    private float mCircleRadius;//时间轴节点的半径


    public TimeLineDecoration(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mOffsetLeft = DisplayUtil.dp2Px(context, 80);
        mCircleRadius = DisplayUtil.dp2Px(context, 10);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = 1;
            mOffsetTop = 1;
        }

        outRect.left = (int) mOffsetLeft;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {

            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);//子view的位置

            float dividerTop = view.getTop() - mOffsetTop;


            if (index == 0) {//第一个ItemView 没有向上方向的间隔
                dividerTop = view.getTop();
            }

            //每个分割线的左上右下坐标
            float dividerLeft = view.getPaddingLeft();
            float dividerRight = view.getWidth() - view.getPaddingRight();
            float dividerBottom = view.getBottom();

            //中心点

            float centerX = dividerLeft + mOffsetLeft / 2;
            float centerY = dividerTop + (dividerBottom - dividerTop) / 2;

            //上部分轴线

            float upLineTopX = centerX;
            float upLineTopY = dividerTop;
            float upLineBottomX = centerX;
            float upLineBottomY = centerY - mCircleRadius;

            //绘制上半部轴线

            c.drawLine(upLineTopX, upLineTopY, upLineBottomX, upLineBottomY, mPaint);

            //绘制时间轴结点

            c.drawCircle(centerX, centerY, mCircleRadius, mPaint);

            //下部分轴线

            float downLineTopX = centerX;
            float downLineTopY = centerY + mCircleRadius;
            float downLineBottomX = centerX;
            float downLineBottomY = dividerBottom;

            //绘制下半部分轴线

            c.drawLine(downLineTopX, downLineTopY, downLineBottomX, downLineBottomY, mPaint);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);

            if (index < 3) {
                int top = view.getTop();
                c.drawRect(200, top, 400, top + 100, mPaint);
            }


        }


    }
}
