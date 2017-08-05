package huangshun.it.com.androiddesignpattern.play.data;

import huangshun.it.com.androiddesignpattern.play.bean.PageBean;
import huangshun.it.com.androiddesignpattern.play.http.ApiService;
import huangshun.it.com.androiddesignpattern.play.http.HttpManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by hs on 2017/8/5.
 */

public class RecommendModel {

    public void getApps(Callback<PageBean> callback) {
        HttpManager httpManager = new HttpManager();
        Retrofit retrofit = httpManager.getRetrofit(httpManager.getOkHttpClient());
        ApiService apiService = retrofit.create(ApiService.class);
        Call<PageBean> apkData = apiService.getApkData("{'page':0}");
        apkData.enqueue(callback);
    }
}
