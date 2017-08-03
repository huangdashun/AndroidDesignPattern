package huangshun.it.com.androiddesignpattern.ble;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import huangshun.it.com.androiddesignpattern.R;

public class BleActivity extends AppCompatActivity {
    private static final String TAG = "BleActivity";
    private static final int REQUEST_OPEN_BT_CODE = 1;
    @BindView(R.id.btn_enable)
    Button mBtnEnable;
    @BindView(R.id.btn_disenable)
    Button mBtnDisenable;
    @BindView(R.id.btn_request_enable)
    Button mBtnRequestEnable;
    private BluetoothAdapter mBluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble);
        ButterKnife.bind(this);
        init();
        registerBroadcast();
    }

    private void registerBroadcast() {
        IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(mStatusReceive, intentFilter);
    }

    private BroadcastReceiver mStatusReceive = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case BluetoothAdapter.ACTION_STATE_CHANGED:
                    int blueState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0);
                    switch (blueState) {
                        case BluetoothAdapter.STATE_TURNING_ON:
                            Log.d(TAG, "STATE_TURNING_ON 手机蓝牙正在开启");
                            break;
                        case BluetoothAdapter.STATE_ON:
                            Log.d(TAG, "STATE_ON 手机蓝牙开启");
                            Toast.makeText(getApplicationContext(), "STATE_ON", Toast.LENGTH_SHORT).show();
                            break;
                        case BluetoothAdapter.STATE_TURNING_OFF:
                            Log.d(TAG, "STATE_TURNING_OFF 手机蓝牙正在关闭");
                            break;
                        case BluetoothAdapter.STATE_OFF:
                            Log.d(TAG, "STATE_OFF 手机蓝牙关闭");
                            Toast.makeText(getApplicationContext(), "STATE_OFF", Toast.LENGTH_SHORT).show();
                            break;
                    }
            }
        }
    };

    private void init() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(BleActivity.this, "设备不支持蓝牙", Toast.LENGTH_SHORT).show();
        } else {
            //进行下一步操作
        }
    }

    @OnClick({R.id.btn_enable, R.id.btn_disenable, R.id.btn_request_enable})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_enable:
                enableBle();
                break;
            case R.id.btn_disenable:
                disenable();
                break;
            case R.id.btn_request_enable:
                requestEnable();
                break;
        }
    }

    private void enableBle() {
        if (!mBluetoothAdapter.isEnabled()) {
            //强制开启蓝牙
            mBluetoothAdapter.enable();
        }

    }

    private void disenable() {
        if (mBluetoothAdapter.isEnabled()) {
            //强制开启蓝牙
            mBluetoothAdapter.disable();
        }
    }

    private void requestEnable() {
        if (!mBluetoothAdapter.isEnabled()) {
            //请求开启蓝牙
            Intent openBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            //REQUEST_OPEN_BT_CODE = 1
            startActivityForResult(openBT, REQUEST_OPEN_BT_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_OPEN_BT_CODE) {
            Toast.makeText(getApplicationContext(), "蓝牙打开成功", Toast.LENGTH_SHORT).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mStatusReceive);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mStatusReceive);
    }
}
