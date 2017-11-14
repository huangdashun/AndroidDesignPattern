package huangshun.it.com.androiddesignpattern.reflect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by hs on 2017/7/21.
 */

public class Test4 {
    //    public int test = 123;
    public static void main(String[] args) throws ClassNotFoundException {
        final Handler handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable() {
            @Override
            public void run() {
                //我可以做耗时任务
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //我可以更新UI
                    }
                });
            }
        });
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                // data:我是从网络获取的
                String data = (String) msg.obj;
                //我可以更新UI

            }
        }
    };

    private void downloadAndUpdateUI() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //从网络获取User信息
                String data = "我是从网络获取的";
                //将获取的数据通过Message包装起来,使用Handler发送过去
                Message message = new Message();
                message.what = 1;//消息标志
                message.obj = data;
                mHandler.sendMessage(message);
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler handler = new Handler();
                Looper.loop();
            }
        });
    }
}
