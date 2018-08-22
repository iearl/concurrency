package com.ants.thread.t2;

/**
 * 通过继承Thread类完成线程创建
 */
public class Demo2 extends Thread {
    public Demo2(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(this.getName());
        }

    }

    public static void main(String[] args) {
        Demo2 demo1 = new Demo2("A");

        Demo2 demo2 = new Demo2("B");
        demo2.start();
        demo1.start();
        demo2.interrupt();

    }
}
