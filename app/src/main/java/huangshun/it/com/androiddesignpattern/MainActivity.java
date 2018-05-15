package huangshun.it.com.androiddesignpattern;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.Button;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import huangshun.it.com.androiddesignpattern.ble.BleActivity;
import huangshun.it.com.androiddesignpattern.brainview.BrainWaveActivity;
import huangshun.it.com.androiddesignpattern.event.EventActivity;
import huangshun.it.com.androiddesignpattern.file.FileActivity;
import huangshun.it.com.androiddesignpattern.googlemap.MainMapActivity;
import huangshun.it.com.androiddesignpattern.greendao.GreenDao3Activity;
import huangshun.it.com.androiddesignpattern.gson.GsonActivity;
import huangshun.it.com.androiddesignpattern.material.MaterialActivity;
import huangshun.it.com.androiddesignpattern.okhttp3.OkHttpActivity;
import huangshun.it.com.androiddesignpattern.pace.PaceActivity;
import huangshun.it.com.androiddesignpattern.play.ui.activity.PlayWelcomeActivity;
import huangshun.it.com.androiddesignpattern.retrofit.RetrofitActivity;
import huangshun.it.com.androiddesignpattern.rxjava.demo2.RxJavaActivity;
import huangshun.it.com.androiddesignpattern.rxjava.demo3.RxSearchActivity;
import huangshun.it.com.androiddesignpattern.rxjava.demo4.RxPicActivity;
import huangshun.it.com.androiddesignpattern.test.IPC.aidl.AidlAccountActivity;
import huangshun.it.com.androiddesignpattern.test.IPC.messenger.MessengerActivity;
import huangshun.it.com.androiddesignpattern.test.phonetype.PhoneTypeActivity;
import huangshun.it.com.androiddesignpattern.unit13_7.MemotoActivity;
import huangshun.it.com.androiddesignpattern.unit8_7.ZhuangTaiActivity;
import huangshun.it.com.androiddesignpattern.view.SuspendViewActivity;
import huangshun.it.com.androiddesignpattern.view.myexpandable.MyPinnedActivity;
import huangshun.it.com.mysdk.MySDKActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.btn_messenger)
    Button mMessenger;
    @BindView(R.id.btn_aidl)
    Button mAidl;
    @BindView(R.id.btn_zhuangtai)
    Button mZhuangtai;
    @BindView(R.id.btn_sdk_test)
    Button mSdkTest;
    @BindView(R.id.btn_dagger2)
    Button mDagger;
    @BindView(R.id.btn_memoto)
    Button mMemoto;
    @BindView(R.id.btn_dagger_component)
    Button mDaggerComponent;
    @BindView(R.id.btn_rx)
    Button mBtnRx;
    @BindView(R.id.btn_rx_search)
    Button mBtnRxSearch;
    @BindView(R.id.btn_rx_pic)
    Button mBtnRxPic;
    @BindView(R.id.btn_okhttp)
    Button mBtnOkHttp;
    @BindView(R.id.btn_retrofit)
    Button mBtnRetrofit;
    @BindView(R.id.btn_phone_type)
    Button mBtnPhoneType;
    @BindView(R.id.btn_play)
    Button mBtnPlay;
    @BindView(R.id.btn_ble)
    Button mBtnBle;
    @BindView(R.id.btn_google_map)
    Button mBtnGoogleMap;
    @BindView(R.id.btn_green_dao)
    Button mBtnGreenDao;
    @BindView(R.id.btn_google)
    Button mBtnGoogle;
    @BindView(R.id.btn_file)
    Button mBtnFile;
    @BindView(R.id.btn_brainwave)
    Button mBtnBrainWave;
    @BindView(R.id.btn_pace)
    Button mBtnPace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mMessenger.setOnClickListener(this);
