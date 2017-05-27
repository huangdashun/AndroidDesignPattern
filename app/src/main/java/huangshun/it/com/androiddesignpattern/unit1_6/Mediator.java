package huangshun.it.com.androiddesignpattern.unit1_6;

import java.util.ArrayList;
import java.util.List;

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

    public List<Room> getRoomList() {
        return mRoomList;
    }
}
