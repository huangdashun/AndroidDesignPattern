package huangshun.it.com.androiddesignpattern.brainview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/11/7.
 */

public class BrainWaveView extends View {
    private static final String TAG = "BrainWaveView";
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private List<PointF> mPointList = new ArrayList();
    private float offsetLeft;
    private int mWidth;
    private int mHeight;
    private PointF mNewPoint;
    private int mPointSize = 120;

    public BrainWaveView(Context context) {
        this(context, null);
    }

    public BrainWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BrainWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2f);
        mPaint.setStyle(Paint.Style.STROKE);
//        for (int i = 0; i < 120; i++) {//33个点
//            mPointList.add(new PointF(0, 0));
//        }
        offsetLeft = DisplayUtil.getScreenWidthPixels(getContext()) / (mPointSize - 1);
        for (int i = 0; i < mPointSize; i++) {
            PointF point = new PointF(offsetLeft * i, DisplayUtil.dp2Px(getContext(), 200));
//            point.set(offsetLeft * i, mHeight);
            mPointList.add(point);
        }
        Log.d(TAG, "init() called with " + "");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure() called with " + "widthMeasureSpec = [" + widthMeasureSpec + "], heightMeasureSpec = [" + heightMeasureSpec + "]");
        mWidth = getDefaultSize(
                getSuggestedMinimumWidth() + getPaddingLeft() + getPaddingRight(),
                widthMeasureSpec);
        Log.i(TAG, "mWidth:" + mWidth);
        mHeight = getDefaultSize(
                getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom(),
                heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
//        offsetLeft = mWidth / 119f;
//        for (int i = 0; i < mPointList.size(); i++) {
//            PointF point = mPointList.get(i);
//            point.set(offsetLeft * i, mHeight);
//        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "mPointList.size" + "():" + mPointList.size());
//        int i = mPointList.size();//记录点的个数
        if (mPointList.size() >= 2) {//大于两个点才开始画线
            for (int k = 0; k < mPointList.size() - 1; k++) {
                canvas.drawLine(mPointList.get(k).x,
                        mPointList.get(k).y,
                        mPointList.get(k + 1).x,
                        mPointList.get(k + 1).y, mPaint);
            }
        }
    }

    public void addPointToList(int mPointY) {
        //新产生的点
//        mNewPoint = new PointF(mWidth, (1 - mPointY / 65535f) * mHeight);
        mNewPoint = new PointF(mWidth, mPointY);
        mPointList.add(mNewPoint);
        //改变之前的点的x坐标
        for (int j = 0; j < mPointList.size() - 1; j++) {
            PointF newPoint = mPointList.get(j);
            newPoint.x = -offsetLeft + newPoint.x;
            Log.i(TAG, "newPoint.x:" + newPoint.x);
        }
        //最多绘制120个点，多余的出栈
        int size = mPointList.size();
        if (size > mPointSize) {
            for (int i = 0; i < size - mPointSize; i++) {
                mPointList.remove(0);
            }
        }
        postInvalidate();
    }


    public void clear() {
        mPointList.clear();
    }
}


