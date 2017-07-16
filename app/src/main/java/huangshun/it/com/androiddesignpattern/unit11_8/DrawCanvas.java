package huangshun.it.com.androiddesignpattern.unit11_8;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by hs on 2017/7/9.
 */

public class DrawCanvas extends SurfaceView implements SurfaceHolder.Callback {
    public boolean isDrawing, isRunning;//标识是否可以绘制,绘制线程是否可以运行
    private DrawInvoker mInvoker;

    public DrawCanvas(Context context) {
        this(context, null);
    }

    public DrawCanvas(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mInvoker = new DrawInvoker();
    }

    //增加一条绘制路径
    public void add(DrawPath path) {
        mInvoker.add(path);
    }

    //重做上一步撤销的绘制
    public void redo() {
        isDrawing = true;
        mInvoker.redo();
    }

    //撤销上一步
    public void undo() {
        isDrawing = true;
        mInvoker.undo();
    }

    //是否可以撤销
    public boolean canUndo() {
        return mInvoker.canUndo();
    }

    //是否可以重做
    public boolean canRedo() {
        return mInvoker.canRedo();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        SurfaceHolder holder1 = getHolder();//可以后去SurfaceHolder
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
