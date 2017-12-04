package huangshun.it.com.androiddesignpattern.test.baodian.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by hs on 2017/12/4.
 */

public class NewFeature8 {
    public static void main(String[] args) {
//        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
        String name = "come on!";
//        Arrays.asList("a", "b", "c").forEach(e -> {
//            System.out.println(e);
//            System.out.println("哈哈哈" + name);
//        });
        Arrays.asList("a", "c", "d")
                .sort((e1, e2) -> e1.compareTo(e2)
                );
//        FunctionInterface fun = new FunctionImpl();
//        fun.getName();
//        fun.method();
        Defaultable defaultable = DefaultableFactory.cretea(DefaultableImpl::new);
        Defaultable cretea = DefaultableFactory.cretea(OverridableImpl::new);

//        System.out.println(defaultable.notRequired());
//        System.out.println(cretea.notRequired());
        carTest();
    }

    /**
     * 方法引用
     */
    static class Car {
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided :" + car.toString());
        }

        public void follow(final Car anotherCar) {
            System.out.println("Following the " + anotherCar.toString());
        }

        public void repair() {
            System.out.println("Repaired:" + this.toString());
        }
    }

    public static void carTest() {
        //构造器引用
        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);
        //2.静态方法引用，接收car参数
        cars.forEach(Car::collide);
        //3.引用某个类的成员方法的引用
        cars.forEach(Car::repair);
        //4.引用实例对象的成员方法的引用
        cars.forEach(car::follow);
    }
}
