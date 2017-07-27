package huangshun.it.com.androiddesignpattern.test.phonetype;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by hs on 2017/7/27.
 */

public class PhoneUtils {
    private static final String TAG = "PhoneUtils";

    public static PhoneType getPhoneType() {
        String value = Build.MODEL;
        String brand = Build.BRAND;
        Log.i(TAG, "getPhoneType() called with " + value);
        Log.i(TAG, "getPhoneType() called with " + brand);
        if (TextUtils.isEmpty(value) || TextUtils.isEmpty(brand)) {
            return PhoneType.OTHER;
        }
        brand = brand.toLowerCase();
        //优先根据brand区分
        if (brand.contains(PhoneType.MEIZU.toString())) {//魅族
            return PhoneType.MEIZU;
        } else if (brand.contains(PhoneType.XIAOMI.toString())) {//小米
            return PhoneType.XIAOMI;
        } else if (brand.contains(PhoneType.OPPO.toString())) {
            return PhoneType.OPPO;
        } else if (brand.contains(PhoneType.VIVO.toString())) {
            return PhoneType.VIVO;
        } else if (brand.contains(PhoneType.SAMSUNG.toString())) {
            return PhoneType.SAMSUNG;
        } else if (brand.contains(PhoneType.HONOR.toString())) {
            return PhoneType.HUAWEI;
        }
        //根据model区分
        value = value.toLowerCase();
        if (value.contains(PhoneType.VIVO.toString())) {
            return PhoneType.VIVO;
        } else if (value.contains(PhoneType.OPPO.toString())) {
            return PhoneType.OPPO;
        } else if (value.contains(PhoneType.XIAOMI.toString()) || value.contains(PhoneType.REDMI.toString()) || value.contains(PhoneType.MI.toString())) {
            return PhoneType.XIAOMI;
        } else if (value.contains(PhoneType.MEIZU.toString()) || value.contains(PhoneType.METAL.toString())) {
            return PhoneType.MEIZU;
        } else if (value.contains(PhoneType.HUAWEI.toString()) || value.contains(PhoneType.PLK.toString())) {
            return PhoneType.HUAWEI;
        } else if (value.contains(PhoneType.SAMSUNG.toString()) || value.contains(PhoneType.SM.toString())) {
            return PhoneType.SAMSUNG;
        } else {
            return PhoneType.OTHER;
        }
    }
}
