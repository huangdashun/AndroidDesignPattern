package huangshun.it.com.androiddesignpattern.test.phonetype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import huangshun.it.com.androiddesignpattern.R;

public class PhoneTypeActivity extends AppCompatActivity {
    private static final String TAG = "PhoneTypeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_type);
        test();
    }

    private void test() {
        Log.i(TAG, "test " + PhoneUtils.getPhoneType().toString());
        Toast.makeText(getApplicationContext(), "type:" + PhoneUtils.getPhoneType().toString(), Toast.LENGTH_SHORT).show();
    }
}
