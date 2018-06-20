package huangshun.it.com.androiddesignpattern.arouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.arouter.model.ARouterTest;
import huangshun.it.com.androiddesignpattern.arouter.model.ARouterTest2;

@Route(path = RouterHub.APP_TEST2)
public class ARouterTest2Activity extends AppCompatActivity {
    private static final String TAG = "ARouterTest2Activity";
    //    @Autowired
//    ARouterTest key3;
    @Autowired
    ARouterTest2 obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter_test2);
        ARouter.getInstance().inject(this);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        long key1 = bundle.getLong("key1", 0);
        String key2 = bundle.getString("key2");
        Log.i(TAG, "KEY1:" + key1 + "    " + "KEY2:" + key2);
        ARouterTest key3 = (ARouterTest) bundle.getSerializable("key3");
        Log.i(TAG, "KEY1:" + key1 + "    " + "KEY2:" + key2 + " " + key3.toString() + "   " + obj.toString());
    }
}
