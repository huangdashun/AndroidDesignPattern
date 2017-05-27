package huangshun.it.com.androiddesignpattern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_messenger://信使
                startActivity(new Intent(MainActivity.this, MessengerActivity.class));
                break;
            case R.id.btn_aidl://aidl
                startActivity(new Intent(MainActivity.this, BookManagerActivity.class));
        }
    }
}
