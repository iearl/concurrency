package com.ants.concurrency.annotations;

/**
 * 用来标记推荐的类或写法
 */
public  @interface Recomment {
    String value() default "";
}
