package huangshun.it.com.androiddesignpattern.file;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import huangshun.it.com.androiddesignpattern.R;
import okhttp3.OkHttpClient;

public class FileActivity extends AppCompatActivity {
    private static final String TAG = "FileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
        init();
    }

    private void init() {
        File musicPath = FileUtils.getMusicPath(this);
        Log.i(TAG, FileUtils.getMusicPath(this) + "");
        getMusicName();
        if (musicPath != null) {
            String url = "https://mu.naptime.cn/netease/musics/57f07371be443a34fd59a55366ba04e1.mp3";
            MusicDownUtils.downloadFile(url, musicPath.getAbsolutePath(), "我爱你" + ".mp3", new HttpCallback<File>() {
                @Override
                public void onSuccess(File file) {
                    Log.d(TAG, "onSuccess() called with " + "file = [" + file + "]" + isInMainThread());
                }

                @Override
                public void onFail(Exception e) {
                    Log.d(TAG, "onFail() called with " + "e = [" + e + "]" + isInMainThread());
                }

                @Override
                public void onFinish() {
                    Log.d(TAG, "onFinish() called with " + "" + isInMainThread());
                    getMusicName();
                }

                @Override
                public void inProgress(float progress, long total, int id) {
                    Log.d(TAG, "inProgress() called with " + "progress = [" + progress + "], total = [" + total + "], id = [" + id + "]" + isInMainThread());
                }
            });
        }

    }

    private void getMusicName() {
        List<String> localMusicList = FileUtils.getLocalMusicList(this);
        if (localMusicList == null) {
            Log.i(TAG, "没有任何音乐");
        } else {
            for (int i = 0; i < localMusicList.size(); i++) {
                String s = localMusicList.get(i);
                Log.i(TAG, s);
            }

        }

    }

    public static boolean isInMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
