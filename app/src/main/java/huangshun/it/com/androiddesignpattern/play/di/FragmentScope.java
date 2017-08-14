package huangshun.it.com.androiddesignpattern.play.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hs on 2017/8/14.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {
}
