package huangshun.it.com.androiddesignpattern.test.ipc.messenger;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import huangshun.it.com.androiddesignpattern.R;

/**
 * 客户端和服务端通信
 * 需要实现:1.客户端向服务端通信
 * 2.服务端向客户端通信
 */

public class MessengerActivity extends AppCompatActivity {
    private static final String TAG = "MessengerActivity";
    private Messenger mMessenger;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MyConstants.MSG_FROM_SERVICE:
                    Bundle data = msg.getData();
                    String content = data.getString("msg");
                    Log.i(TAG, "服务器发给客户端的数据:" + content);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        Intent intent = new Intent(this, MessengerService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMessenger = new Messenger(service);
            Message message = new Message();
            message.what = MyConstants.MSG_FROM_CLIENT;
            Bundle bundle = new Bundle();
            bundle.putString("msg", "发送给服务端");
            message.replyTo = new Messenger(mHandler);
            message.setData(bundle);
            try {
                mMessenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        unbindService(mServiceConnection);
        super.onDestroy();
    }
}
