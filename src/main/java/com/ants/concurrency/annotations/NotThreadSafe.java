package com.ants.concurrency.annotations;

/**
 * 用来标记线程【不安全】的类或写法
 */
public  @interface NotThreadSafe {
    String value() default "";
}
