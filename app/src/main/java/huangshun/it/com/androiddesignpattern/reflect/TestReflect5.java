package huangshun.it.com.androiddesignpattern.reflect;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by hs on 2017/7/21.
 * 获取某个类的全部方法
 */

public class TestReflect5 implements Serializable {
    private static final long serialVersionUID = -2862585049955236662L;

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("huangshun.it.com.androiddesignpattern.reflect.TestReflect5");
        //
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Class<?> returnType = methods[i].getReturnType();
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            int modifiers = methods[i].getModifiers();
            String modifiersStr = Modifier.toString(modifiers);
            System.out.print(modifiersStr + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(methods[i].getName() + " ");
            System.out.print("(");
            //参数信息
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.print(parameterTypes[j].getName() + " " + "arg " + j);
                if (j < parameterTypes.length - 1) {
                    System.out.print(",");
                }
            }
            //输出方法异常信息
            Class<?>[] exceptionTypes = methods[i].getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print(") throw ");
                for (int j = 0; j < exceptionTypes.length; j++) {
                    System.out.print(exceptionTypes[j].getName() + "");
                    if (j < exceptionTypes.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
