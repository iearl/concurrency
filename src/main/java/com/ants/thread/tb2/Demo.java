package com.ants.thread.tb2;

public class Demo {
    public void a(Thread joinThread) {
        System.out.println("方法A执行了");
        joinThread.start();
        try {
            joinThread.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("方法A执行完毕");
    }
    public void b() {
        System.out.println("方法B执行了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法B执行完毕");
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                d.b();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.a(t1);
            }
        }).start();
    }

}
