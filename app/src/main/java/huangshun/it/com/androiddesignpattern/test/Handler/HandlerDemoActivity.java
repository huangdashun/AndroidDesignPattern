package huangshun.it.com.androiddesignpattern.test.Handler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

import huangshun.it.com.androiddesignpattern.R;

/**
 * 避免内存泄露的Handler
 */
public class HandlerDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_demo);
    }

    private MyHandler mHandler = new MyHandler(this);

    private static class MyHandler extends Handler {
        private WeakReference<Context> reference;

        public MyHandler(Context context) {
            reference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            HandlerDemoActivity activity = (HandlerDemoActivity) reference.get();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
