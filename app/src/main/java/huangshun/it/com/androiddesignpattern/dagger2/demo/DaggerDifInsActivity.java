package huangshun.it.com.androiddesignpattern.dagger2.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.dagger2.annotation.Release;
import huangshun.it.com.androiddesignpattern.dagger2.annotation.Text;

public class DaggerDifInsActivity extends AppCompatActivity {
    @Release
    @Inject
    ApiService mReleaseService;

    @Text
    @Inject
    ApiService mDevService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_dif_ins);
        DaggerUserComponent.builder().okhttpModule(new OkhttpModule()).userModule(new UserModule(this)).build().inject(this);

        mReleaseService.register();
        mDevService.register();
    }
}
