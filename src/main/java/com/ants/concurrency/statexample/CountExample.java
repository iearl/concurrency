package com.ants.concurrency.statexample;

import com.ants.concurrency.annotations.NotRecomment;
import com.ants.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
@NotRecomment
public class CountExample {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;
    private static long count = 0;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.info(e.getMessage());
                }
            });
        }
        exec.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("count={}", count);
    }

    public static synchronized void add() {
        count=count+1;
    }
}
