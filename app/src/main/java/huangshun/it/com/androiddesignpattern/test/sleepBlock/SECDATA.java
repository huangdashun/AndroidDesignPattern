package huangshun.it.com.androiddesignpattern.test.sleepBlock;

/**
 * Created by cbf on 17/7/26.
 */

public class SECDATA {
    public RAWTYPE rawtype;
    public double energy;
    public RAWDATA rawdata;
    public ACTIVE_TYPE found_type;
    short heartrate;

    public enum RAWTYPE{
        NB_QUIET,
        NB_VEHIC,
        NB_INACTIVE,
        NB_WALKING,
        NB_ACTIVE,
        BO_WARMUP,
        BO_BIKE,
        BO_STRIDE,
        BO_SPORT,
        BO_RUN,
        BO_SWIM,
        TOTALRAWTYPE,

        }
    public static class RAWDATA{
        public long timestamp;
        public int quiet;
        public int steps;
        public int alert;
        public int move;
        public int walk;
        public int run;
        public int swim;
    }
    public  enum ACTIVE_TYPE{
        nobo_LIGHT_SLEEP,      // light sleeping 浅睡眠
        nobo_DEEP_SLEEP ,      // deep sleeping 深睡眠
        nobo_WAKE_UP,
        nobo_ALERT ,            // small motions 活动
        nobo_MOVE,
        nobo_QUIET,
        oth_NOTWEAR,
        oth_CHARGE,
        ACTIVE_TYPE_COUNT ,     // total number of active state used for define arrays
    }

}
