package huangshun.it.com.androiddesignpattern.unit1_6;

import android.util.Log;

/**
 * Created by hs on 2017/5/27.
 */

public class Tenant {
    private static final String TAG = "Tenant";
    public float roomArea;
    public float roomPrice;
    public static final float diffPrice = 100.0001f;
    public static final float diffArea = 0.00001f;

    public void rentRoom(Mediator mediator) {
        Room room = mediator.rentOut(roomArea, roomPrice);
        if (room != null) {
            Log.i(TAG, "租到房子了:" + room);
        } else {
            Log.i(TAG, "没有租到房子");
        }
    }


}
