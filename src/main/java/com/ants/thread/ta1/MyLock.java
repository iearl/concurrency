package com.ants.thread.ta1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    private boolean isLocked = false;
    private Thread thread = null;
    private int count = 0;

    @Override
    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        while(isLocked &&currentThread!=thread){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread =  currentThread;
        count++;
        isLocked = true;
    }

    @Override
    public synchronized void unlock() {
        Thread currentThread = Thread.currentThread();
        if(currentThread==thread){
            count--;
            if(count == 0){
                isLocked = false;
                this.notify();
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
