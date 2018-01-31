package huangshun.it.com.androiddesignpattern.event;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by hs on 2018/1/19.
 */

public class RegionClickView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Region circleRegion;
    Path circlePath;

    public RegionClickView(Context context) {
        this(context, null);
    }

    public RegionClickView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public RegionClickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        circlePath.addCircle(w / 2, h / 2, 300, Path.Direction.CW);
        Region globalRegion = new Region(0, 0, w, h);
        circleRegion.setPath(circlePath, globalRegion);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path circle = circlePath;

        canvas.drawPath(circle, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (circleRegion.contains(x, y)) {
                    Toast.makeText(getContext(), "在圆内被点击", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }
//        Toast.makeText(getContext(), super.onTouchEvent(event) + "", Toast.LENGTH_SHORT).show();
        return true;
    }
}
