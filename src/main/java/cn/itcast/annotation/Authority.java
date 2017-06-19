package cn.itcast.annotation;

import cn.itcast.authEnum.AuthorityType;

import java.lang.annotation.*;

/**
 * Created by gaoyu on 2017/6/7.
 * Wish you a good day~
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authority {
    AuthorityType value() default AuthorityType.Validate;
}
