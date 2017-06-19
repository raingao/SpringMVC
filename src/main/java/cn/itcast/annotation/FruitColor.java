package cn.itcast.annotation;

import cn.itcast.authEnum.Color;

import java.lang.annotation.*;

/**
 * Created by gaoyu on 2017/6/7.
 * Wish you a good day~
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    Color fruitColor() default Color.RED;
}
