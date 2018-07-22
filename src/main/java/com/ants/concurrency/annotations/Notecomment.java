package com.ants.concurrency.annotations;

/**
 * 用来标记【不推荐】的类或写法
 */
public  @interface Notecomment {
    String value() default "";
}
