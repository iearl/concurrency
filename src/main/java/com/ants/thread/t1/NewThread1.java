package com.ants.thread.t1;

public class NewThread1 implements Runnable {
    //线程任务
    //waut 和 notify方法需要在synchronized方法或者代码快中执行
    @Override
    public synchronized void run() {

        while (true) {
            System.out.println("子线程执行了");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        NewThread1 thread = new NewThread1();
        Thread t = new Thread(thread);
        t.start();
        while (true) {
            synchronized (thread) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("主线程执行了");
                thread.notifyAll();
            }

        }
    }
}
