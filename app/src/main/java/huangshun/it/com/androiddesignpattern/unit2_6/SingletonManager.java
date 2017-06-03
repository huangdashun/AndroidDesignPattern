package huangshun.it.com.androiddesignpattern.unit2_6;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hs on 2017/5/28.
 */

public class SingletonManager {
    private static Map<String, Object> objMap = new HashMap<>();

    public static void addObj(String key, Object object) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, object);
        }
    }

    public static Object getObj(String key) {
        Object obj = objMap.get(key);
        return obj;
    }
}
