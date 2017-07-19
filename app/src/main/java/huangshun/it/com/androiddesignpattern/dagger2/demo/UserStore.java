package huangshun.it.com.androiddesignpattern.dagger2.demo;

import android.content.Context;
import android.util.Log;

/**
 * Created by hs on 2017/7/19.
 */

public class UserStore {
    private static final String TAG = "UserStore";
    private Context mContext;

    public UserStore(Context context) {
        mContext = context;
    }

    public void register() {
        //本地保存数据
        Log.d(TAG, "register() called with " + "UserStore");
    }
}
