package huangshun.it.com.androiddesignpattern.brainview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 获取显示信息
 *
 * @author MaTianyu
 * @date 2015-04-19
 */
public class DisplayUtil {
    private static final String TAG = DisplayUtil.class.getSimpleName();

    /**
     * 获取 显示信息
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm;
    }

    /**
     * 打印 显示信息
     */
    public static DisplayMetrics printDisplayInfo(Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);

        return dm;
    }

    /**
     * Converts the density-independent value into real pixel value based on display metrics
     *
     * @param context application context
     * @param dp      density-independent value
     * @return converted real pixel value
     */
    public static float dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dp * scale;
    }

    /**
     * @param context
     * @param px
     * @return
     */
    public static float px2Dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return px / scale;
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue px value
     * @param context （DisplayMetrics类中属性scaledDensity）
     * @return sp value
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue sp value
     * @param context （DisplayMetrics类中属性scaledDensity）
     * @return px value
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int getScreenWidthPixels(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.widthPixels;
    }

    public static int getScreenHeightPixels(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.heightPixels;
    }

    public static float getScreenDensity(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.density;
    }
}