//        mAidl.setOnClickListener(this);
//        mZhuangtai.setOnClickListener(this);
//        mSdkTest.setOnClickListener(this);
//        mDagger.setOnClickListener(this);
//        mMemoto.setOnClickListener(this);
//        mDaggerComponent.setOnClickListener(this);
//        mBtnRx.setOnClickListener(this);
//        mBtnRxSearch.setOnClickListener(this);
//        mBtnRxPic.setOnClickListener(this);
//        mBtnOkHttp.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ViewStub vs = (ViewStub) findViewById(R.id.vs);
        View inflate = vs.inflate();
        int inflatedId = vs.getInflatedId();
        int id = inflate.getId();
        Log.i(TAG, "inflatedId:" + inflatedId + "====" + "id:" + id);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent() called with " + "intent = [" + intent + "]");
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause() called with " + "");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop() called with " + "");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called with " + "");
        super.onResume();
        CalendarTest();
    }

    private void CalendarTest() {
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long start = calendar.getTimeInMillis() / 1000;

//        Log.d(TAG, "prepareBongBlock start " + calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 3);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        long end = calendar.getTimeInMillis() / 1000;

//        Log.d(TAG, "prepareBongBlock end " + calendar.getTime());

    }

    @Override
    protected void onStart() {
        super.onStart();
        mMessenger.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mMessenger.getMeasuredHeight();
                mMessenger.getMeasuredWidth();
                mMessenger.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @OnClick({R.id.btn_rx, R.id.btn_messenger, R.id.btn_aidl, R.id.btn_zhuangtai, R.id.btn_sdk_test
            , R.id.btn_dagger2, R.id.btn_memoto, R.id.btn_dagger_component, R.id.btn_rx_pic, R.id.btn_rx_search
            , R.id.btn_okhttp, R.id.btn_retrofit, R.id.btn_phone_type, R.id.btn_play, R.id.btn_ble, R.id.btn_google_map
            , R.id.btn_green_dao, R.id.btn_file, R.id.btn_brainwave, R.id.btn_pace,
            R.id.btn_gson, R.id.btn_suspend, R.id.btn_event, R.id.btn_pull
            , R.id.btn_material, R.id.btn_timeLine})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_timeLine:
//                startActivity(new Intent(MainActivity.this, TimeLineActivity.class));
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;
            case R.id.btn_material:
                startActivity(new Intent(MainActivity.this, MaterialActivity.class));
                break;
            case R.id.btn_pull:
                startActivity(new Intent(MainActivity.this, MyPinnedActivity.class));
                break;
            case R.id.btn_suspend:
                startActivity(new Intent(MainActivity.this, SuspendViewActivity.class));
                break;
            case R.id.btn_gson:
                startActivity(new Intent(MainActivity.this, GsonActivity.class));
                break;
            case R.id.btn_messenger://信使
                startActivity(new Intent(MainActivity.this, MessengerActivity.class));
                break;
            case R.id.btn_aidl://aidl
                startActivity(new Intent(MainActivity.this, AidlAccountActivity.class));
                break;
            case R.id.btn_zhuangtai:
                startActivity(new Intent(MainActivity.this, ZhuangTaiActivity.class));
                break;
            case R.id.btn_sdk_test:
                startActivity(new Intent(MainActivity.this, MySDKActivity.class));
                break;
            case R.id.btn_dagger2:
//                startActivity(new Intent(MainActivity.this, Dagger2Activity.class));
                break;
            case R.id.btn_memoto:
                startActivity(new Intent(MainActivity.this, MemotoActivity.class));
                break;
            case R.id.btn_dagger_component:
//                startActivity(new Intent(MainActivity.this, DaggerComponentActivity.class));
                break;
            case R.id.btn_rx:
                startActivity(new Intent(MainActivity.this, RxJavaActivity.class));
                break;
            case R.id.btn_rx_search:
                startActivity(new Intent(MainActivity.this, RxSearchActivity.class));
                break;
            case R.id.btn_rx_pic:
                startActivity(new Intent(MainActivity.this, RxPicActivity.class));
                break;
            case R.id.btn_okhttp:
                startActivity(new Intent(MainActivity.this, OkHttpActivity.class));
                break;
            case R.id.btn_retrofit:
                startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
                break;
            case R.id.btn_phone_type://手机类型
                startActivity(new Intent(MainActivity.this, PhoneTypeActivity.class));
                break;
            case R.id.btn_play://手机助手
                startActivity(new Intent(MainActivity.this, PlayWelcomeActivity.class));
                break;
            case R.id.btn_ble://蓝牙
                startActivity(new Intent(MainActivity.this, BleActivity.class));
                break;
            case R.id.btn_google_map://谷歌地图
                startActivity(new Intent(MainActivity.this, MainMapActivity.class));
                break;
            case R.id.btn_green_dao://green dao3
                startActivity(new Intent(MainActivity.this, GreenDao3Activity.class));
                break;
            case R.id.btn_file://文件下载,扫描
                startActivity(new Intent(MainActivity.this, FileActivity.class));
                break;
            case R.id.btn_brainwave://脑波图
                startActivity(new Intent(MainActivity.this, BrainWaveActivity.class));
                break;
            case R.id.btn_pace://配速图
                startActivity(new Intent(MainActivity.this, PaceActivity.class));
                break;

            case R.id.btn_event://配速图
                startActivity(new Intent(MainActivity.this, EventActivity.class));
                break;

        }
    }

    class HandlerCallback implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    }

    Handler mHandler = new Handler(new HandlerCallback());
    private ExecutorService mFixed = Executors.newFixedThreadPool(4);
    private ExecutorService mCached = Executors.newCachedThreadPool();
    private ExecutorService mSchedule = Executors.newScheduledThreadPool(3);
    private ExecutorService mSingle = Executors.newSingleThreadExecutor();


}
