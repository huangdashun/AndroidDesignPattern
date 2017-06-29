package huangshun.it.com.androiddesignpattern.unit8_7;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hs on 2017/6/29.
 * 已登录状态
 */

public class LoginedState implements UserState {
    @Override
    public void forward(Context context) {
        Toast.makeText(context, "转发微博", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void commend(Context context) {
        Toast.makeText(context, "评论微博", Toast.LENGTH_SHORT).show();

    }
}
