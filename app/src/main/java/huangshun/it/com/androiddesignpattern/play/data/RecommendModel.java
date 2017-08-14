package huangshun.it.com.androiddesignpattern.play.data;

import huangshun.it.com.androiddesignpattern.play.bean.PageBean;
import huangshun.it.com.androiddesignpattern.play.data.http.ApiService;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by hs on 2017/8/5.
 */

public class RecommendModel {

    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        mApiService = apiService;
    }

    public void getApps(Callback<PageBean> callback) {

        Call<PageBean> apkData = mApiService.getApkData("{'page':0}");
        apkData.enqueue(callback);
    }
}
