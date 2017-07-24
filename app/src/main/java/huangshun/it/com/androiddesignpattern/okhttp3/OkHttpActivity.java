package huangshun.it.com.androiddesignpattern.okhttp3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import huangshun.it.com.androiddesignpattern.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.R.attr.path;

public class OkHttpActivity extends AppCompatActivity {
    private static final String TAG = "OkHttpActivity";
    @BindView(R.id.btn_get)
    Button mBtnGet;
    @BindView(R.id.btn_post_form)
    Button mBtnPostForm;
    @BindView(R.id.btn_post_json)
    Button mBtnPostJson;
    @BindView(R.id.btn_down_simple)
    Button mBtnDownSimple;
    @BindView(R.id.progressBar_simple)
    ProgressBar mProgressBarSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.bind(this);
        requestPermission();
    }

    public void getRequest(View view) {
        OkHttpClient okHttpClient = new OkHttpClient();

        String url = "https://www.baidu.com";

        Request request = new Request.Builder().url(url).build();
        //enqueue 是异步  execute是同步
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure() called with " + "call = [" + call + "], e = [" + e + "]");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();

                Log.d(TAG, "onResponse() called with " + result);
            }
        });
    }

    @OnClick({R.id.btn_get, R.id.btn_post_form, R.id.btn_post_json, R.id.btn_down_simple})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                get();
                break;
            case R.id.btn_post_form:
                postFrom();
                break;
            case R.id.btn_post_json:
                postJson();
                break;
            case R.id.btn_down_simple:
                downloadSimple();
                break;
            default:
                break;
        }
    }


    private void postJson() {
        String url = Config.API.BASE_URL + "login/json";
        JSONObject jsonObject = new JSONObject();
        String username = "huangshun";
        String password = "123456";
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonParams = jsonObject.toString();

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonParams);
        Request request = new Request
                .Builder()
                .url(url)
                .post(requestBody)
                .build();
        okHttpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                    }
                });
    }


    private void get() {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "https://mofanggetqingqiu.com";
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure() called with " + "call = [" + call + "], e = [" + e + "]");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(result);
//                        getDouble("key")  取值 不存在 或者类型不对 报错
//                        optDouble("key",0)  取值 不存在 返回默认值
                        jsonObject.optString("id");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    private void postFrom() {
        String url = Config.API.BASE_URL + "login";

        String username = "huangshun";
        String password = "123456";

        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure() called with " + "call = [" + call + "], e = [" + e + "]");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                }
            }
        });
    }

    /**
     * 用简单的模式下载文件
     */
    private void downloadSimple() {
        String url = "http://bongapp.b0.upaiyun.com/app/bong_2.7.2.apk";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        okHttpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        updateUiUseSimplte(response);
                    }
                });
    }

    private void updateUiUseSimplte(Response response) {
        //获取输入流
        InputStream inputStream = response.body().byteStream();

        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(absolutePath, "bong");
        Log.d("OkHttpActivity", "path:" + path);
        FileOutputStream fileOutputStream = null;
        try {
            //创建一个输出流
            fileOutputStream = new FileOutputStream(file);
            long size = 0;
            byte[] b = new byte[1024];
            int len = 0;
            //获取总字节
            long length = response.body().contentLength();
            while ((len = inputStream.read(b)) != -1) {
                fileOutputStream.write(b);
                size += len;
                int progress = (int) (size * 1.0f / length * 100);
                Log.i(TAG, "progress:" + progress);
                Message message = mHandler.obtainMessage(1);
                message.arg1 = progress;
                mHandler.sendMessage(message);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mProgressBarSimple.setProgress(msg.arg1);
                    break;
            }
        }
    };
    public static final int EXTERNAL_STORAGE_REQ_CODE = 10;

    public void requestPermission() {
        //判断当前Activity是否已经获得了该权限
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            //如果App的权限申请曾经被用户拒绝过，就需要在这里跟用户做出解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "please give me the permission", Toast.LENGTH_SHORT).show();
            } else {
                //进行权限请求
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        EXTERNAL_STORAGE_REQ_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        switch (requestCode) {
            case EXTERNAL_STORAGE_REQ_CODE: {
                // 如果请求被拒绝，那么通常grantResults数组为空
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //申请成功，进行相应操作

                    Toast.makeText(OkHttpActivity.this, "已获取权限", Toast.LENGTH_LONG).show();
                } else {
                    //申请失败，可以继续向用户解释。
                }
                return;
            }
        }

    }


}
