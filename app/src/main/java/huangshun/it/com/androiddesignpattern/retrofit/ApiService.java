package huangshun.it.com.androiddesignpattern.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by hs on 2017/7/24.
 */

public interface ApiService {
    @GET("user/info")
    Call<User> getUserInfo();

    @GET("user/info/{id}")
    Call<User> getUserForId(@Path("id") int id);

    @POST("user/createinfo")
    Call<BaseResult> createUser(@Body User user);

    @FormUrlEncoded
    @POST("user/updateinfo")
    Call<BaseResult> updateUser(@Field("id") String id, @Field("username") String name);
}
