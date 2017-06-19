package cn.itcast.annotation;

import java.lang.annotation.*;

/**
 * Created by gaoyu on 2017/6/7.
 * Wish you a good day~
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    int id() default -1;

    String name() default "";

    String address() default "";
}
