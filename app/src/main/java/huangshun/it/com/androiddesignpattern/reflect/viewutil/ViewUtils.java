package huangshun.it.com.androiddesignpattern.reflect.viewutil;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by hs on 2018/3/19.
 */

public class ViewUtils {
    public static void inject(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        Field[] declaredFields = activityClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            //暴力反射
            field.setAccessible(true);
            ViewInject annotation = field.getAnnotation(ViewInject.class);
            if (annotation != null) {
                int id = annotation.value();
                //获取控件
                View view = activity.findViewById(id);
                try {
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
