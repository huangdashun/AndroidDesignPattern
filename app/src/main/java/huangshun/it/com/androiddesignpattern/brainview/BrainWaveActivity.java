package huangshun.it.com.androiddesignpattern.brainview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import huangshun.it.com.androiddesignpattern.R;

public class BrainWaveActivity extends AppCompatActivity {
    private static final String TAG = "BrainWaveActivity";
    private BrainWaveView mBrainWaveView;
    private Runnable mRunnable;
    private Handler mHandler = new Handler();
    private int num = 0;
    private List<Integer> mMList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_wave);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mBrainWaveView = (BrainWaveView) findViewById(R.id.chart);
        mMList = new ArrayList<>();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                if (num >= 25) {
                    num = 0;
                    mHandler.removeCallbacks(this);
                }
                mBrainWaveView.addPointToList(mMList.get(num));
                mHandler.postDelayed(this, 40);
                num++;
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++) {
                    mMList.add((int) (Math.random() * 100));
                }
                mHandler.postDelayed(mRunnable, 0);
                Log.i(TAG, "thread在执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        initListener();
    }

    private void initListener() {
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.removeCallbacks(mRunnable);
            }
        });
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable, 40);
            }
        });
        findViewById(R.id.btn_diaoxian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 0;
                mHandler.removeCallbacks(mRunnable);
                mRunnable = new Runnable() {
                    @Override
                    public void run() {
                        mBrainWaveView.addPointToList(10);
                        mHandler.postDelayed(mRunnable, 40);
                    }
                };
                mHandler.postDelayed(mRunnable, 0);
            }
        });
        findViewById(R.id.btn_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.removeCallbacks(mRunnable);
                mRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (num >= 25) {
                            num = 0;
                            mHandler.removeCallbacks(this);
                        }
                        mBrainWaveView.addPointToList(mMList.get(num));
                        mHandler.postDelayed(this, 40);
                        num++;
                    }
                };
                mHandler.postDelayed(mRunnable, 0);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mHandler.postDelayed(mRunnable, 0);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mHandler.removeCallbacks(mRunnable);
    }
}
