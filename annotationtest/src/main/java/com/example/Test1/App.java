package com.example.Test1;

import java.lang.reflect.Method;

/**
 * Created by hs on 2017/8/1.
 */

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.example.Test1.AppMethod");
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo annotation = method.getAnnotation(MethodInfo.class);
                System.out.println(method.getName());
                System.out.println(annotation.author());
                System.out.println(annotation.date());
                System.out.println(annotation.version());
            }
        }
    }
}
