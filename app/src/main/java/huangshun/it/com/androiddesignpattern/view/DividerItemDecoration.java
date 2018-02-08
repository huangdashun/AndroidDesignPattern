package huangshun.it.com.androiddesignpattern.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hs on 2018/1/10.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private float mDividerHeight;//分割线的高度
    private Paint mPaint;

    public DividerItemDecoration() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = 1;
            mDividerHeight = 1;
        }

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();

//        for (int i = 0; i < childCount; i++) {
//
//            View view = parent.getChildAt(i);
//            int index = parent.getChildAdapterPosition(view);//子view的位置
//
//            if (index == 0) {//第一个不需要绘制
//                continue;
//            }
//            //每个分割线的左上右下坐标
//            float dividerLeft = view.getPaddingLeft();
//            float dividerTop = view.getTop() - mDividerHeight;
//            float dividerRight = view.getWidth() - view.getPaddingRight();
//            float dividerBottom = view.getTop();
//
//            c.drawRect(dividerLeft, dividerTop, dividerRight, dividerBottom, mPaint);
//        }
    }
}
