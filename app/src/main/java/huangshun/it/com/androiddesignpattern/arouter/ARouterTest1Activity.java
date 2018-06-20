package huangshun.it.com.androiddesignpattern.arouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

import huangshun.it.com.androiddesignpattern.R;


@Route(path = RouterHub.APP_TEST1)
public class ARouterTest1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter_test1);
    }

}
