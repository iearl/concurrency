package com.ants.thread.ta1;

public class Sequence {
    private int value;
    private MyLock myLock = new MyLock();

    public int getNext(){
        myLock.lock();
        int result = value++;
        myLock.unlock();
        return result;
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(s.getNext());
                }
            }
        }).start();
    }
}
