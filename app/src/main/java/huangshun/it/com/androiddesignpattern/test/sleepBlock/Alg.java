///*
//package huangshun.it.com.androiddesignpattern.test.sleepBlock;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//*/
///**
// * Created by hs on 2017/7/31.
// *//*
//
//
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class Alg {
//
//    */
///**
//     * 睡眠进入和退出规则常量
//     *//*
//
//    //皓玥：从20改到25
//    public static int SLEEP_START_QUIET_NUMBER = 25;
//    // 皓玥：从20改到15
//    public static int SLEEP_END_WAKE_NUMBER = 15;
//    // 睡眠开始条件中非安静容忍次数 从3改成2
//    public static int UNQUIET_NUM_BEGIN_SLEEP = 2;
//    // 睡眠结束条件中安静容忍次数 皓玥从5改成3
//    public static int QUIET_NUM_END_SLEEP = 3;
//    // 清醒区间中中安静容忍次数
//    public static int QUIET_NUM_IN_WAKE = 2;
//
//    */
///**
//     * 清醒和深睡眠判断条件
//     *//*
//
//    public static int WAKE_NUM_CONDITION = 5;
//
//    // 皓玥改：从10变成7 调整深睡眠长度
//    public static int DS_QUIET_MINUTE = 10;
//
//    // 每天睡眠理想时长
//    public static int SLEEP_MINUTES_PER_DAY = 8 * 60;
//    // 睡眠曲线的差距
//    // 深睡眠标准值
//    private static double DS_STANDARD_VALUE = 100.0;
//    // 浅睡眠的标准值
//    private static double LS_STANDARD_VALUE = 50.0;
//    // 清醒的标准值
//    private static double WAKE_STANDARD_VALUE = 10.0;
//
//    */
///**
//     * 验证原数据集是否连续
//     *
//     * @param rawData
//     * @return
//     *//*
//
//    public static boolean validateDateTime(List<DBRawData> rawData) {
//        if (null == rawData || rawData.size() <= 0) {
//            return false;
//        }
//        long diff = rawData.get(rawData.size() - 1).getDataTime().getTime()
//                - rawData.get(0).getDataTime().getTime();
//        return rawData.size() == 1 + diff / (60 * 1000);
//    }
//
//    */
///**
//     * 计算原始数据的类型。映射关系请查看RawDataTypeEnum
//     * WARMUP-热身运动
//     * STRIDE-健走
//     * RUN-跑步
//     * SPORT-运动
//     * QUIET-安静
//     * INACTIVE-不活跃
//     * WALKING-散步
//     * ACTIVE-活跃
//     *
//     * @param data
//     * @return
//     *//*
//
//
//    public static int getRawDataType(RawData data) {
//        //8.15 去掉了totalActions里面的swim 皓玥
//        int moves = data.getAlert() + data.getMove() + data.getWalk() + data.getRun();
//        int totalActions = data.getQuiet() + moves;
//        //增加了swim类型的判断 皓玥
//        if (moves > 15 && data.getSwim() >= 5) {
//            return RawDataTypeEnum.SWIM.getIndex();
//        } else if (data.getBongFlag() > 0) {
//            if (29 * (data.getQuiet() + data.getAlert() + data.getMove()) > 27 * totalActions) {
//                return RawDataTypeEnum.WARMUP.getIndex();
//            } else if (29 * (data.getWalk()) > 25 * totalActions) {
//                return RawDataTypeEnum.STRIDE.getIndex();
//            } else if (29 * data.getRun() > 20 * totalActions) {
//                return RawDataTypeEnum.RUN.getIndex();
//            } else {
//                return RawDataTypeEnum.SPORT.getIndex();
//            }
//        } else {
//            //			if (30 * data.getQuiet() > 28 * totalActions) {
//            //皓玥改：安静的判断条件变严格
//            if (data.getAlert() <= 1 && (data.getMove() + data.getWalk() + data.getRun()) == 0) {
//                return RawDataTypeEnum.QUIET.getIndex();
//                //皓玥改：Inactive的判断条件变严格
//            } else if ((data.getAlert() + data.getMove()) <= 10 && data.getMove() <= 5 && data.getWalk() + data.getRun() == 0 && data.getStep() == 0) {
//                return RawDataTypeEnum.INACTIVE.getIndex();
//            } else if (data.getStep() > 0) {
//                return RawDataTypeEnum.WALKING.getIndex();
//            } else {
//                return RawDataTypeEnum.ACTIVE.getIndex();
//            }
//        }
//    }
//
//    */
///**
//     * 由原始数据生成结果数据
//     *
//     * @param rawData
//     * @return
//     *//*
//
//    public static List<ResultData> generateResultData(List<RawData> rawData) {
//        List<ResultData> result = new ArrayList<ResultData>(rawData.size());
//        for (RawData raw : rawData) {
//            ResultData data = new ResultData();
//            data.setRawData(raw);
//            // 注入rawtype
//            data.setType(getRawDataType(raw));
//
//            result.add(data);
//
//        }
//        return result;
//    }
//
//    */
///**
//     * 获取睡眠程度值
//     *
//     * @param data
//     * @return
//     *//*
//
//    // 文峰弟弟，帮我改一下这个公式。我发邮件给你。文峰：这个方法我已经抛弃了，请看另外一个方法 从400行开始。
//    public static int genSleepValue(ResultData data) {
//        int totalActions = data.getRawData().getQuiet()
//                + data.getRawData().getAlert() + data.getRawData().getMove()
//                + data.getRawData().getWalk() + data.getRawData().getRun();
//        if (SleepTypeEnum.DS.getIndex() == data.getBlockType()) {
//            return 100
//                    * data.getRawData().getQuiet()
//                    / totalActions
//
//                    - 100
//                    * data.getRawData().getAlert()
//                    / totalActions
//
//                    - 200
//                    * (data.getRawData().getMove()
//                    + data.getRawData().getWalk()
//                    + data.getRawData().getRun()) / totalActions - 2
//                    * data.getRawData().getAmp() % 10;
//
//        } else if (SleepTypeEnum.LS.getIndex() == data.getBlockType()) {
//            return 50
//                    * data.getRawData().getQuiet()
//                    / totalActions
//                    - 50
//                    * data.getRawData().getAlert()
//                    / totalActions
//                    - 100
//                    * (data.getRawData().getMove()
//                    + data.getRawData().getWalk()
//                    + data.getRawData().getRun()) / totalActions - 2
//                    * data.getRawData().getAmp() % 10;
//        } else {
//            return data.getRawData().getAmp() % 10;
//
//        }
//    }
//
//    public static double fillSleepScore(List<ResultData> data, int begin,
//                                        int end, int targetSleepTime, SleepBlock sleepBlock) {
//        double score = 0.0;
//        // setp1&3
//        long diff = (data.get(end).getRawData().getDataTime().getTime() - data
//                .get(begin).getRawData().getDataTime().getTime())
//                / (60 * 1000);
//        if (diff >= targetSleepTime * 1.1) {
//            score = 5;
//        } else if (diff >= targetSleepTime * 1.05
//                && diff < targetSleepTime * 1.1) {
//            score = 4.5;
//        } else if (diff >= targetSleepTime * 0.95
//                && diff < targetSleepTime * 1.05) {
//            score = 4;
//        } else if (diff >= targetSleepTime * 0.88
//                && diff < targetSleepTime * 0.95) {
//            score = 3.5;
//        } else if (diff >= targetSleepTime * 0.75
//                && diff < targetSleepTime * 0.88) {
//            score = 3;
//        } else if (diff >= targetSleepTime * 0.5
//                && diff < targetSleepTime * 0.75) {
//            score = 2.5;
//        } else if (diff >= targetSleepTime * 0.45
//                && diff < targetSleepTime * 0.5) {
//            score = 2;
//        } else if (diff <= targetSleepTime * 0.45) {
//            score = 1;
//        }
//
//        // step2
//        if (diff > 2 * 60 && data.size() > 2 * 60) {
//            int wakeTimes = 0;
//            // 前一次睡眠类型
//            boolean wakeFlag = false;
//            for (int i = begin + 60; i <= end - 60; i++) {
//                if (!wakeFlag
//                        && SleepTypeEnum.WAKE.getIndex() == data.get(i)
//                        .getBlockType()) {
//                    wakeTimes++;
//                }
//                if (SleepTypeEnum.WAKE.getIndex() == data.get(i).getBlockType()) {
//                    wakeFlag = true;
//                } else {
//                    wakeFlag = false;
//                }
//            }
//
//            if (wakeTimes == 1) {
//                score -= 0.5;
//            } else if (wakeTimes >= 2) {
//                score -= 1;
//            }
//        }
//
//        // step4
//        int dsNum = 0;
//        for (int i = begin; i < end; i++) {
//            if (SleepTypeEnum.DS.getIndex() == data.get(i).getBlockType()) {
//                dsNum++;
//            }
//        }
//        if (dsNum > (end - begin) * 0.45) {
//            score += 1;
//        } else if (dsNum < (end - begin) * 0.45
//                && dsNum >= (end - begin) * 0.35) {
//            score += 0.5;
//        }
//
//        // step5
//        int beginHours = data.get(begin).getRawData().getDataTime().getHours();
//        if (0 == beginHours) {
//            score -= 0.5;
//        } else if (1 <= beginHours && 17 >= beginHours) {
//            score -= 1;
//        }
//        sleepBlock.setScore(Math.min(5, Math.max(0, score)));
//        return sleepBlock.getScore();
//
//    }
//
//    */
///**
//     * 计算给定时间区间内的SleepBlock data必须是按时间排序
//     *
//     * @param data
//     * @return
//     *//*
//
//    public static List<BlockBase> getSleepBlock(List<ResultData> data) {
//        if (null == data || data.size() <= 0) {
//            return null;
//        }
//
//        List<BlockBase> sleepBlocks = new ArrayList<BlockBase>();
//
//        int len = data.size();
//        int begin = 0;
//        int end = 0;
//        // quiet + unqiet at begin sleep
//        int quietNum = 0;
//
//        // 睡眠开始条件中非安静容忍队列
//        Queue<Integer> unquietQueue = new LinkedList<Integer>();
//        // 睡眠结束条件中安静容忍队列
//        Queue<Integer> quietQueue = new LinkedList<Integer>();
//
//        for (int i = 0; i < len - 1; i++) {
//            // 累计安静次数,中断后重新计数
//            if (RawDataTypeEnum.QUIET.getIndex() == data.get(i).getType()) {
//                quietNum++;
//            } else {
//                // 插入队列
//                unquietQueue.add(i);
//                if (unquietQueue.size() > UNQUIET_NUM_BEGIN_SLEEP) {
//                    quietNum = i - unquietQueue.remove();
//                } else {
//                    quietNum++;
//                }
//            }
//
//            // 睡眠开始
//            if (SLEEP_START_QUIET_NUMBER <= quietNum) {
//                // 初始化睡眠开始计算字段
//                quietNum = 0;
//                unquietQueue.clear();
//
//                // 注意i的游标从0开始
//                begin = i + 1 - SLEEP_START_QUIET_NUMBER;
//
//                SleepBlock sleep = new SleepBlock();
//                sleep.setType(BlockTypeEnum.SLEEP.getIndex());
//                sleep.setStartTime(data.get(begin).getRawData().getDataTime());
//
//                // 寻找睡眠结束点
//                int wakeNum = 0;
//                for (int j = i + 1; j < len; j++) {
//                    // 睡眠结束
//                    if (j == len - 1) {
//                        end = j;
//                    } else if (SLEEP_END_WAKE_NUMBER == wakeNum) {
//                        end = j - 1 - SLEEP_END_WAKE_NUMBER;
//                        break;
//                    }
//
//                    if (RawDataTypeEnum.QUIET.getIndex() != data.get(j)
//                            .getType()
//                            ) {
//                        wakeNum++;
//                    } else {
//                        quietQueue.add(j);
//                        if (quietQueue.size() > QUIET_NUM_END_SLEEP) {
//                            wakeNum = j - quietQueue.remove();
//                        } else {
//                            wakeNum++;
//                        }
//                    }
//                }
//
//                // 睡眠主体处理部分
//                // 睡眠特殊处理
//                // 小于40分钟不算睡眠
//                if (40 > (end - begin + 1)) {
//                    i = end;
//                    quietQueue.clear();
//                    continue;
//                }
//                // 大于40分钟
//                else {
//                    int sleepQuietNum = 0;
//                    for (int k = begin; k <= end; k++) {
//                        if (RawDataTypeEnum.QUIET.getIndex() == data.get(k)
//                                .getType()) {
//                            sleepQuietNum++;
//                        }
//                    }
//                    // 皓玥改过参数，小于1.5小时
//                    if ((60 * 1.5 >= (end - begin + 1))
//                            && sleepQuietNum * 100 > (end - begin + 1) * 85) {
//                        i = end;
//                        quietQueue.clear();
//                        continue;
//                        //大于1.5小时
//                    } else if ((60 * 1.5 < (end - begin + 1))
//                            && sleepQuietNum * 100 > (end - begin + 1) * 98) {
//                        i = end;
//                        quietQueue.clear();
//                        continue;
//                    }
//                }
//
//                // 1.把所有睡眠类型全部设置成浅睡眠
//                for (int k = begin; k <= end; k++) {
//                    data.get(k).setBlockType(SleepTypeEnum.LS.getIndex());
//                }
//
//                // 2.设置所有的深睡眠类型
//                int dsQuietMinutes = 0;
//                for (int k = begin; k <= end; k++) {
//                    if (dsQuietMinutes >= DS_QUIET_MINUTE) {
//                        for (int p = k; p <= end; p++) {
//                            if (RawDataTypeEnum.QUIET.getIndex() == data.get(p)
//                                    .getType()) {
//                                data.get(p).setBlockType(
//                                        SleepTypeEnum.DS.getIndex());
//                            } else {
//                                dsQuietMinutes = 0;
//                                k = p;
//                                break;
//                            }
//                        }
//                    }
//                    if (RawDataTypeEnum.QUIET.getIndex() == data.get(k)
//                            .getType()) {
//                        dsQuietMinutes++;
//                    } else {
//                        dsQuietMinutes = 0;
//                    }
//                }
//
//                // 3.设置所有的清醒类型
//                int wakeUnQuietMinutes = 0;
//                Queue<Integer> quietInWakeQueue = new LinkedList<Integer>();
//                for (int k = begin; k <= end; k++) {
//                    if (wakeUnQuietMinutes >= WAKE_NUM_CONDITION) {
//                        // 把这些全部设置成清醒,然后退出重新计数
//                        for (int p = k - WAKE_NUM_CONDITION; p < k; p++) {
//                            data.get(p).setBlockType(
//                                    SleepTypeEnum.WAKE.getIndex());
//                        }
//                        // 下一段清醒初始值
//                        wakeUnQuietMinutes = 0;
//                        quietInWakeQueue.clear();
//                    }
//                    //皓玥改：睡着了以后，InActive认为是翻身，不认做清醒。
//                    if (RawDataTypeEnum.QUIET.getIndex() != data.get(k)
//                            .getType()
//                            && RawDataTypeEnum.INACTIVE.getIndex() != data.get(k).getType()
//                            ) {
//                        wakeUnQuietMinutes++;
//                    } else {
//                        quietInWakeQueue.add(k);
//                        if (quietInWakeQueue.size() > QUIET_NUM_IN_WAKE) {
//                            wakeUnQuietMinutes = k - quietInWakeQueue.remove();
//                        } else {
//                            wakeUnQuietMinutes++;
//                        }
//                    }
//                }
//
//                // 生成睡眠区间中的value，保存sleepBlock
//                // for (int k = begin; k <= end; k++) {
//                // data.get(k).setValue(genSleepValue(data.get(k)));
//                // }
//                int currentType = data.get(begin).getBlockType();
//                int typeBegin = begin;
//                for (int k = begin; k <= end; k++) {
//                    if (data.get(k).getBlockType() == currentType && k != end) {
//                        continue;
//                    } else {
//                        // 一段类型结束，则计算它们的value
//                        if (SleepTypeEnum.DS.getIndex() == currentType) {
//                            for (int f = typeBegin; (k == end) ? f <= k : f < k; f++) {
//                                int mid = (k + typeBegin) / 2;
//                                int lenn = k - typeBegin + 1;
//                                data.get(f)
//                                        .setValue(
//                                                DS_STANDARD_VALUE
//                                                        + 20.0
//
//                                                        * Math.abs(lenn
//                                                        / 2
//                                                        - Math.abs(mid
//                                                        - f))
//                                                        / lenn);
//                            }
//                        } else if (SleepTypeEnum.LS.getIndex() == currentType) {
//                            for (int f = typeBegin; (k == end) ? f <= k : f < k; f++) {
//                                int mid = (k + typeBegin) / 2;
//                                int lenn = k - typeBegin + 1;
//                                data.get(f).setValue(
//                                        LS_STANDARD_VALUE
//                                                + 20.0
//                                                * Math.abs(lenn / 2
//                                                - Math.abs(mid - f))
//                                                / lenn);
//                            }
//                        } else {
//                            for (int f = typeBegin; (k == end) ? f <= k : f < k; f++) {
//                                int mid = (k + typeBegin) / 2;
//                                int lenn = k - typeBegin + 1;
//                                data.get(f).setValue(
//                                        WAKE_STANDARD_VALUE + 10.0
//                                                * Math.abs(mid - f) / lenn);
//                            }
//                        }
//
//                        // 重新计算类型
//                        typeBegin = k;
//                        currentType = data.get(k).getBlockType();
//                    }
//                }
//
//                sleep.setEndTime(data.get(end).getRawData().getDataTime());
//
//                // 填充数据
//                fillSleepBlock(data, begin, end, sleep);
//                sleepBlocks.add(sleep);
//
//                // 开始下一段睡眠
//                i = end;
//                quietQueue.clear();
//                unquietQueue.clear();
//            }
//
//        }
//        return sleepBlocks;
//    }
//
//    */
///**
//     * 计算给定时间区间内的CHARGING/TAKEOFF Blocks
//     *
//     * @param data
//     * @return
//     *//*
//
//    public static List<BlockBase> getChargingAndTakeoffBlocks(
//            List<ResultData> data) {
//        if (null == data || data.size() <= 1) {
//            return null;
//        }
//        List<BlockBase> blocks = new ArrayList<BlockBase>();
//
//        int len = data.size();
//        int begin = 0;
//        int end = 0;
//        int quietNum = 0;
//        for (int i = 0; i < len; i++) {
//            // chargingBlock开始
//            if (1 == data.get(i).getRawData().getChargeFlag()) {
//                int chargeBegin = i;
//                int chargeEnd = i;
//
//                ChargingBlock chargingBlock = new ChargingBlock();
//                chargingBlock.setType(BlockTypeEnum.CHARGING.getIndex());
//                chargingBlock.setStartTime(data.get(chargeBegin).getRawData()
//                        .getDataTime());
//                for (int j = i + 1; j <= len; j++) {
//                    if (j == len
//                            || 0 == data.get(j).getRawData().getChargeFlag()) {
//                        if (j == len) {
//                            chargeEnd = j - 1;
//                            break;
//                        }
//                        if (0 == data.get(j).getRawData().getChargeFlag()) {
//                            chargeEnd = j - 1;
//                            break;
//                        }
//                    }
//                }
//                chargingBlock.setEndTime(data.get(chargeEnd).getRawData()
//                        .getDataTime());
//                blocks.add(chargingBlock);
//                i = chargeEnd;
//                quietNum = 0;
//                continue;
//            }
//
//            // takeoffBlock开始
//            if (60 * 3 <= quietNum) {
//                int takeoffBegin = i - 60 * 3;
//                int takeoffEnd = i;
//
//                TakeOffBlock takeoffBlock = new TakeOffBlock();
//                takeoffBlock.setType(BlockTypeEnum.TAKEOFF.getIndex());
//                takeoffBlock.setStartTime(data.get(takeoffBegin).getRawData()
//                        .getDataTime());
//                for (int j = i + 1; j < len; j++) {
//                    if (j == len - 1) {
//                        takeoffEnd = j;
//                        break;
//                    }
//                    if (RawDataTypeEnum.QUIET.getIndex() == data.get(j)
//                            .getType()) {
//                        quietNum++;
//
//                    } else {
//                        takeoffEnd = j - 1;
//                        break;
//                    }
//                }
//                takeoffBlock.setEndTime(data.get(takeoffEnd).getRawData()
//                        .getDataTime());
//                blocks.add(takeoffBlock);
//                i = takeoffEnd;
//                quietNum = 0;
//                continue;
//            }
//            if (RawDataTypeEnum.QUIET.getIndex() == data.get(i).getType()) {
//                quietNum++;
//            } else {
//                quietNum = 0;
//            }
//
//        }
//        return blocks;
//
//    }
//
//    */
///**
//     * 填充睡眠块内字段
//     *
//     * @param data
//     * @param begin
//     * @param end
//     * @param sleepBlock
//     *//*
//
//    public static void fillSleepBlock(List<ResultData> data, int begin,
//                                      int end, SleepBlock sleepBlock) {
//        int dsNum = 0;
//        int lsNum = 0;
//        int wakeNum = 0;
//        int wakeTimes = 0;
//        // 前一次睡眠类型
//        boolean wakeFlag = false;
//        for (int i = begin; i <= end; i++) {
//            if (!wakeFlag
//                    && SleepTypeEnum.WAKE.getIndex() == data.get(i)
//                    .getBlockType()) {
//                wakeTimes++;
//            }
//
//            if (SleepTypeEnum.DS.getIndex() == data.get(i).getBlockType()) {
//                dsNum++;
//                wakeFlag = false;
//            } else if (SleepTypeEnum.LS.getIndex() == data.get(i)
//                    .getBlockType()) {
//                lsNum++;
//                wakeFlag = false;
//            } else if (SleepTypeEnum.WAKE.getIndex() == data.get(i)
//                    .getBlockType()) {
//                wakeNum++;
//                wakeFlag = true;
//            }
//
//        }
//
//        sleepBlock.setDsNum(dsNum);
//        sleepBlock.setLsNum(lsNum);
//        sleepBlock.setWakeNum(wakeNum);
//        sleepBlock.setWakeTimes(wakeTimes);
//        fillSleepScore(data, begin, end, SLEEP_MINUTES_PER_DAY, sleepBlock);
//    }
//
//}
//*/
