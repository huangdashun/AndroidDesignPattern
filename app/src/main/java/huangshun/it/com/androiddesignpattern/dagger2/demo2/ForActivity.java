package huangshun.it.com.androiddesignpattern.dagger2.demo2;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hs on 2017/7/20.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ForActivity {
}
