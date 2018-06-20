package huangshun.it.com.androiddesignpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;
import huangshun.it.com.androiddesignpattern.arouter.RouterHub;
import huangshun.it.com.androiddesignpattern.arouter.model.ARouterTest;
import huangshun.it.com.androiddesignpattern.arouter.model.ARouterTest2;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Button btnSimpleJump = findViewById(R.id.btn_simple_jump);
//        btnSimpleJump.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ARouter.getInstance().build(RouterHub.APP_TEST1)
//                        .navigation();
//            }
//        });
    }

    @OnClick({R.id.btn_simple_jump, R.id.btn_param_jump})
    public void onClick(View view) {
        Log.d(TAG, "onClick() called with " + "view = [" + view + "]");
        switch (view.getId()) {
            case R.id.btn_simple_jump:
                ARouter.getInstance().build(RouterHub.APP_TEST1)
                        .navigation();
                break;
            case R.id.btn_param_jump:
                ARouterTest aRouterTest = new ARouterTest("黄顺", "code");
//                ARouterTest2 aRouterTest2 = new ARouterTest2("黄顺222", "code22");
                ARouterTest2 aRouterTest2 = new ARouterTest2();
                aRouterTest2.setLike("123");
                aRouterTest2.setName("123");
                ARouter.getInstance().build(RouterHub.APP_TEST2)
                        .withLong("key1", 666L)
                        .withString("key2", "大家好")
                        .withSerializable("key3", aRouterTest)
                        .withObject("obj", aRouterTest2)
                        .navigation();
                break;
            default:
                break;
        }
    }
}
