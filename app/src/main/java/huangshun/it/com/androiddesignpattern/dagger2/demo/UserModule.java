package huangshun.it.com.androiddesignpattern.dagger2.demo;

import android.content.Context;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hs on 2017/7/19.
 */

@Module
public class UserModule {

    @Inject
    Context mContext;
    private static final String TAG = "UserModule";

    //    @Provides
//    public ApiService provideApiService() {
//        Log.d(TAG, "provideApiService() called with " + "");
//        return new ApiService();
//    }

    @Inject
    public UserModule(Context context) {
        mContext = context;
    }


//    @Release
//    @Provides
//    public ApiService provideApiServiceRelease(OkHttpClient okHttpClient) {
//        Log.i(TAG, "provideApiServiceRelease----release");
//        return new ApiService(okHttpClient);
//    }
//
//    @Text
//    @Provides
//    public ApiService provideApiServiceDev(OkHttpClient okHttpClient) {
//        Log.i(TAG, "provideApiServiceDev----dev");
//        return new ApiService(okHttpClient);
//    }

    @Provides
    public UserStore provideUserStore() {
        return new UserStore(this.mContext);
    }

    @Provides
    public UserManger provideUserManger(ApiService apiService) {
        return new UserManger(apiService);
    }

}
