package huangshun.it.com.androiddesignpattern.play.http;

import huangshun.it.com.androiddesignpattern.play.bean.PageBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hs on 2017/8/4.
 */

public interface ApiService {
    String BASEURL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    public Call<PageBean> getApkData(@Query("p") String jsonparams);
}
