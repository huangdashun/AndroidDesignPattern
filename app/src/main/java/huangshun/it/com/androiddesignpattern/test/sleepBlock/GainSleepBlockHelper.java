//package huangshun.it.com.androiddesignpattern.test.sleepBlock;
//
//import android.text.TextUtils;
//import android.util.Log;
//
//import cn.ginshell.bong.model.BlockState;
//import cn.ginshell.bong.model.SECDATA;
//import cn.ginshell.bong.model.User;
//
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.ACTIVE_TYPE_COUNT;
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.nobo_ALERT;
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.nobo_DEEP_SLEEP;
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.nobo_LIGHT_SLEEP;
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.nobo_MOVE;
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.nobo_QUIET;
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.nobo_WAKE_UP;
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.oth_CHARGE;
//import static cn.ginshell.bong.model.SECDATA.ACTIVE_TYPE.oth_NOTWEAR;
//import static cn.ginshell.bong.model.SECDATA.RAWTYPE.BO_RUN;
//import static cn.ginshell.bong.model.SECDATA.RAWTYPE.BO_SPORT;
//import static cn.ginshell.bong.model.SECDATA.RAWTYPE.BO_STRIDE;
//import static cn.ginshell.bong.model.SECDATA.RAWTYPE.NB_INACTIVE;
//import static cn.ginshell.bong.model.SECDATA.RAWTYPE.NB_QUIET;
//import static huangshun.it.com.androiddesignpattern.test.sleepBlock.SECDATA.ACTIVE_TYPE.ACTIVE_TYPE_COUNT;
//import static huangshun.it.com.androiddesignpattern.test.sleepBlock.SECDATA.RAWTYPE.NB_QUIET;
//
//
///**
// * Created by cbf on 17/7/26.
// */
//
//public class GainSleepBlockHelper {
//    private static final String TAG = "GainSleepBlockHelper";
//    private static int mBolockLen = 0;
//    private static int mRawDataLength;
//    private static SECDATA.RAWDATA[] datas;
//    private static User mUser;
//    private static final int UNQUIET_NUM_BEGIN_SLEEP = 3;
//    private static final int QUIET_NUM_IN_WAKE = 3;
//    private static final int MAXSECTORLEN = 1440 * 3;
//    private static final int QUIET_NUM_END_SLEEP = 4;
//    private static final int SLEEP_END_WAKE_NUMBER = 15;
//    private static final int WAKE_NUM_CONDITION = 5;
//    private static final int DS_QUIET_MINUTE = 12;
//
//    private static final int SLEEP_START_QUIET_NUMBER = 25;
//
//    private static int gSectorLength;
//
//    public static void main(String[] args) {
////        setRawData()
//    }
//
//    public static boolean setRawData(long[] timestamp, short[] quiet, short[] steps, User user, long lastResportTimestamp) {
//
//        if (timestamp == null || quiet == null) {
//            return false;
//        }
//
//        if (timestamp.length != quiet.length) {
//            return false;
//        }
//
//        mRawDataLength = timestamp.length;
//        datas = new SECDATA.RAWDATA[mRawDataLength];
//
//        for (int i = 0; i < mRawDataLength; i++) {
//            SECDATA.RAWDATA data = new SECDATA.RAWDATA();
//            data.timestamp = (timestamp[i]);
//            data.quiet = ((int) quiet[i]);
//            data.steps = steps[i];
//            datas[i] = data;
//        }
//
//        mUser = user;
//        int gender = TextUtils.equals("1", user.getGender().trim()) ? 1 : 0;
//        mUser.setGender(String.valueOf(gender));
//
//        algorithmrun(mUser, datas, mRawDataLength, lastResportTimestamp);
//        return true;
//    }
//
//    private static SECDATA[] gSectors;
//    private static BlockState[] gBlock;
//
//    private static void algorithmrun(User user, SECDATA.RAWDATA[] datas, int rawDataLength, long lastResportTimestamp) {
//        int start = 0;
//        gSectors = new SECDATA[mRawDataLength];
//        gBlock = new BlockState[mRawDataLength];
//
//        getContinuousData(datas, start, rawDataLength - 1);
//
//        getSleepBlocks(user, gSectors, gSectorLength, gBlock, 0);
//    }
//
//
//    private static void getContinuousData(SECDATA.RAWDATA[] datas, int start, int rawDataLength) {
//
//        int i;
//
//        gSectorLength = rawDataLength - start;
//
//        // copy all rawdata to the sectors
//        for (i = start; i <= gSectorLength; i++) {
//
//            gSectors[i].rawdata = datas[i];
//        }
//
//
//    }
//
//
//    private static void getSleepBlocks(User user, SECDATA[] data, int data_len, BlockState[] block_add, int block_num) {
//        int i, j, k;
//        int begin = 0;
//        int quietnum = 0;
//        int[] unquietQUEUE = new int[UNQUIET_NUM_BEGIN_SLEEP];
//
//        int sleepquietnum = 0;
//
//        if (data == null) {
//            return;
//        }
//
//        for (i = 0; i <= data_len; i++) {
//            if (NB_QUIET == data[i].rawtype && ACTIVE_TYPE_COUNT == data[i].found_type) {
//                quietnum++;
//            } else {
//                for (k = 1; k < UNQUIET_NUM_BEGIN_SLEEP; k++) {
//                    unquietQUEUE[k - 1] = unquietQUEUE[k];
//                }
//                unquietQUEUE[UNQUIET_NUM_BEGIN_SLEEP - 1] = i;
//                if (unquietQUEUE[0] != 0) {
//                    quietnum = i - unquietQUEUE[0];
//                } else {
//                    quietnum++;
//                }
//
//                if (ACTIVE_TYPE_COUNT != data[i].found_type) {
//                    for (k = 0; k < UNQUIET_NUM_BEGIN_SLEEP; k++) {
//                        unquietQUEUE[k] = 0;
//                    }
//                    quietnum = 0;
//                }
//            }
//
//
//            if (SLEEP_START_QUIET_NUMBER <= quietnum) {
//                quietnum = 0;
//                for (k = 0; k < UNQUIET_NUM_BEGIN_SLEEP; k++) {
//                    unquietQUEUE[k] = 0;
//                }
//
//                begin = i + UNQUIET_NUM_BEGIN_SLEEP - SLEEP_START_QUIET_NUMBER;
//
//                findsleepend(data, data_len, begin);
//
//                if (40 > (end - begin + 1)) {
//                    i = end;
//                    continue;
//                } else {
//                    sleepquietnum = 0;
//                    for (j = begin; j <= end; j++) {
//                        if (NB_QUIET == data[j].rawtype) {
//                            sleepquietnum++;
//                        }
//                    }
//                    //todo 85->95?
//                    if (90 >= (end - begin + 1) && sleepquietnum * 100 > (end - begin + 1) * 95) {
//                        i = end;
//                        continue;
//                    } else if (90 < (end - begin + 1) && sleepquietnum * 100 > (end - begin + 1) * 98) {
//                        i = end;
//                        continue;
//                    } else {
//                        judgesleeptype(user, data, data_len, begin, end, block_add, block_num);
//                    }
//
//
//                }
//
//            }
//
//
//        }
//
//    }
//
//    private static void judgesleeptype(User user, SECDATA[] data, int data_len, int begin, int end, BlockState[] block_add, int block_num) {
//        finddeepsleep(user, data, data_len, begin, end, block_add, block_num);
//
//        findwakeup(user, data, data_len, begin + 30, end, block_add, block_num);
//
//        findlightsleep(user, data, data_len, begin, end, block_add, block_num);
//    }
//
//    private static void findlightsleep(User user, SECDATA[] data, int data_len, int start, int end, BlockState[] block_add, int block_num) {
//        int begin, stop;
//        int i, j;
//        for (i = start; i <= end; i++) {
//            if (ACTIVE_TYPE_COUNT == data[i].found_type) {
//                begin = i;
//                for (j = begin; j <= end; j++) {
//                    if (ACTIVE_TYPE_COUNT != data[j].found_type || end == j) {
//                        if (ACTIVE_TYPE_COUNT != data[j].found_type) {
//                            stop = j - 1;
//                        } else {
//                            stop = j;
//                        }
//
//
//                        generateBlocks(user, data, begin, stop, data_len, nobo_LIGHT_SLEEP, block_add, block_num);
//                        i = j;
//                        break;
//                    }
//                }
//            } else {
//                continue;
//            }
//        }
//    }
//
//    private static void findwakeup(User user, SECDATA[] data, int data_len, int start, int end, BlockState[] block_add, int block_num) {
//        int wakeupquietminutes = 0;
//        int[] quietinwake = new int[QUIET_NUM_IN_WAKE];
//
//        int i, j, k;
//        int begin;
//
//
//        for (i = start; i <= end; i++) {
//
//            if (NB_QUIET != data[i].rawtype && NB_INACTIVE != data[i].rawtype && ACTIVE_TYPE_COUNT == data[i].found_type) {
//                wakeupquietminutes++;
//            } else {
//                for (k = 1; k < QUIET_NUM_IN_WAKE; k++) {
//                    quietinwake[k - 1] = quietinwake[k];
//                }
//                quietinwake[QUIET_NUM_IN_WAKE - 1] = i;
//                if (quietinwake[0] != 0) {
//                    wakeupquietminutes = i - quietinwake[0];
//                } else {
//                    wakeupquietminutes++;
//                }
//
//                if (ACTIVE_TYPE_COUNT != data[i].found_type) {
//                    for (k = 0; k < QUIET_NUM_IN_WAKE; k++) {
//                        quietinwake[k] = 0;
//                    }
//                    wakeupquietminutes = 0;
//                }
//            }
//
//            if (wakeupquietminutes >= WAKE_NUM_CONDITION) {
//                begin = i - WAKE_NUM_CONDITION + QUIET_NUM_IN_WAKE;
//
//                for (j = i; j <= end; j++) {
//                    if (NB_QUIET != data[j].rawtype && NB_INACTIVE != data[j].rawtype && ACTIVE_TYPE_COUNT == data[j].found_type) {
//                        continue;
//                    } else {
//                        break;
//                    }
//                }
//                if (j - begin >= 4) {
//                    generateBlocks(user, data, begin, j - 1, data_len, nobo_WAKE_UP, block_add, block_num);
//                }
//                i = j;
//                for (k = 0; k < QUIET_NUM_IN_WAKE; k++) {
//                    quietinwake[k] = 0;
//                }
//                wakeupquietminutes = 0;
//
//            }
//
//        }
//
//        for (i = start; i <= end; i++) {
//
//            if (data[i].rawdata.steps > 0 && ACTIVE_TYPE_COUNT == data[i].found_type) {
//                begin = i;
//                for (j = i + 1; j <= end; j++) {
//                    if (data[j].rawdata.steps > 0 && ACTIVE_TYPE_COUNT == data[i].found_type) {
//                        continue;
//                    } else {
//                        break;
//                    }
//                }
//                if (j - begin >= 1) {
//                    generateBlocks(user, data, begin, j - 1, data_len, nobo_WAKE_UP, block_add, block_num);
//                } else {
//                    continue;
//                }
//            } else {
//                continue;
//            }
//
//        }
//    }
//
//    private static void generateBlocks(User user, SECDATA[] data, int start, int end, int data_len, SECDATA.ACTIVE_TYPE type, BlockState[] blocks, int block_num) {
//
//        int temp_end;
//
//        if (data[end].rawdata.timestamp >= data[start].rawdata.timestamp) {
//            while (data[end].rawdata.timestamp > 60 * 179 + data[start].rawdata.timestamp) {
//                temp_end = findSectors(data, data_len, data[start].rawdata.timestamp + 60 * 177);
//                addblocks(user, data, start, temp_end, data_len, type, blocks, block_num);
//                start = temp_end + 1;
//            }
//            addblocks(user, data, start, end, data_len, type, blocks, block_num);
//        }
//    }
//
//    private static int findSectors(SECDATA[] secdata, int sec_len, long timestamp) {
//        int i;
//        if (timestamp <= secdata[0].rawdata.timestamp) {
//            return 0;
//        } else if (timestamp >= secdata[sec_len].rawdata.timestamp) {
//            return sec_len;
//        } else {
//            for (i = 0; i <= sec_len; i++) {
//                if (secdata[i].rawdata.timestamp >= timestamp) {
//                    return i;
//                }
//            }
//        }
//        return sec_len;
//    }
//
//    private static void addblocks(User user, SECDATA[] data, int start, int end, int data_len, SECDATA.ACTIVE_TYPE type, BlockState[] blocks, int block_num) {
//        int i;
//        int steps = 0;
//        int distance = 0;
//        int calories = 0;
//        double stride;
//
////        memset(blocks[block_num],0,sizeof(BLOCK_STATE));
//
//        // set flag
//        for (i = start; i <= end; i++) {
//            data[i].found_type = type;
//        }
//
//        if (start > end) {
//            return;
//        }
//
//
//        // sum
//
//        if (oth_CHARGE == type || oth_NOTWEAR == type) {
//            steps = 0;
//            distance = 0;
//            calories = 0;
//        } else {
//            for (i = start; i <= end; i++) {
//                stride = getstride(data[i], user.getHeight());
//                distance += stride * data[i].rawdata.steps;
//                steps += data[i].rawdata.steps;
//                calories += data[i].energy * 100;
//            }
//        }
//
//        // start and end time
//        blocks[block_num].start_timestamp = data[start].rawdata.timestamp;
//
//        if (end == data_len) {
//            blocks[block_num].end_timestamp = data[end].rawdata.timestamp + 60;
//        } else {
//            blocks[block_num].end_timestamp = data[end + 1].rawdata.timestamp;
//        }
//
//        if (blocks[block_num].end_timestamp < blocks[block_num].start_timestamp) {
//            return;
//        }
//
//        // step distance
//        blocks[block_num].steps = steps;
//
//        blocks[block_num].distance = distance;
//
//        blocks[block_num].energy = calories;
//
//        // types
//
//        if (nobo_MOVE == type && steps < 500 && blocks[block_num].end_timestamp - blocks[block_num].start_timestamp < 1200) {
//            type = nobo_ALERT;
//        } else if (nobo_QUIET == type && steps > 30 && steps + blocks[block_num].start_timestamp / 2 > blocks[block_num].end_timestamp / 2) {
//            type = nobo_ALERT;
//        }
//        // TODO: 17/7/27   未完成
//
////        blocks[block_num].present_type = type;
//
//        // flags
////        blocks[block_num].out_flag |= OUT_FIXED;
//
//        block_num++;
//        for (int j = 0; j < block_num; j++) {
//            Log.e(TAG, "addblocks: " + blocks[j].toString());
//        }
//
//    }
//
//    private static double getstride(SECDATA secdata, Integer height) {
//        double stride;
//        if (secdata == null) {
//            return 0.0;
//        }
//        if (BO_STRIDE == secdata.rawtype) {
//            stride = Math.min(Math.max(0.7003 * height - 39.112, 60), 110);
//        } else if (BO_RUN == secdata.rawtype) {
//            stride = Math.min(Math.max(1.002 * height - 75, 70), 155);
//        } else if (BO_SPORT == secdata.rawtype) {
//            stride = Math.min(Math.max(0.7003 * height - 39.112, 60), 110);
//        } else {
//            stride = Math.min(Math.max(0.3265 * height + 12.799, 50), 85);
//        }
//        return (float) stride;
//    }
//
//
//    private static void finddeepsleep(User user, SECDATA[] data, int data_len, int start, int end, BlockState[] block_add, int block_num) {
//        int dsquietminutes = 0;
//        int i, j;
//        for (i = start; i <= end; i++) {
//
//            if (gettotalactions(data[i].rawdata) == data[i].rawdata.quiet) {
//                dsquietminutes++;
//            } else {
//                dsquietminutes = 0;
//            }
//
//            if (dsquietminutes >= DS_QUIET_MINUTE) {
//                for (j = i; j <= end; j++) {
//                    if (gettotalactions(data[j].rawdata) == data[j].rawdata.quiet || data[j].rawtype == NB_INACTIVE) {
//                        continue;
//                    } else {
//                        break;
//                    }
//                }
//                if (j - i >= 10) {
//                    generateBlocks(user, data, i + 1, j - 1, data_len, nobo_DEEP_SLEEP, block_add, block_num);
//                }
//                i = j;
//                dsquietminutes = 0;
//            }
//        }
//    }
//
//    private static int gettotalactions(SECDATA.RAWDATA rawdata) {
//        if (rawdata == null) {
//            return 0;
//        }
//        return rawdata.quiet + rawdata.alert + rawdata.move + rawdata.walk + rawdata.run + rawdata.swim;
//    }
//
//    private static int end;
//
//    private static void findsleepend(SECDATA[] data, int data_len, int begin) {
//        int wakenum = 0;
//        int j, i;
//        int[] quietqueue = new int[QUIET_NUM_END_SLEEP];
//
//
//        for (j = begin; j <= data_len; j++) {
//            if (j == data_len) {
//                end = j;
//                break;
//            } else if (ACTIVE_TYPE_COUNT != data[j].found_type) {
//                end = j - 1;
//                break;
//            } else if (SLEEP_END_WAKE_NUMBER <= wakenum) {
//                end = j - 2 - SLEEP_END_WAKE_NUMBER;
//                break;
//            }
//            SECDATA.RAWDATA rawdata = data[j].rawdata;
//            if (!(rawdata.alert <= 1 && 0 == rawdata.move + rawdata.walk + rawdata.run)) {
//                wakenum++;
//            } else {
//                for (i = 1; i < QUIET_NUM_END_SLEEP; i++) {
//                    quietqueue[i - 1] = quietqueue[i];
//                }
//                quietqueue[QUIET_NUM_END_SLEEP - 1] = j;
//                if (quietqueue[0] != 0 && quietqueue.length > 3) {
//                    wakenum = j - quietqueue[0];
//                } else {
//                    wakenum++;
//                }
//
//            }
//        }
//    }
//
//
//}
