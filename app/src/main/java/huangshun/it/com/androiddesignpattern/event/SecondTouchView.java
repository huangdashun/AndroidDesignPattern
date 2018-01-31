package huangshun.it.com.androiddesignpattern.event;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hs on 2018/1/19.
 */

public class SecondTouchView extends View {
    private static final String TAG = "MultiTouchView";
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Region circleRegion;
    Path circlePath;
    private boolean hasSecondPoint;//判断第二个手指是否存在
    PointF mPointF = new PointF(0, 0);

    public SecondTouchView(Context context) {
        this(context, null);
    }

    public SecondTouchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public SecondTouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setColor(0xFF4E5268);
        circlePath = new Path();
        circleRegion = new Region();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

//        circlePath.addCircle(w / 2, h / 2, 300, Path.Direction.CW);
//        Region globalRegion = new Region(0, 0, w, h);
//        circleRegion.setPath(circlePath, globalRegion);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Path circle = circlePath;

//        canvas.drawPath(circle, mPaint);
        if (hasSecondPoint) {
            canvas.drawCircle(mPointF.x, mPointF.y, 50, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();//pointIndex
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_MOVE:
                if (hasSecondPoint) {
                    int pointIndex = event.findPointerIndex(1);
                    mPointF.set(event.getX(pointIndex), event.getY(pointIndex));
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getPointerId(index) == 1) {
                    hasSecondPoint = true;
                    mPointF.set(event.getX(), event.getY());
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                if (event.getPointerId(index) == 1) {//如果抬起的手指是第二个
                    hasSecondPoint = false;
                    mPointF.set(0, 0);
                }
                break;

            default:
                break;
        }
        invalidate();
//        Toast.makeText(getContext(), super.onTouchEvent(event) + "", Toast.LENGTH_SHORT).show();
        return true;
    }


}
