package com.vivachek.cloud.profiledemo.annotation;

import java.lang.annotation.*;

/**
 * @Description 幂等操作的注解
 * @Author CJB
 * @Date 2020/3/25 10:19
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatLimiter {
}