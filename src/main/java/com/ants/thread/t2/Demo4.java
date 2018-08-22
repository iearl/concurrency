package com.ants.thread.t2;

/**
 * 匿名内部类
 */
public class Demo4 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("11111111");
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("22222222222222");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("3333333333333");
            }
        }){
            @Override
            public void run() {
                System.out.println("44444444444444444");
            }
        }.start();
    }
}
