package com.ants.thread.t1;

public class NewThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("子线程执行了");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NewThread thread = new NewThread();
        Thread t = new Thread(thread);
        t.start();
        while (true) {
            System.out.println("主线程执行了");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
