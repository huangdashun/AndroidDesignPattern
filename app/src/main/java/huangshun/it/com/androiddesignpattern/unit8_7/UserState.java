package huangshun.it.com.androiddesignpattern.unit8_7;

import android.content.Context;

/**
 * Created by hs on 2017/6/29.
 * 用户状态
 */

public interface UserState {
     void forward(Context context);

     void commend(Context context);
}
