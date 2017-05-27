package huangshun.it.com.androiddesignpattern.unit1_6;

/**
 * Created by hs on 2017/5/27.
 * 房间
 */

public class Room {
    public float area;
    public float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "area=" + area +
                ", price=" + price +
                '}';
    }
}
