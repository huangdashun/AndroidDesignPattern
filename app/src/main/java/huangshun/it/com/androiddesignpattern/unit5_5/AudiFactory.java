package huangshun.it.com.androiddesignpattern.unit5_5;

/**
 * Created by hs on 2017/6/9.
 * 奥迪车型的工厂方法
 */

public abstract class AudiFactory {
   public abstract <T extends AudiCar> T createCar(Class<T> cls);
}
