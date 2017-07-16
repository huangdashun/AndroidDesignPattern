package huangshun.it.com.androiddesignpattern.unit11_8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by hs on 2017/7/9.
 * 具体绘制路径的命令
 */

public class DrawPath implements IDraw {
    private Path mPath;
    private Paint mPaint;

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public void undo() {

    }
}
