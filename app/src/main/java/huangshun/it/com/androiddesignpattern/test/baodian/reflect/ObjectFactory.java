package huangshun.it.com.androiddesignpattern.test.baodian.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hs on 2017/11/23.
 */

public class ObjectFactory {
    private int objectName;
    Map<Integer, String> mMap;
    private ArrayList<String> mArrayList;

    public static void main(String[] args) {
        //通过反射获取当前类
        Class<ObjectFactory> objectFactoryClass = ObjectFactory.class;

        Field mMap = null;
        try {
            mMap = objectFactoryClass.getDeclaredField("mMap");
            Type genericType = mMap.getGenericType();
            if (genericType instanceof ParameterizedType) {
                ParameterizedType mMapParameterizedType = (ParameterizedType) genericType;
                System.out.println(mMapParameterizedType.getRawType());
                System.out.println(mMapParameterizedType.getOwnerType());
                for (int i = 0; i < mMapParameterizedType.getActualTypeArguments().length; i++) {
                    System.out.println(mMapParameterizedType.getActualTypeArguments()[i]);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

//            Field objectName = objectFactoryClass.getDeclaredField("objectName");
//            Class<?> type = objectName.getType();
//            System.out.println(type);
//            Field mArrayList = objectFactoryClass.getDeclaredField("mArrayList");
//            Class<?> type1 = mArrayList.getType();
//            System.out.println(type1);
//            Type mArrayType = mArrayList.getGenericType();
//            if (mArrayType instanceof ParameterizedType) {
//                ParameterizedType arryaParameterizedType = (ParameterizedType) mArrayType;
//                System.out.println(arryaParameterizedType.getRawType());
//                System.out.println(arryaParameterizedType.getOwnerType());
//                Type[] actualTypeArguments = arryaParameterizedType.getActualTypeArguments();
//                for (int i = 0; i < actualTypeArguments.length; i++) {
//                    System.out.println(actualTypeArguments[i].toString());
//                }
//            }


    }

    public static <T> T getInstance(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
