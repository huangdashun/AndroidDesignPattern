package huangshun.it.com.androiddesignpattern.dagger2.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import huangshun.it.com.androiddesignpattern.R;

public class Dagger2Activity extends AppCompatActivity {

//    @Inject
//    ApiService mApiService;


    @Inject
    UserManger mUserManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        findViewById(R.id.btn_dif_ins_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dagger2Activity.this, DaggerDifInsActivity.class));
            }
        });
//        DaggerUserComponent.builder().userModule(new UserModule(this)
//        ).okhttpModule(new OkhttpModule()).build().inject(this);
//        mUserManger.register();
//        DaggerUserComponent.builder().userModule(new UserModule()).build();等同于上面
    }
}
