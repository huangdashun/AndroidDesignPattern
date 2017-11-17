package huangshun.it.com.androiddesignpattern.pace;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hs on 2017/11/17.
 */

public class CustomLayout extends ViewGroup {
    public CustomLayout(Context context) {
        this(context, null);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
//
//        int defaultWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
//        int defaultHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
//        setMeasuredDimension(defaultWidth, defaultHeight);
//        measureToCustom(widthMeasureSpec, heightMeasureSpec);
        measureToCustomMargin(widthMeasureSpec, heightMeasureSpec);


    }

    /**
     * 不支持margin的测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    private void measureToCustom(int widthMeasureSpec, int heightMeasureSpec) {
        //获得此ViewGroup上级容器为其推荐的宽和高,以及计算模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int layoutWidth = 0;
        int layoutHeight = 0;
        //计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int count = getChildCount();
        if (widthMode == MeasureSpec.EXACTLY) {//精确的
            layoutWidth = widthSize;
        } else {
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                layoutWidth = child.getMeasuredWidth() > layoutWidth ? child.getMeasuredWidth() : layoutWidth;
            }
        }
        if (heightMode == MeasureSpec.EXACTLY) {//精确的
            layoutHeight = heightSize;
        } else {
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                layoutHeight = child.getMeasuredHeight() > layoutHeight ? child.getMeasuredHeight() : layoutHeight;
            }
        }

        setMeasuredDimension(layoutWidth, layoutHeight);
    }

    /**
     * 支持margin的测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    private void measureToCustomMargin(int widthMeasureSpec, int heightMeasureSpec) {
        //获得此ViewGroup上级容器为其推荐的宽和高,以及计算模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int layoutWidth = 0;
        int layoutHeight = 0;
        //计算出所有的childView的宽和高
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
        }
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int count = getChildCount();
        if (widthMode == MeasureSpec.EXACTLY) {//精确的
            layoutWidth = widthSize;
        } else {
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                CustomLayoutParams params = (CustomLayoutParams) child.getLayoutParams();
                int marginWidth = (child.getMeasuredWidth() + params.leftMargin + params.rightMargin);
                layoutWidth = marginWidth > layoutWidth ? marginWidth : layoutWidth;
            }
        }
        if (heightMode == MeasureSpec.EXACTLY) {//精确的
            layoutHeight = heightSize;
        } else {
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                CustomLayoutParams params = (CustomLayoutParams) child.getLayoutParams();
                int marginHeight = child.getMeasuredHeight() + params.topMargin + params.bottomMargin;
                layoutHeight = marginHeight > layoutHeight ? marginHeight : layoutHeight;
            }
        }

        setMeasuredDimension(layoutWidth, layoutHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        //起始值
//        int childMeasureWidth = 0;
//        int childMeasureHeight = 0;
//        int count = getChildCount();
//
//        //容器中已经占据的宽度和高度
//        int layoutWidth = 0;
//        int layoutHeight = 0;
//        int maxChildHeight = 0;//当前行控件最高的控件,决定下一行的view的位置
//        for (int i = 0; i < count; i++) {
//            View child = getChildAt(i);
//            childMeasureWidth = child.getMeasuredWidth();
//            childMeasureHeight = child.getMeasuredHeight();
//
//            if (layoutWidth < getWidth()) {//说明这一行还没有排满,继续往右排列
//                l = layoutWidth;
//                t = layoutHeight;
//                r = layoutWidth + childMeasureWidth;
//                b = t + childMeasureHeight;
//            } else {
//                //排满后换行
//
//                layoutWidth = 0;
//                layoutHeight += maxChildHeight;
//                maxChildHeight = 0;
//
//                l = layoutWidth;
//                t = layoutHeight;
//                r = childMeasureWidth + l;
//                b = t + childMeasureHeight;
//            }
//
//            layoutWidth += childMeasureWidth;//宽度累加
//            if (maxChildHeight < childMeasureHeight) {
//                maxChildHeight = childMeasureHeight;
//            }
//
//            child.layout(l, t, r, b);
//        }
//        layoutToCustom(l, t);
        layoutToCustomMargin(l, t);
    }

    /**
     * 不支持margin的布局
     *
     * @param l
     * @param t
     */
    private void layoutToCustom(int l, int t) {
        int count = getChildCount();
        int childMeasureWidth = 0;
        int childMeasureHeight = 0;
        CustomLayoutParams parmas;

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            childMeasureWidth = child.getMeasuredWidth();
            childMeasureHeight = child.getMeasuredHeight();

            parmas = (CustomLayoutParams) child.getLayoutParams();

            switch (parmas.position) {
                case CustomLayoutParams.POSITION_MIDDLE://中间
                    l = (getWidth() - childMeasureWidth) / 2;
                    t = (getWidth() - childMeasureHeight) / 2;
                    break;
                case CustomLayoutParams.POSITION_BOTTOM://左下角
                    l = 0;
                    t = getHeight() - childMeasureHeight;
                    break;
                case CustomLayoutParams.POSITION_LEFT://左上方
                    l = 0;
                    t = 0;
                    break;
                case CustomLayoutParams.POSITION_RIGHT://右上方
                    l = getWidth() - childMeasureWidth;
                    t = 0;
                    break;
                case CustomLayoutParams.POSITION_RIGHTANDBOTTOM://右下方
                    l = getWidth() - childMeasureWidth;
                    t = getHeight() - childMeasureHeight;
                    break;
                default:
                    break;
            }

            //确定子控件的位置
            child.layout(l, t, l + childMeasureWidth, t + childMeasureHeight);

        }
    }


    /**
     * 支持margin的布局
     *
     * @param l
     * @param t
     */
    private void layoutToCustomMargin(int l, int t) {
        int count = getChildCount();
        int childMeasureWidth = 0;
        int childMeasureHeight = 0;
        CustomLayoutParams parmas;

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            childMeasureWidth = child.getMeasuredWidth();
            childMeasureHeight = child.getMeasuredHeight();

            parmas = (CustomLayoutParams) child.getLayoutParams();

            switch (parmas.position) {
                case CustomLayoutParams.POSITION_MIDDLE://中间
                    l = (getWidth() - childMeasureWidth) / 2 + parmas.leftMargin - parmas.rightMargin;
                    t = (getWidth() - childMeasureHeight) / 2 + parmas.topMargin - parmas.bottomMargin;
                    break;
                case CustomLayoutParams.POSITION_BOTTOM://左下角
                    l = 0 + parmas.leftMargin;
                    t = getHeight() - childMeasureHeight - parmas.bottomMargin;
                    break;
                case CustomLayoutParams.POSITION_LEFT://左上方
                    l = 0 + parmas.leftMargin;
                    t = 0 + parmas.topMargin;
                    break;
                case CustomLayoutParams.POSITION_RIGHT://右上方
                    l = getWidth() - childMeasureWidth - parmas.rightMargin;
                    t = 0 + parmas.topMargin;
                    break;
                case CustomLayoutParams.POSITION_RIGHTANDBOTTOM://右下方
                    l = getWidth() - childMeasureWidth - parmas.rightMargin;
                    t = getHeight() - childMeasureHeight - parmas.bottomMargin;
                    break;
                default:
                    break;
            }

            //确定子控件的位置
            child.layout(l, t, l + childMeasureWidth, t + childMeasureHeight);

        }
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new CustomLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new CustomLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new CustomLayoutParams(getContext(), attrs);
    }

    @Override
    protected boolean checkLayoutParams(LayoutParams p) {
        return p instanceof CustomLayoutParams;
    }
}
