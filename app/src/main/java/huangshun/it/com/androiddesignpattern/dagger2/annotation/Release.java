package huangshun.it.com.androiddesignpattern.dagger2.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hs on 2017/7/19.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Release {

}
