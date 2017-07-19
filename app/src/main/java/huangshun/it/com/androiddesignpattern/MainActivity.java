package huangshun.it.com.androiddesignpattern;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import huangshun.it.com.androiddesignpattern.dagger2.demo.Dagger2Activity;
import huangshun.it.com.androiddesignpattern.test.IPC.aidl.BookManagerActivity;
import huangshun.it.com.androiddesignpattern.test.IPC.messenger.MessengerActivity;
import huangshun.it.com.androiddesignpattern.unit8_7.ZhuangTaiActivity;
import huangshun.it.com.mysdk.MySDKActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button mMessenger;
    private Button mAidl;
    private Button mZhuangtai;
    private Button mSdkTest;
    private Button mDagger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessenger = (Button) findViewById(R.id.btn_messenger);
        mMessenger.setOnClickListener(this);
        mAidl = (Button) findViewById(R.id.btn_aidl);
        mAidl.setOnClickListener(this);
        mZhuangtai = (Button) findViewById(R.id.btn_zhuangtai);
        mZhuangtai.setOnClickListener(this);
        mSdkTest = (Button) findViewById(R.id.btn_sdk_test);
        mSdkTest.setOnClickListener(this);
        mDagger = (Button) findViewById(R.id.btn_dagger2);
        mDagger.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
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

        Log.d(TAG, "prepareBongBlock start " + calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 3);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        long end = calendar.getTimeInMillis() / 1000;

        Log.d(TAG, "prepareBongBlock end " + calendar.getTime());

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_messenger://信使
                startActivity(new Intent(MainActivity.this, MessengerActivity.class));
                break;
            case R.id.btn_aidl://aidl
                startActivity(new Intent(MainActivity.this, BookManagerActivity.class));
                break;
            case R.id.btn_zhuangtai:
                startActivity(new Intent(MainActivity.this, ZhuangTaiActivity.class));
                break;
            case R.id.btn_sdk_test:
                startActivity(new Intent(MainActivity.this, MySDKActivity.class));
                break;
            case R.id.btn_dagger2:
                startActivity(new Intent(MainActivity.this, Dagger2Activity.class));
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
