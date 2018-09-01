package com.ants.thread.t2;
/**
 * 通过实现Runnable接口完成线程创建，面向接口编程，任务与线程分离，解耦
 */
public class Demo3 implements Runnable {
    //作为线程任务存在，线程所需要执行的功能
    @Override
    public void run() {
        System.out.println("线程任务");
    }

    public static void main(String[] args) {
        new Thread(new Demo3()).start();
    }
}
