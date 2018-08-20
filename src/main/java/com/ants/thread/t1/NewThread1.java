package com.ants.thread.t1;

public class NewThread1 implements Runnable {
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
        synchronized (thread) {
            while (true) {
                System.out.println("主线程执行了");
                thread.notifyAll();
            }

        }
    }
}
