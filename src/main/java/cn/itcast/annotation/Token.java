package cn.itcast.annotation;

import java.lang.annotation.*;

/**
 * Created by gaoyu on 2017/6/8.
 * Wish you a good day~
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Token {
    boolean save() default false;
    boolean remove() default false;
}
