package huangshun.it.com.androiddesignpattern.unit1_6;

import java.util.ArrayList;
import java.util.List;

import static huangshun.it.com.androiddesignpattern.unit1_6.Tenant.diffArea;
import static huangshun.it.com.androiddesignpattern.unit1_6.Tenant.diffPrice;

/**
 * Created by hs on 2017/5/27.
 * 中介
 */

public class Mediator {
    List<Room> mRoomList = new ArrayList<>();

    public Mediator() {
        for (int i = 0; i < 5; i++) {
            mRoomList.add(new Room(14 + i, (14 + i) * 150));
        }
    }


    public Room rentOut(float area, float price) {
        for (Room room : mRoomList) {
            if (isSuitable(area, price, room)) {
                return room;
            }
        }
        return null;
    }

    private boolean isSuitable(float area, float price, Room room) {
        return Math.abs(room.price - price) < diffPrice && Math.abs(room.area - area) < diffArea;
    }
}
