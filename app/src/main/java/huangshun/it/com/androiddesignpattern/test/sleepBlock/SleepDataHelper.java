package huangshun.it.com.androiddesignpattern.test.sleepBlock;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hs on 2017/7/31.
 */

public class SleepDataHelper {
    /**
     * 传入通过手环接收到的rawList ,将rawList转成rawDataList
     *
     * @param rawList
     * @param endTime
     * @param startTime
     */
    public static void handleRspList(List<byte[]> rawList, long endTime, long startTime) {
        Log.d(TAG, "handleRspList start = [" + new Date(startTime * 1000) + "] end = [" + new Date(endTime * 1000) + "]");
        if (rawList == null) rawList = new ArrayList<>();

        List<DBRawData> rawDataList = BongDecode.decodeRawData(rawList);

        handleRawData(rawDataList, endTime, startTime);
    }

    private static void handleRawData(List<DBRawData> rawDataList, long endTime, long startTime) {
        Log.d(TAG, "handleRawData() called with: " + "rawDataList = [" + rawDataList.size() + "], endTime = [" + endTime + "], startTime = [" + startTime + "]");
        if (rawDataList == null) {
            return;
        }
        rawDataList = rawDataList.subList(rawDataList.size() > 4319 ? rawDataList.size() - 4139 : 0, rawDataList.size());
    }
}
