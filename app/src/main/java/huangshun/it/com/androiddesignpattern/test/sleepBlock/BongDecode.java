package huangshun.it.com.androiddesignpattern.test.sleepBlock;

import android.util.Log;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;

/**
 * Created by hs on 2017/7/31.
 * bong 解码类
 */

public class BongDecode {
    public static final TimeZone CHINA_TIMEZONE = TimeZone.getTimeZone("GMT+08:00");

    /**
     * @param rawList
     * @return
     */
    public static List<DBRawData> decodeRawData(List<byte[]> rawList) {
        if (rawList == null) {
            return null;
        }
        List<DBRawData> DBRawDataList = new ArrayList<>(rawList.size() * 2);
        for (byte[] raw : rawList) {
            if (!concreteDecodeRawData(DBRawDataList, raw)) {
                Log.e(TAG, "decodeRawData failure ");
            }
        }
        return DBRawDataList;
    }

    /**
     * 具体的解析rawDataList
     *
     * @param rawDataList
     * @param raw
     * @return
     */
    private static boolean concreteDecodeRawData(List<DBRawData> rawDataList, byte[] raw) {
        if (raw == null || raw.length != 16 || rawDataList == null) {
            Log.e(TAG, "decodeRawData wrong raw data");
            return false;
        }

        DBRawData rd0 = new DBRawData();
        DBRawData rd1 = new DBRawData();
        int tmp;

        int year, month, day, hour, minute;

        short quiet0, quiet1;
        short alert0, alert1;
        short move0, move1;
        short walk0, walk1;
        short run0, run1;
        short swim0, swim1;
        short bongflag0, bongflag1;
        short chargeflag0, chargeflag1;
        short steps0, steps1;
        int amp0, amp1;
        int step_high0, step_high1;

        ByteBuffer bb = ByteBuffer.wrap(raw);

        //1
        tmp = bb.getInt();

        month = (tmp >> 28) & 0x0000000f;
        day = (tmp >> 23) & 0x0000001f;
        hour = (tmp >> 18) & 0x0000001f;
        minute = (tmp >> 12) & 0x0000003f;

        step_high0 = (tmp >> 4) & 0x00000080;
        step_high1 = (tmp >> 3) & 0x00000080;

        year = ((tmp >> 4) & 0x0000003f) + 2000;


        chargeflag0 = (short) ((tmp >> 3) & 0x00000001);
        bongflag0 = (short) ((tmp >> 2) & 0x00000001);
        chargeflag1 = (short) ((tmp >> 1) & 0x00000001);
        bongflag1 = (short) ((tmp) & 0x00000001);

        //2
        tmp = bb.getInt();

        quiet0 = (short) ((tmp >> 27) & 0x0000001f);
        alert0 = (short) ((tmp >> 22) & 0x0000001f);
        move0 = (short) ((tmp >> 17) & 0x0000001f);
        walk0 = (short) ((tmp >> 12) & 0x0000001f);
        run0 = (short) ((tmp >> 7) & 0x0000001f);
        steps0 = (short) ((tmp) & 0x0000007f);

        //3
        tmp = bb.getInt();

        quiet1 = (short) ((tmp >> 27) & 0x0000001f);
        alert1 = (short) ((tmp >> 22) & 0x0000001f);
        move1 = (short) ((tmp >> 17) & 0x0000001f);
        walk1 = (short) ((tmp >> 12) & 0x0000001f);
        run1 = (short) ((tmp >> 7) & 0x0000001f);
        steps1 = (short) ((tmp) & 0x0000007f);

        //4
        tmp = bb.getInt();

        swim0 = (short) ((tmp >> 28) & 0x0000000f);
        amp0 = (tmp >> 16) & 0x00000fff;
        swim1 = (short) ((tmp >> 12) & 0x0000000f);
        amp1 = (tmp) & 0x00000fff;


        if (step_high0 != 0) {
            steps0 += 0x80;
        }

        if (step_high1 != 0) {
            steps1 += 0x80;
        }


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(CHINA_TIMEZONE);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

//
//        Log.i(TAG, "decodeRawData raw = [" + String.format("%08X", tmp) + "], year = [" + year + "]" +
//                ", month = [" + month + "], day = [" + day + "], hour = [" + hour + "], minute = [" + minute + "], date = [" + calendar.getTime() + "]");

        long timestamp = calendar.getTimeInMillis() / 1000 - 60;

        rd0.setTimestamp(timestamp);
        rd0.setQuiet(quiet0);
        rd0.setAlert(alert0);
        rd0.setMove(move0);
        rd0.setWalk(walk0);
        rd0.setRun(run0);
        rd0.setSteps(steps0);
        rd0.setSwim(swim0);
        rd0.setAmp(amp0);
        rd0.setChargeflag(chargeflag0);
        rd0.setBongflag(bongflag0);


        timestamp += 60;
        rd1.setTimestamp(timestamp);
        rd1.setQuiet(quiet1);
        rd1.setAlert(alert1);
        rd1.setMove(move1);
        rd1.setWalk(walk1);
        rd1.setRun(run1);
        rd1.setSteps(steps1);
        rd1.setSwim(swim1);
        rd1.setAmp(amp1);
        rd1.setChargeflag(chargeflag1);
        rd1.setBongflag(bongflag1);


        rawDataList.add(rd0);
        rawDataList.add(rd1);

        return true;
    }

    /**
     * Created by cbf on 17/7/26.
     */

    public static class BlockState {
        public long start_timestamp;              // start time time stamp for this block  (单位：从1970年开始的秒数)
        public long end_timestamp;               // end time time stamp for this block (单位：从1970年开始的秒数)
    //    public  int present_type;           // present type (单位：无)
        public int energy;                       // energy (单位：10卡)
        public int steps;                        // steps (单位：步)
        public int distance;                     // distances (单位：厘米)
        public int swings;                      // swings (单位：划臂次数)
        public int cycles;                       // cycles (单位：绕泳池圈数)
        public int out_flag;

        @Override
        public String toString() {
            return "BlockState{" +
                    "start_timestamp=" + start_timestamp +
                    ", end_timestamp=" + end_timestamp +
                    ", energy=" + energy +
                    ", steps=" + steps +
                    ", distance=" + distance +
                    ", swings=" + swings +
                    ", cycles=" + cycles +
                    ", out_flag=" + out_flag +
                    '}';
        }
    }
}
