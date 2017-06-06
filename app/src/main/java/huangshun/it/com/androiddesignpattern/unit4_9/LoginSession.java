package huangshun.it.com.androiddesignpattern.unit4_9;

/**
 * Created by hs on 2017/6/6.
 */

public class LoginSession {
    static LoginSession sLoginSession = null;
    private User loginedUser;

    private LoginSession() {

    }

    public static LoginSession getInstance() {
        if (sLoginSession == null) {
            sLoginSession = new LoginSession();
        }
        return sLoginSession;
    }

    //设置已登录的用户信息,不对外开发
    void setLoginSession(User user) {
        loginedUser = user;
    }

    public User getLoginedUser() {
        return loginedUser;
    }
}
