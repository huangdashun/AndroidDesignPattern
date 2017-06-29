package huangshun.it.com.androiddesignpattern.unit8_7;

import android.content.Context;

/**
 * Created by hs on 2017/6/29.
 * 用户接口和转台管理类
 */

public class LoginContext {
    static LoginContext mLoginContext = new LoginContext();
    private UserState mUserState = new LogoutState();

    private LoginContext() {
    }

    public static LoginContext getLoginContext() {
        return mLoginContext;
    }

    public void setUserState(UserState userState) {
        mUserState = userState;
    }

    //转发
    public void foward(Context context) {
        mUserState.forward(context);
    }

    //评论
    public void comment(Context context) {
        mUserState.commend(context);
    }
}
