package huangshun.it.com.androiddesignpattern.pace;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.brainview.DisplayUtil;
import huangshun.it.com.androiddesignpattern.test.baodian.DateUtil;


/**
 * Created by hs on 2017/11/15.
 * 配速表
 */

public class ProPaceChart extends View {
    private static final String TAG = "ProPaceChart";
    private float MARGIN_LEFT, MARGIN_RIGHT;//左右margin
    private float mRectLeft;//矩形left
    private float mRectHeight;//矩形高度
    private float mRectMargin;//矩形之间的高度
    private float mPaceTotalWidth;//配速占的总宽度
    private int mHeight;//高度
    private int mWidth;//宽度
    private float mPaceTextLeft;//具体配速到左边矩形的距离

    private Paint mTipTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//负责绘制公里,配速等
    private Paint mKmTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//负责绘制01 02 03等
    private Paint mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//负责绘制矩形块
    private Paint mPaceTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//负责绘制具体的配速
    private Paint mAvgLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);//负责绘制平均值
    private Paint mLessKmTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//绘制少于1km的文字
    private String KM;
    private String PACE;
    private String AVG;
    private float[] mRectFRight;//存放配速Right的集合
    //数据
    private List<Long> mPaceTimeList = new ArrayList<>();
    private Long mAvg;
    private Long mMin;
    private Long mMax;
    private int mNoKmTime;

    private List<RectF> mTextList = new ArrayList<>();//存放文字位置的集合
    private List<RectF> mPaceRectList = new ArrayList<>();//存放配速矩形的集合

    public ProPaceChart(Context context) {
        this(context, null);
    }

    public ProPaceChart(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProPaceChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        MARGIN_LEFT = DisplayUtil.dp2Px(getContext(), 20);
        MARGIN_RIGHT = DisplayUtil.dp2Px(getContext(), 20);
        mRectLeft = DisplayUtil.dp2Px(getContext(), 39);
        mRectHeight = DisplayUtil.dp2Px(getContext(), 20);
        mRectMargin = DisplayUtil.dp2Px(getContext(), 2);
        mPaceTextLeft = DisplayUtil.dp2Px(getContext(), 15);
        mHeight = (int) DisplayUtil.dp2Px(getContext(), 100);//默认高度给个40dp,后面会根据数值动态
        KM = getResources().getString(R.string.pace_km);
        PACE = getResources().getString(R.string.pace);
        AVG = getResources().getString(R.string.avg);

        //初始化画笔
        mTipTextPaint.setStyle(Paint.Style.FILL);
        mTipTextPaint.setStrokeWidth(1);
        mTipTextPaint.setTextSize(DisplayUtil.dp2Px(getContext(), 12));
        mTipTextPaint.setColor(ContextCompat.getColor(getContext(), R.color.white_6));
        //01 02
        mKmTextPaint.setStyle(Paint.Style.FILL);
        mKmTextPaint.setStrokeWidth(1);
        mKmTextPaint.setFakeBoldText(true);//伪粗体
        mKmTextPaint.setTextSize(DisplayUtil.dp2Px(getContext(), 14));
        mKmTextPaint.setColor(ContextCompat.getColor(getContext(), R.color.black));

        mRectPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setColor(ContextCompat.getColor(getContext(), R.color.pro_pace_statistic_normal));

        //具体配速值
        mPaceTextPaint.setStyle(Paint.Style.FILL);
        mPaceTextPaint.setStrokeWidth(1);
        mPaceTextPaint.setFakeBoldText(true);//伪粗体
        mPaceTextPaint.setTextSize(DisplayUtil.dp2Px(getContext(), 14));
        mPaceTextPaint.setColor(ContextCompat.getColor(getContext(), R.color.white));

        //最后不足一公里用时
        mLessKmTextPaint.setStyle(Paint.Style.FILL);
        mLessKmTextPaint.setStrokeWidth(1);
        mLessKmTextPaint.setTextSize(DisplayUtil.dp2Px(getContext(), 12));
        mLessKmTextPaint.setColor(ContextCompat.getColor(getContext(), R.color.white_6));

        //平均线
        mAvgLinePaint.setStyle(Paint.Style.STROKE);
        mAvgLinePaint.setStrokeWidth(4);
        mAvgLinePaint.setColor(ContextCompat.getColor(getContext(), R.color.white_c));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        mWidth = width;
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
//        if (heightSpecMode == MeasureSpec.AT_MOST) {//wrap_content

//        }
        if (heightSpecMode == MeasureSpec.AT_MOST) {
            Log.i(TAG, "Wrap_content");
        } else if (heightSpecMode == MeasureSpec.UNSPECIFIED) {
            Log.i(TAG, "UNSPECIFIED");
        } else if (heightSpecMode == MeasureSpec.EXACTLY) {
            Log.i(TAG, "EXACTLY");
        }

        if (widthSpecMode == MeasureSpec.AT_MOST) {
            Log.i(TAG, "widthSpecMode:Wrap_content");
        } else if (widthSpecMode == MeasureSpec.UNSPECIFIED) {
            Log.i(TAG, "widthSpecMode:UNSPECIFIED");
        } else if (widthSpecMode == MeasureSpec.EXACTLY) {
            Log.i(TAG, "widthSpecMode:EXACTLY");
        }

        //配速矩形占的总宽度为
        mPaceTotalWidth = mWidth - mRectLeft;

        calculatorRect();
        setMeasuredDimension(mWidth, mHeight);
    }

    /**
     * 计算矩形
     */
    private void calculatorRect() {
        mTextList.clear();
        mPaceRectList.clear();

        if (mPaceTimeList.size() == 0) {
            return;
        }
        //配速矩形
        RectF temp = new RectF();
        temp.left = mRectLeft;
        temp.right = mWidth;
        temp.top = mRectHeight;
        temp.bottom = temp.top + mRectHeight;
        for (int i = 0; i < mPaceTimeList.size(); i++) {
            RectF paceRectF = new RectF(temp);
            paceRectF.right = mPaceTotalWidth * (Integer.valueOf(String.valueOf(mPaceTimeList.get(i))) * 1.0f / Integer.valueOf(String.valueOf(mMax))) + mRectLeft;
            temp.set(paceRectF);
            temp.top = temp.bottom + mRectMargin;
            temp.bottom = temp.top + mRectHeight;
            mPaceRectList.add(paceRectF);
        }

        //公里 01 02
        for (int i = 0; i < mPaceRectList.size(); i++) {
            RectF temp2 = new RectF(mPaceRectList.get(i));
            temp2.left = 0;
            mTextList.add(temp2);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTip(canvas);
        drawPaceRect(canvas);
        drawKmText(canvas);
        drawPaceText(canvas);
        drawNoTimeKm(canvas);//绘制最后不足一公里这句话
        drawAvgLine(canvas);//绘制平均线
    }

    private void drawAvgLine(Canvas canvas) {
        if (mAvg == 0L || mPaceRectList.size() == 0 || mPaceTimeList.size() == 0) {
            return;
        }
        //绘制平均线
        mAvgLinePaint.setPathEffect(new DashPathEffect(new float[]{20, 10, 20, 10}, 0));
        RectF firstRectF = mPaceRectList.get(0);
        RectF lastRectF = mPaceRectList.get(mPaceRectList.size() - 1);
        Path path = new Path();
        float avgWidth = mPaceTotalWidth * (Integer.valueOf(String.valueOf(mAvg)) * 1.0f / Integer.valueOf(String.valueOf(mMax)));
        path.moveTo(avgWidth, firstRectF.top);
        path.lineTo(avgWidth, lastRectF.bottom);
        canvas.drawPath(path, mAvgLinePaint);

        //绘制平均俩字
        Rect rect = new Rect();
        mTipTextPaint.getTextBounds(AVG, 0, AVG.length(), rect);
        canvas.drawText(AVG, avgWidth - rect.width() / 2, rect.height(), mTipTextPaint);

    }

    /**
     * 绘制配速Text
     *
     * @param canvas
     */
    private void drawPaceText(Canvas canvas) {
        if (mPaceTimeList.size() == 0) {
            return;
        }
        for (int i = 0; i < mPaceTimeList.size(); i++) {
            RectF rectF = mPaceRectList.get(i);
            float middle = (rectF.bottom + rectF.top) / 2;
            Rect textBound = new Rect();
            String text = SpanUtils.getTimeSpan2(mPaceTimeList.get(i)).toString();
            mPaceTextPaint.getTextBounds(text, 0, text.length(), textBound);
            int textMiddle = (textBound.top + textBound.bottom) / 2;
            int yOffset = -textMiddle;
            canvas.drawText(text, 0, text.length(), rectF.left + mPaceTextLeft, middle + yOffset, mPaceTextPaint);
        }
    }

    /**
     * 绘制矩形块
     *
     * @param canvas
     */
    private void drawPaceRect(Canvas canvas) {

        if (mPaceTimeList.size() == 0 || mPaceRectList.size() == 0) {
            return;
        }
        mRectPaint.setColor(ContextCompat.getColor(getContext(), R.color.pro_pace_rect_bg));
        //绘制背景矩形块
        for (int i = 0; i < mPaceRectList.size(); i++) {
            canvas.drawRect(mPaceRectList.get(i).left, mPaceRectList.get(i).top, mWidth, mPaceRectList.get(i).bottom, mRectPaint);
        }

        //绘制具体的配速矩形块
//        for (int i = 0; i < mPaceRectList.size(); i++) {
//            if (Objects.equals(mMin, mPaceTimeList.get(i))) {//配速最小的变颜色
//                mRectPaint.setColor(ContextCompat.getColor(getContext(), R.color.pro_pace_statistic_icon));
//            } else {
//                mRectPaint.setColor(ContextCompat.getColor(getContext(), R.color.pro_pace_statistic_normal));
//            }
//            canvas.drawRect(mPaceRectList.get(i), mRectPaint);
//        }
//        animatePaceRect();
        for (int i = 0; i < mPaceRectList.size(); i++) {
            RectF paceRect = mPaceRectList.get(i);
            RectF rectF = new RectF();
            rectF.left = paceRect.left;
            rectF.bottom = paceRect.bottom;
            rectF.top = paceRect.top;
            rectF.right = mRectFRight[i];
            canvas.drawRect(rectF, mRectPaint);
        }
    }



    public void animatePaceRect() {
        for (int i = 0; i < mPaceRectList.size(); i++) {
            RectF rectF = mPaceRectList.get(i);
            ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, rectF.right);
            valueAnimator.setDuration(1200);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            int index = i;
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    rectF.right = (float) animation.getAnimatedValue();
                    mRectFRight[index] = rectF.right;
                    postInvalidate();
                }
            });
            valueAnimator.start();
        }
    }

    /**
     * 绘制01 02
     *
     * @param canvas
     */
    private void drawKmText(Canvas canvas) {
        if (mTextList.size() > 0) {
            for (int i = 0; i < mTextList.size(); i++) {
                RectF rectF = mTextList.get(i);
                float middle = (rectF.bottom + rectF.top) / 2;
                Rect textBound = new Rect();
                String text;
                if ((i + 1) > 10) {
                    text = "" + i;
                } else {
                    text = "0" + i;
                }
                mKmTextPaint.getTextBounds(text, 0, text.length(), textBound);
                int textMiddle = (textBound.top + textBound.bottom) / 2;

                int yOffset = -textMiddle;
                canvas.drawText(text, 0, text.length(), rectF.left, middle + yOffset, mKmTextPaint);
            }
        }
    }

    /**
     * 绘制不足一公里
     *
     * @param canvas
     */
    private void drawNoTimeKm(Canvas canvas) {
//        if (mNoKmTime == 0L) {
//            //则不绘制  最后不足一公里这句话,
//        } else {
        RectF temp = new RectF();
        if (mPaceRectList.size() != 0) {//如果有矩形块,则画在矩形块下面
            RectF rectF = mPaceRectList.get(mPaceRectList.size() - 1);
            temp.set(rectF);
            temp.top = temp.bottom + mRectMargin;
            temp.bottom = temp.top + mRectHeight;
        } else {
            //画在tip下面
            temp.left = mRectLeft;
            temp.right = mWidth;
            temp.top = mRectHeight;
            temp.bottom = temp.top + mRectHeight;
        }
        //进行测量
        String str = getResources().getString(R.string.pace_less_km_tip, DateUtil.getTimeInterval(mNoKmTime));
        Rect bound = new Rect();

        mLessKmTextPaint.getTextBounds(str, 0, str.length(), bound);
        int textMiddle = (bound.top + bound.bottom) / 2;
        float middle = (temp.top + temp.bottom) / 2;
        int yOffset = -textMiddle;
        canvas.drawText(str, 0, str.length(), temp.left + mPaceTextLeft, middle + yOffset, mLessKmTextPaint);
    }
//    }

    /**
     * 绘制公里,配速,tip
     *
     * @param canvas
     */
    private void drawTip(Canvas canvas) {
        Rect rect = new Rect();
        mTipTextPaint.getTextBounds(KM, 0, KM.length(), rect);
        canvas.drawText(KM, 0, rect.height(), mTipTextPaint);
        canvas.drawText(PACE, DisplayUtil.dp2Px(getContext(), 53), rect.height(), mTipTextPaint);
    }


    public void refreshView(List<Long> paceTimeList, Long avg, Long max, Long min, int noKmTime) {
        mPaceTimeList = paceTimeList;
        mAvg = avg;
        mMax = max;
        mMin = min;
        mNoKmTime = noKmTime;
        mRectFRight = new float[paceTimeList.size()];
        //后续要设置高度,待定
        mHeight = (int) DisplayUtil.dp2Px(getContext(), (paceTimeList.size() * 25 + 45));
        requestLayout();
        invalidate();
        animatePaceRect();
    }
}
