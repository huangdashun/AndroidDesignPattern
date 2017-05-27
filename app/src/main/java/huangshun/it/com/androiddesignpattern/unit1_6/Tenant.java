package huangshun.it.com.androiddesignpattern.unit1_6;

import android.util.Log;

import java.util.List;

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
        List<Room> roomList = mediator.getRoomList();
        for (Room room : roomList) {
            if (isSuitable(room)) {
                Log.i(TAG, "租到房子了!" + room);
            }
        }
    }

    private boolean isSuitable(Room room) {
        return Math.abs(room.price - roomPrice) < diffPrice && Math.abs(room.area - roomArea) < diffArea;
    }

}
