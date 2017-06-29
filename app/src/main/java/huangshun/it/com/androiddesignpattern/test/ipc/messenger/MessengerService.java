package huangshun.it.com.androiddesignpattern.test.ipc.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 远程服务器
 */
public class MessengerService extends Service {
    private static final String TAG = "MessengerService";
    private Messenger mMessenger = new Messenger(mHandler);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MyConstants.MSG_FROM_CLIENT://接收从客户端发送的数据
                    Bundle data = msg.getData();
                    String content = data.getString("msg");
                    Log.i(TAG, "接收到客户端发送的数据:" + content);
                    Messenger client = msg.replyTo;
                    Message message = new Message();
                    message.what = MyConstants.MSG_FROM_SERVICE;
                    Bundle bundle = new Bundle();
                    bundle.putString("msg","服务器发给客户端的数据");
                    message.setData(bundle);
                    try {
                        client.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
}
