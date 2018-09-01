package com.ants.thread.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过实现Callable接口，实现线程创建
 */
public class Demo5 implements Callable<Integer> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo5 demo5 = new Demo5();
        FutureTask<Integer> task = new FutureTask<>(demo5);
        Thread t = new Thread(task);
        t.start();
        System.out.println("do something");
        //get方法会阻塞直到结果准备好
        Integer result = task.get();
        System.out.println(result);
    }



    @Override
    public Integer call() throws Exception {
        System.out.println("通过实现Callable接口，实现线程创建");
        Thread.sleep(1000);
        return 1;
    }
}
