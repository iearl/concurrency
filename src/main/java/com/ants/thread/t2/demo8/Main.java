package com.ants.thread.t2.demo8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(MyConfig.class);
        DemoService bean = ac.getBean(DemoService.class);
        bean.a();
        bean.b();
    }
}
