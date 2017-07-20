package huangshun.it.com.androiddesignpattern.dagger2.demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import huangshun.it.com.androiddesignpattern.DaggerApplication;
import huangshun.it.com.androiddesignpattern.R;

public class DaggerComponentActivity extends AppCompatActivity {

    @Inject
    ApplicationBean applicationBean1;
    @Inject
    ApplicationBean applicationBean2;
    @Inject
    ActivityBean activityBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_component);


        DaggerApplication application = (DaggerApplication) getApplication();
        ApplicationComponent applicationComponent = application.getApplicationComponent();
        ActivityComponent activityComponent = DaggerActivityComponent.builder().applicationComponent((applicationComponent)).activiityModule(new ActiviityModule()).build();

        activityComponent.inject(this);
        Log.d("Dagger", "Activity activityBean:" + activityBean);
        Log.d("Dagger", "Activity applicationBean1:" + applicationBean1);
        Log.d("Dagger", "Activity applicationBean2:" + applicationBean2);
        OtherClass otherClass = new OtherClass();
    }

    class OtherClass {
        @Inject
        ApplicationBean applicationBean1;
        @Inject
        ApplicationBean applicationBean2;
        @Inject
        ActivityBean activityBean;


        public OtherClass() {
            DaggerApplication application = (DaggerApplication) getApplication();
            ApplicationComponent applicationComponent = application.getApplicationComponent();
            ActivityComponent activityComponent = DaggerActivityComponent.builder().applicationComponent(applicationComponent).build();
            activityComponent.inject(this);
            Log.d("Dagger", "OtherClass activityBean:" + this.activityBean);
            Log.d("Dagger", "OtherClass applicationBean1:" + this.applicationBean1);
            Log.d("Dagger", "OtherClass applicationBean2:" + this.applicationBean2);
        }
    }
}
