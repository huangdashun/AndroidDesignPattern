package huangshun.it.com.androiddesignpattern.Bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


/**
 * Created by hs on 2018/1/31.
 * 高效加载Bitmap
 */

public class BitmapUtil {
    /**
     * ①将BitmapFactory.Options的inJustDecodeBounds参数设为true并加载图片。
     * ②从BitmapFactory.Options中取出图片的原始宽高信息，它们对应于outWidth和outHeight参数。
     * ③根据采样率的规则并结合目标View的所需大小计算出采样率inSampleSize。
     * ④将BitmapFactory.Options的inJustDecodeBounds参数设为false，然后重新加载图片。
     */

    public static Bitmap decodeSampledBitmapFromResource(Resources resource, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        //1.将BitmapFactory.Options的inJustDecodeBounds参数设置为true
        options.inJustDecodeBounds = true;
        //1.1加载图片
        BitmapFactory.decodeResource(resource, resId, options);
        //2.从BitmapFactory.Options中取出图片的原始宽高信息，它们对应于outWidth和outHeight参数
        options.inSampleSize = calculateInSampleSize(options, reqHeight, reqWidth);
        //4.将BitmapFactory.Options的inJustDecodeBounds参数设为false,然后重新加载图片。
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resource, resId, options);
    }

    //  3.根据采样率的规则并结合目标View的所需大小计算出采样率
    private static int calculateInSampleSize(BitmapFactory.Options options, int reqHeight, int reqWidth) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

}
