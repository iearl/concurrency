package com.ants.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记推荐的类或写法
 */
@Target(ElementType.TYPE )
@Retention(RetentionPolicy.SOURCE)
public  @interface Recomment {
    String value() default "";
}
