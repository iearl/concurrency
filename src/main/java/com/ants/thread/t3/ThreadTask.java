package com.ants.thread.t3;

public class ThreadTask implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
