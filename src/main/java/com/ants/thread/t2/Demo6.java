package com.ants.thread.t2;

import javax.sound.midi.SoundbankResource;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用定时器创建线程,quarzt
 * 实现简单，任务不可控制
 */
public class Demo6 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("1231");
            }
        };
        timer.schedule(task,0,1000);
    }
}
