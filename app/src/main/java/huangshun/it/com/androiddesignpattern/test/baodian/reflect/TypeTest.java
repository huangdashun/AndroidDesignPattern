package huangshun.it.com.androiddesignpattern.test.baodian.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by hs on 2017/11/24.
 */

public class TypeTest<V extends People & Animal> {
    //V的上边界是People和Animal,如果V没有指定的话,上边界是Object
    V value;
    //不属于TypeVariable
    V[] values;
    String str;

    public static void main(String[] args) {
        Class<TypeTest> typeTestClass = TypeTest.class;
        try {
            Field value = typeTestClass.getDeclaredField("value");
            Type genericType = value.getGenericType();
            if (genericType instanceof TypeVariable) {
                Type[] bounds = ((TypeVariable) genericType).getBounds();
                for (int i = 0; i < bounds.length; i++) {
                    System.out.println(bounds[i]);
                }
                System.out.println(((TypeVariable) genericType).getName());
                System.out.println(((TypeVariable) genericType).getGenericDeclaration());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}