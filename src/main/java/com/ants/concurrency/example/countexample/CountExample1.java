package com.ants.concurrency.example.countexample;

import com.ants.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ThreadSafe
public class CountExample1 {
    private static int threadTotal = 200;
    private static int clientTotal = 5000;
    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws Exception {
        final CountDownLatch cuntDownLatch = new CountDownLatch(clientTotal);
        ExecutorService exec1 = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++) {
            exec1.execute(() -> {
                try {
                    semaphore.acquire();
                    add1();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cuntDownLatch.countDown();
            });
        }
        cuntDownLatch.await();
        exec1.shutdown();
        log.info("count={}", count.get());
    }

    public static  void add1() {
        count.incrementAndGet();
    }
}
