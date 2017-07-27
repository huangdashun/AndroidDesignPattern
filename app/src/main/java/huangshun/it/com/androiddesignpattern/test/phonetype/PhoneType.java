package huangshun.it.com.androiddesignpattern.test.phonetype;

/**
 * 手机类型
 * Created by hs on 2017/7/27.
 */

public enum PhoneType {
    VIVO,
    OPPO,
    XIAOMI,
    REDMI,//红米
    MI,
    MEIZU,
    METAL,
    HUAWEI,
    PLK,//华为荣耀系列
    HONOR,
    SAMSUNG,
    SM,//三星
    OTHER;//其他手机

    public String toString() {
        switch (this) {
            case VIVO:
                return "vivo";
            case OPPO:
                return "oppo";
            case XIAOMI:
                return "xiaomi";
            case REDMI:
                return "redmi";
            case MI:
                return "mi";
            case MEIZU:
                return "meizu";
            case METAL:
                return "metal";
            case HUAWEI:
                return "huawei";
            case PLK:
                return "plk";
            case HONOR:
                return "honor";
            case SAMSUNG:
                return "samsung";
            case SM:
                return "sm";
            default:
                return "other";
        }
    }
}
