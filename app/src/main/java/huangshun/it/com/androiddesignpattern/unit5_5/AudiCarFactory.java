package huangshun.it.com.androiddesignpattern.unit5_5;

/**
 * Created by hs on 2017/6/9.
 */

public class AudiCarFactory extends AudiFactory {
    @Override
    public <T extends AudiCar> T createCar(Class<T> cls) {
        AudiCar car = null;
        try {
            car = (AudiCar) Class.forName(cls.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) car;
    }
}
