package huangshun.it.com.androiddesignpattern.unit4_9;

/**
 * Created by hs on 2017/6/6.
 */

public class LoginImpl implements Login {
    @Override
    public void login() {
        //登录服务器,获取到用户信息
        User loginedUser = new User();
        //将服务器返回的完成信息设置给loginedUser对象
        loginedUser.age = 22;
        loginedUser.name = "huangshun";
        loginedUser.address = new Address("北京市", "海淀区", "花园东路");
        LoginSession.getInstance().setLoginSession(loginedUser);
        System.out.println(LoginSession.getInstance().getLoginedUser().toString());
        User loginedUser1 = LoginSession.getInstance().getLoginedUser();
        loginedUser1.age =23;
//        LoginSession.getInstance().setLoginSession(loginedUser1);

        System.out.println(LoginSession.getInstance().getLoginedUser().toString());
    }

}
