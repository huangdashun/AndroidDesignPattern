package huangshun.it.com.androiddesignpattern.pace;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

import java.util.Locale;

/**
 * @author rqg
 * @date 11/6/15.
 */
public class SpanUtils {
    /**
     * result like  35 km/h
     *
     * @param value
     * @param unit
     * @param unitTextSize
     * @param unitTextColor
     * @return
     */
    public static CharSequence getUnitSpan(String value, String unit, int unitTextSize, int unitTextColor) {
        SpannableStringBuilder ssb = new SpannableStringBuilder();

        ssb.append(value);
        int len = ssb.length();
        ssb.append(unit);
        ssb.setSpan(new AbsoluteSizeSpan(unitTextSize)
                , len, len + unit.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ssb.setSpan(new ForegroundColorSpan(unitTextColor), len, len + unit.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        return ssb;
    }

    public static CharSequence getUnitSpan(String value, String unit, int unitTextSize) {
        SpannableStringBuilder ssb = new SpannableStringBuilder();

        ssb.append(value);
        int len = ssb.length();
        ssb.append(unit);
        ssb.setSpan(new AbsoluteSizeSpan(unitTextSize)
                , len, len + unit.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return ssb;
    }

    /**
     * 12:32:00
     *
     * @param second
     * @return
     */
    public static CharSequence getTimeSpan(long second) {

        int hour, minute;

        int ss = (int) (second % 60);

        second /= 60;

        hour = (int) (second / 60);
        minute = (int) (second % 60);

        if (hour == 0) {
            return String.format(Locale.ENGLISH, "%02d:%02d", minute, ss);
        } else {
            return String.format(Locale.ENGLISH, "%02d:%02d:%02d", hour, minute, ss);
        }


    }

    public static CharSequence getTimeSpan2(long second) {
        int minute;

        int ss = (int) (second % 60);

        minute = (int) (second / 60);


        return String.format(Locale.ENGLISH, "%02d'%02d\"", minute, ss);


    }

    /**
     * 时分秒都显示:12:32:00
     * @param second
     * @return
     */
    public static CharSequence getTimeSpanRun(long second) {

        int hour, minute;

        int ss = (int) (second % 60);

        second /= 60;

        hour = (int) (second / 60);
        minute = (int) (second % 60);

        return String.format(Locale.ENGLISH, "%02d:%02d:%02d", hour, minute, ss);


    }


}
