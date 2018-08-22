package com.ants.thread.t2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池创建线程，空间换时间
 */
public class Demo7 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<10000;i++) {
        exec.execute(new Runnable() {
            @Override
            public void run() {




                    System.out.println(Thread.currentThread().getName());
                }

        });

    } exec.shutdown();
    }
}
