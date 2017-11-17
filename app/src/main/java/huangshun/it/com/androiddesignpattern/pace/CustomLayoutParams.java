package huangshun.it.com.androiddesignpattern.pace;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.ViewGroup;

import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2017/11/17.
 */

public class CustomLayoutParams extends ViewGroup.MarginLayoutParams {
    public static final int POSITION_MIDDLE = 0; // 中间
    public static final int POSITION_LEFT = 1; // 左上方
    public static final int POSITION_RIGHT = 2; // 右上方
    public static final int POSITION_BOTTOM = 3; // 左下角
    public static final int POSITION_RIGHTANDBOTTOM = 4; // 右下角

    public int position = POSITION_LEFT;  // 默认我们的位置就是左上角

    public CustomLayoutParams(Context c, AttributeSet attrs) {
        super(c, attrs);
        TypedArray array = c.obtainStyledAttributes(attrs, R.styleable.CustomLayout);
        position = array.getInt(R.styleable.CustomLayout_layout_position, position);
    }

    public CustomLayoutParams(@Px int width, @Px int height) {
        super(width, height);
    }

    public CustomLayoutParams(ViewGroup.LayoutParams source) {
        super(source);
    }

    public CustomLayoutParams(ViewGroup.MarginLayoutParams source) {
        super(source);
    }
}
