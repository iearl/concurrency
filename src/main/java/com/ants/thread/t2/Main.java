package com.ants.thread.t2;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadState());
        t.start();
    }
}
