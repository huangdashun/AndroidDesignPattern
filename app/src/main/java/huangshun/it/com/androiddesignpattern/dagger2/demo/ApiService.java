package huangshun.it.com.androiddesignpattern.dagger2.demo;

import android.util.Log;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Created by hs on 2017/7/19.
 */

public class ApiService {
    private static final String TAG = "ApiService";
    private OkHttpClient mOkHttpClient;

    @Inject
    public ApiService(OkHttpClient okHttpClient) {
        this.mOkHttpClient = okHttpClient;
    }

//    @Inject
//    public ApiService(String url) {
//        Log.d(TAG, "ApiService() called with " + "url = [" + url + "]");
//    }

    //服务器保存数据
    public void register() {
//        Log.i(TAG, "register")
        Log.d(TAG, "register() called with " + ""+this);
//        Request request = new Request.Builder().url("www.baidu.com").build();
//        mOkHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
    }
}
