package com.example.Test1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hs on 2017/8/1.
 */

@Documented //是否会保存到Javadoc文档中
@Retention(RetentionPolicy.RUNTIME)//SOURCE源码时 CLASS编译时 RUNTIME运行时
@Target(ElementType.METHOD)//TYPE,METHOD,CONSTRUCTOR,FIELD,PARAMETER
@Inherited //是否可以被继承,默认为false
public @interface MethodInfo {
    String author() default "huangshun@bong.com";

    String date();

    int version() default 1;
}
