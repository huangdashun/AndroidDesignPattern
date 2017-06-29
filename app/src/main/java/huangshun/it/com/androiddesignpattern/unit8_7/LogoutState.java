package huangshun.it.com.androiddesignpattern.unit8_7;

import android.content.Context;
import android.content.Intent;

/**
 * Created by hs on 2017/6/29.
 * 未登录状态
 */

public class LogoutState implements UserState {
    @Override
    public void forward(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    public void commend(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
