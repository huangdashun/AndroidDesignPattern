package huangshun.it.com.androiddesignpattern.test.baodian;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by hackill on 15/10/20.
 */
public class DateUtil {


    /***
     * 获取当前年份
     *
     * @return
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    private static final String TAG = DateUtil.class.getSimpleName();
    private static TimeZone timeZone = TimeZone.getDefault();


    /**
     * Adds a number of minutes to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date   the date, not null
     * @param amount the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * Adds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date          the date, not null
     * @param calendarField the calendar field to add to
     * @param amount        the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }


    public static SimpleDateFormat getDateFormat(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.getDefault());
        format.setTimeZone(timeZone);
        return format;
    }

    /**
     * "2014-01-16 18:59:00"
     * ex. 可用于返回的时间格式的转换
     *
     * @param strTime
     * @return
     */
    public static Date parseCommonDateTime(String strTime) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            formatter.setTimeZone(timeZone);
            return formatter.parse(strTime);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public static Date parseHHmmDateTime(String strTime) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
            formatter.setTimeZone(timeZone);
            return formatter.parse(strTime);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }


    /**
     * "Mar 2, 2015 12:00:00 AM" -- 专用于活跃点查询
     * ex. 可用于返回的时间格式的转换
     *
     * @param strTime
     * @return
     */
    public static Date parseActDateTime(String strTime) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy hh:mm:ss a", Locale.ENGLISH);
            formatter.setTimeZone(timeZone);
            return formatter.parse(strTime);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    /**
     * "Feb 25, 2015" -- 专用于趋势查询
     * ex. 可用于返回的时间格式的转换
     *
     * @param strTime
     * @return
     */
    public static Date parseSumsDateTime(String strTime) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
            formatter.setTimeZone(timeZone);
            return formatter.parse(strTime);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    /**
     * "2014-01-16"
     * ex. 可用于返回的时间格式的转换
     *
     * @param strTime
     * @return
     */
    public static Date parseyyyyMMdd(String strTime) {
        return parseyyyyMMdd(strTime, timeZone);
    }

    public static Date parseyyyyMMdd2(String strTime) {//时间格式变了
        return parseyyyyMMdd2(strTime, timeZone);
    }

    public static Date parseyyyyMMdd(String strTime, TimeZone timeZone) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            formatter.setTimeZone(timeZone);
            return formatter.parse(strTime);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public static Date parseyyyyMMdd2(String strTime, TimeZone timeZone) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            formatter.setTimeZone(timeZone);
            return formatter.parse(strTime);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public static Date parseToDate(String time, String rex) {
        return parseToDate(time, rex, timeZone);
    }

    public static Date parseToDate(String time, String rex, TimeZone timeZone) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(rex, Locale.getDefault());
            formatter.setTimeZone(timeZone);
            return formatter.parse(time);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    /**
     * "2014-01-16 18:59:00" => "2014-01-16"
     *
     * @param strTime
     * @return
     */
    public static String tranDateTime2Date(String strTime) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            formatter.setTimeZone(timeZone);
            Date d = formatter.parse(strTime);
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            formatter2.setTimeZone(timeZone);
            return formatter2.format(d);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * 2014-01-16 18:59:00 => "2014-01-16"
     *
     * @param date
     * @return
     */
    public static String tranDate2DateStr(Date date) {
        try {
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            formatter2.setTimeZone(timeZone);
            return formatter2.format(date);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * 2014-01-16 18:59:00 => "2014-01-16 18:59:00"
     *
     * @param date
     * @return
     */
    public static String tranDate2DateTimeStr(Date date) {
        return tranDate2DateTimeStr(date, timeZone);
    }

    /**
     * 2014-01-16 18:59:00 => "2014-01-16 18:59:00"
     *
     * @param date
     * @return
     */
    public static String tranDate2DateTimeStr(Date date, TimeZone timeZone) {
        try {
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            formatter2.setTimeZone(timeZone);
            return formatter2.format(date);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * 2014-01-16 18:59:00 => "2014-01-16 18:59:00"
     * 转换时区
     *
     * @return
     */
    public static String transDateTimeZone(String time, TimeZone t1, TimeZone t2) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            formatter.setTimeZone(t1);
            Date date = formatter.parse(time);
            formatter.setTimeZone(t2);
            return formatter.format(date);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * 2014-01-16 18:59:00 => "2014-01-16 18:59:00"
     * 转换时区
     *
     * @return
     */
    public static String transDateZone(String time, TimeZone t1, TimeZone t2) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            formatter.setTimeZone(t1);
            Date date = formatter.parse(time);
            formatter.setTimeZone(t2);
            return formatter.format(date);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * -8小时
     * 2014-01-16 18:59:00 => "2014-01-16 10:59:00"
     *
     * @param date
     * @return
     */
    public static String tranDate2DateTimeStrMinus8(Date date) {
        try {
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            formatter2.setTimeZone(timeZone);
            return formatter2.format(new Date(date.getTime() - 8 * 60 * 60 * 1000));
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * 2014-01-16 18:59:00 => "yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @return
     */
    public static String tranDate2Custom(Date date, String pattern) {
        try {
            SimpleDateFormat formatter2 = new SimpleDateFormat(pattern, Locale.getDefault());
            formatter2.setTimeZone(timeZone);
            return formatter2.format(date);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * 2014-01-16 18:59:00 => "18:59"
     *
     * @param date
     * @return
     */
    public static String tranDate2TimeLabel(Date date) {
        try {
            SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
            formatter2.setTimeZone(timeZone);
            return formatter2.format(date);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * date  => "yyyy-MM-dd"
     *
     * @param date
     * @return
     */
    public static String tranDate2yyyyMMdd(Date date) {
        try {
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            formatter2.setTimeZone(timeZone);
            return formatter2.format(date);
        } catch (Throwable e) {
            Log.e(TAG, e.toString());
            return "2014-01-01";
        }
    }

    /**
     * 得到两个Date间的时间间隔 以分钟、小时等自动智能显示
     * 是 endtime - starttime + 1min
     *
     * @param startTime
     * @param endTime
     */
    public static String getTimeIntervalStr(Date startTime, Date endTime) {
        int mins = getTimeIntervalMinutes(startTime, endTime);
        if (mins < 60) {
            return mins + " 分钟";
        } else if (mins < 24 * 60) {
            return (mins / 60) + " 小时 " + (mins % 60) + " 分钟";
        } else {
            return ((mins / 60) / 24) + "天" + ((mins / 60) % 24) + "小时" + (mins % 60) + "分钟";
        }
    }

    /**
     * 得到两个Date间的时间间隔 以分钟、小时等自动智能显示 如 1’30
     * 是 endtime - starttime + 1min
     *
     * @param startTime
     * @param endTime
     */
    public static String getTimeIntervalSimpleStr(Date startTime, Date endTime) {
        int mins = getTimeIntervalMinutes(startTime, endTime);
        return getTimeIntervalSimpleStr(mins);
    }


    /**
     * 08:30:31
     *
     * @param seconds
     * @return
     */
    public static String getTimeInterval(int seconds) {

        int hour = seconds / 3600;
        seconds %= 3600;
        int min = seconds / 60;
        int second = seconds % 60;
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hour, min, second);

    }

    /**
     * 得到以分钟、小时等自动智能显示 如 1’30
     *
     * @param mins
     */
    public static String getTimeIntervalSimpleStr(int mins) {
        if (mins < 60) {
            return mins + "";
        } else if (mins < 24 * 60) {
            return (mins / 60) + "’" + (mins % 60) + "";
        } else {
            return ((mins / 60) / 24) + "d" + ((mins / 60) % 24) + "’" + (mins % 60) + "";
        }
    }

    /**
     * 是 endtime - starttime + 1min
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getTimeIntervalMinutes(Date startTime, Date endTime) {
        return (int) ((endTime.getTime() - startTime.getTime()) / 60000) + 1;
    }

    /**
     * @param time
     * @return
     */
    public static String tranStr2UploadDate(String time) {
        Date date = parseCommonDateTime(time);
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
        formatter2.setTimeZone(timeZone);
        return formatter2.format(date);
    }

    /**
     * @param date
     * @return
     */
    public static String tranStr2UploadDate(Date date) {
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
        formatter2.setTimeZone(timeZone);
        return formatter2.format(date);
    }

    /**
     * 格式化时间值
     *
     * @param lDate
     * @return
     */
    public static String formatDateDefault(long lDate) {


        Date date = new Date(lDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        dateFormat.setTimeZone(timeZone);

        return dateFormat.format(date);
    }

    /**
     * 格式化时间值
     *
     * @param lDate
     * @return
     */
    public static String formatDateDefault2(long lDate) {


        Date date = new Date(lDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM-dd HH:mm", Locale.getDefault());
        dateFormat.setTimeZone(timeZone);

        return dateFormat.format(date);
    }

    public static String formatDateDefault3(long lDate) {


        Date date = new Date(lDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM/dd HH:mm", Locale.getDefault());
        dateFormat.setTimeZone(timeZone);

        return dateFormat.format(date);
    }


    /**
     * 格式化时间值
     *
     * @param lDate
     * @return
     */
    public static String formatHourMinDefault(long lDate) {
        Date date = new Date(lDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "HH:mm");
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(date);
    }

    /**
     * 格式化时间值
     *
     * @param lDate
     * @return
     */
    public static String formatHourMinSecondDefault(long lDate) {
        Date date = new Date(lDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "HH:mm:ss");
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(date);
    }

    /**
     * 格式化时间值
     *
     * @param lDate
     * @return
     */
    public static String formatYMDDefault(long lDate) {
        Date date = new Date(lDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(date);
    }

    /**
     * 格式化时间值
     *
     * @param lDate
     * @return
     */
    public static String formatYMD(long lDate) {
        Date date = new Date(lDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy/MM/dd", Locale.getDefault());
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(date);
    }

    /**
     * 格式化时间值
     *
     * @param lDate
     * @return
     */

    public static String formatD(long lDate) {
        Date date = new Date(lDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "d", Locale.getDefault());
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(date);
    }


//    /**
//     * 获取天
//     *
//     * @param lData
//     * @return
//     */
//    public static Date formatDate(long lData) {
//        try {
//            Date date = new Date(lData);
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//            formatter.setTimeZone(timeZone);
//
//            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//            formatter2.setTimeZone(timeZone);
//            return formatter2.parse(formatter.format(date));
//        } catch (Throwable e) {
//            Log.e(TAG, e.toString());
//            return new Date();
//        }
//    }

    /**
     * <p>Checks if two date objects are on the same day ignoring time.</p>
     * <p/>
     * <p>28 Mar 2002 13:45 and 28 Mar 2002 06:01 would return true.
     * 28 Mar 2002 13:45 and 12 Mar 2002 13:45 would return false.
     * </p>
     *
     * @param date1 the first date, not altered, not null
     * @param date2 the second date, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either date is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }


    public static boolean isToday(long time) {

        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(time);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeInMillis(System.currentTimeMillis());
        return isSameDay(cal1, cal2);
    }

    /**
     * <p>Checks if two calendar objects are on the same day ignoring time.</p>
     * <p/>
     * <p>28 Mar 2002 13:45 and 28 Mar 2002 06:01 would return true.
     * 28 Mar 2002 13:45 and 12 Mar 2002 13:45 would return false.
     * </p>
     *
     * @param cal1 the first calendar, not altered, not null
     * @param cal2 the second calendar, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either calendar is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param time
     * @return
     */
    public static long parseStringToLong(String time) {
        Date date = parseCommonDateTime(time);

        if (date == null) {
            return System.currentTimeMillis();
        }
        return date.getTime();
    }

    /**
     * HH:mm
     *
     * @param time
     * @return
     */
    public static long parseHHmmStringToLong(String time) {
        Date date = parseCommonDateTime(time);

        if (date == null) {
            return System.currentTimeMillis();
        }
        return date.getTime();
    }

    /**
     * 将时间戳的秒和毫秒去掉
     */
    public static long transformData(long time) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTimeInMillis();
    }

    /**
     * 将时间戳的毫秒去掉
     */
    public static long transformDataDeleteMill(long time) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTimeInMillis();
    }
}
