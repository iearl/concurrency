package com.ants.thread.t2;

/**
 * 通过集成Thread类完成线程创建
 */
public class Demo1 extends Thread{
    public  Demo1(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.getName());
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("A");

        Demo1 demo2 = new Demo1("B");
        demo2.start();
        demo1.setDaemon(true);//是否是守护线程，此方法的设定需要在开启线程后
        demo1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
