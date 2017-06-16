package huangshun.it.com.androiddesignpattern;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import huangshun.it.com.androiddesignpattern.test.IPC.aidl.BookManagerActivity;
import huangshun.it.com.androiddesignpattern.test.IPC.messenger.MessengerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mMessenger;
    Button mAidl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessenger = (Button) findViewById(R.id.btn_messenger);
        mMessenger.setOnClickListener(this);
        mAidl = (Button) findViewById(R.id.btn_aidl);
        mAidl.setOnClickListener(this);
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
