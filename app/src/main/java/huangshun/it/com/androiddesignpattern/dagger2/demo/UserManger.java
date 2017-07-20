package huangshun.it.com.androiddesignpattern.dagger2.demo;

/**
 * Created by hs on 2017/7/19.
 */

public class UserManger {
    private ApiService mApiService;
    private UserStore mUserStore;

    public UserManger(ApiService apiService) {
        mApiService = apiService;

    }

    public void register() {
        mApiService.register();
        mUserStore.register();
    }
}
