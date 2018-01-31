package huangshun.it.com.androiddesignpattern.event;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by hs on 2018/1/19.
 */

public class RegionView extends android.view.View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public RegionView(Context context) {
        this(context, null);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawHalfOval(canvas);
        drawOpView(canvas);

    }

    private void drawOpView(Canvas canvas) {
        Rect rect1 = new Rect(100, 100, 400, 200);
        Rect rect2 = new Rect(200, 0, 300, 300);

        //构造一个画笔，画出矩形轮廓
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        canvas.drawRect(rect1, paint);
        canvas.drawRect(rect2, paint);

        //构造两个Region

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.INTERSECT);

        drawRegion(canvas, region1);

    }

    private void drawHalfOval(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        //构造一个椭圆路径
        Path ovalPath = new Path();
        RectF rectF = new RectF(50, 50, 200, 500);

        ovalPath.addOval(rectF, Path.Direction.CCW);
        Region region = new Region();
        region.setPath(ovalPath, new Region(50, 50, 200, 200));

        drawRegion(canvas, region);
    }

    private void drawRegion(Canvas canvas, Region region) {
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (regionIterator.next(rect)) {
            canvas.drawRect(rect, mPaint);
        }

    }
}
