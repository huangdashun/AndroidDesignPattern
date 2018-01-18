package huangshun.it.com.androiddesignpattern.gson;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hs on 2018/1/2.
 */

public class GradientView extends View {
    private Paint mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public GradientView(Context context) {
        this(context, null);
    }

    public GradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        init();
    }

    private void init() {
        //初始化背景画笔
        mBgPaint.setStyle(Paint.Style.FILL);
        mBgPaint.setColor(Color.BLUE);
//        mBgPaint.setShader(new LinearGradient(0, 0,
//                400, 400, new int[]{Color.BLUE, Color.WHITE, Color.RED},
//                null, Shader.TileMode.MIRROR));

        mLinePaint.setStyle(Paint.Style.FILL);
        mLinePaint.setStrokeWidth(3f);
        mLinePaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sc = canvas.saveLayerAlpha(0, 0, 400, 400, 255,
                Canvas.ALL_SAVE_FLAG);
        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(100, 100);
        path.lineTo(150, 150);
        path.lineTo(200, 180);
        path.lineTo(400, 400);
        path.lineTo(0, 400);
        path.close();
        canvas.drawPath(path, mLinePaint);
        mBgPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        mBgPaint.setShader(new LinearGradient(0, 0, 0, 400,
                Color.parseColor("#992e87e4"), Color.parseColor("#002e87e4"),
                Shader.TileMode.MIRROR));
        canvas.drawRect(0, 0, 400, 400, mBgPaint);


        mBgPaint.setXfermode(null);
        canvas.restoreToCount(sc);
    }
}

