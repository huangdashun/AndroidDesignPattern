package huangshun.it.com.androiddesignpattern.timeline.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2018/2/28.
 * 会变色的view
 */

public class ColorTrackTextView extends TextView {
    private Paint mOriginPaint;//原始画笔颜色
    private Paint mChangePaint;//改变的字体颜色
    private float mCurrentProgress = 0f;//当前的进度

    private String mText;//当前文本
    private Direction mDirection = Direction.Direction_left;

    public ColorTrackTextView(Context context) {
        this(context, null);
    }

    public ColorTrackTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorTrackTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(attrs);
    }

    //初始化自定义属性
    private void initAttr(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorTrackTextView);
        int mOriginColor = typedArray.getColor(R.styleable.ColorTrackTextView_origin_color, Color.BLACK);
        mOriginPaint = getPaintByColor(mOriginColor);
        int mChangeColor = typedArray.getColor(R.styleable.ColorTrackTextView_change_color, Color.RED);
        mChangePaint = getPaintByColor(mChangeColor);
        int direction = typedArray.getInt(R.styleable.ColorTrackTextView_direction, 0);
        if (direction == 1) {
            mDirection = Direction.Direction_right;
        }
        typedArray.recycle();

    }

    /**
     * 获取画笔根据不同的颜色
     */
    private Paint getPaintByColor(int color) {
        Paint paint = new Paint();
        // 抗锯齿
        paint.setAntiAlias(true);
        // 仿抖动
        paint.setDither(true);
        paint.setColor(color);
        // 字体的大小设置为TextView的文字大小
        paint.setTextSize(getTextSize());
        return paint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //获取当前文本
        mText = getText().toString();
        //获取空间宽度
        int width = getWidth();
        if (!TextUtils.isEmpty(mText)) {
            //根据进度计算变色位置
            int progress = (int) (width * mCurrentProgress);
//            drawOrigin(canvas, middle);
//            drawChange(canvas, middle);
            if (mDirection == Direction.Direction_left) {//从左到右颜色变化
                drawOriginLeftToRight(canvas, progress);
                drawChangeLeftToRight(canvas, progress);
            } else {
                drawOriginRightToLeft(canvas, progress);
                drawChangeRightToLeft(canvas, progress);
            }

        }

    }

    /**
     * 绘制变化色从左到右
     *
     * @param canvas
     * @param progress
     */
    private void drawChangeLeftToRight(Canvas canvas, int progress) {
        drawText(canvas, mChangePaint, 0, progress);
    }

    /**
     * 绘制正常色从左到右
     *
     * @param canvas
     * @param progress
     */
    private void drawOriginLeftToRight(Canvas canvas, int progress) {
        drawText(canvas, mOriginPaint, progress, getWidth());
    }

    /**
     * 绘制变化色从右到左
     *
     * @param canvas
     * @param progress
     */
    private void drawChangeRightToLeft(Canvas canvas, int progress) {

        drawText(canvas, mChangePaint, getWidth() - progress, getWidth());
    }

    /**
     * 绘制正常色从右到左
     *
     * @param canvas
     * @param progress
     */
    private void drawOriginRightToLeft(Canvas canvas, int progress) {
        drawText(canvas, mOriginPaint, 0, getWidth() - progress);
    }

    /**
     * 设置当前的进度
     *
     * @param currentProgress
     */
    public void setCurrentProgress(float currentProgress) {
        mCurrentProgress = currentProgress;
        invalidate();
    }

    public float getCurrentProgress() {
        return mCurrentProgress;
    }

    /**
     * @param canvas
     * @param paint
     * @param startX
     * @param endX
     */
    private void drawText(Canvas canvas, Paint paint, int startX, int endX) {
        // 保存画笔状态
        canvas.save();
        // 截取绘制的内容，待会就只会绘制clipRect设置的参数部分
        canvas.clipRect(startX, 0, endX, getHeight());
        // 获取文字的范围
        Rect bounds = new Rect();
        mOriginPaint.getTextBounds(mText, 0, mText.length(), bounds);
        // 获取文字的Metrics 用来计算基线
        Paint.FontMetricsInt fontMetrics = mOriginPaint.getFontMetricsInt();
        // 获取文字的宽高
        int fontTotalHeight = fontMetrics.bottom - fontMetrics.top;
        // 计算基线到中心点的位置
        int offY = fontTotalHeight / 2 - fontMetrics.bottom;
        // 计算基线位置
        int baseline = (getMeasuredHeight() + fontTotalHeight) / 2 - offY;
        canvas.drawText(mText, getMeasuredWidth() / 2 - bounds.width() / 2, baseline, paint);

        // 释放画笔状态
        canvas.restore();

    }

    //变色的方向
    public enum Direction {
        Direction_left, Direction_right
    }

    /**
     * 绘制文本变色的部分
     *
     * @param canvas
     * @param middle
     * @deprecated
     */
    private void drawChange(Canvas canvas, int middle) {
        drawText(canvas, mChangePaint, 0, middle);
    }

    /**
     * 绘制原始颜色文本
     *
     * @param canvas
     * @param middle
     * @deprecated
     */
    private void drawOrigin(Canvas canvas, int middle) {
        drawText(canvas, mOriginPaint, middle, getWidth());
    }

    public void setDirection(Direction direction) {
        mDirection = direction;
    }


}
