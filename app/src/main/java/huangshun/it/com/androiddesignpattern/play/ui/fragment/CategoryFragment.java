package huangshun.it.com.androiddesignpattern.play.ui.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.play.bean.PageBean;
import huangshun.it.com.androiddesignpattern.play.http.ApiService;
import huangshun.it.com.androiddesignpattern.play.http.HttpManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by hs on 2017/8/2.
 */

public class CategoryFragment extends Fragment {
    private static final String TAG = "CategoryFragment";
    private TextView mTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        Typeface fromAsset = Typeface.createFromAsset(getActivity().getAssets(), "iconfont.ttf");
        mTextView = (TextView) view.findViewById(R.id.yunshu);
        mTextView.setTypeface(fromAsset);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.i(TAG, "setUserVisibleHint");
        super.setUserVisibleHint(isVisibleToUser);
    }

    private void initData() {
        HttpManager httpManager = new HttpManager();
        Retrofit retrofit = httpManager.getRetrofit(httpManager.getOkHttpClient());
        ApiService apiService = retrofit.create(ApiService.class);
        Call<PageBean> apkData = apiService.getApkData("{'page':0}");
        apkData.enqueue(new Callback<PageBean>() {
            @Override
            public void onResponse(Call<PageBean> call, Response<PageBean> response) {
                PageBean body = response.body();
                int status = body.getStatus();
                Log.i(TAG, "status:" + status);
                Toast.makeText(getActivity(), "status", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PageBean> call, Throwable t) {
                Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
                Log.i(TAG, t.toString());
            }
        });
    }
}

