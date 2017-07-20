package huangshun.it.com.androiddesignpattern.dagger2.demo2;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by hs on 2017/7/20.
 * 目标类:应用级
 */

public class ApplicationBean {
    private String name = null;

    public ApplicationBean() {
        Log.d(TAG, "ApplicationBean() called with " + "");
        this.name = "AppBean";
    }

    public String getName() {
        return name;
    }
}
