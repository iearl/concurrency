package com.ants.concurrency.example.statexample;

import com.ants.concurrency.annotations.NotRecomment;
import com.ants.concurrency.annotations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
@NotRecomment
public class MapExample {

    private static Map<Integer, String> map = Maps.newHashMap();
    private static int threadTotal = 1;
    private static int clientTotal = 5000;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for(int i=0;i<clientTotal;i++){
            final int threadNum = i;

            exec.execute(()->{
                try {
                    semaphore.acquire();
                    put(threadNum);
                    semaphore.release();
                }catch (Exception e){
                    log.info("error");
                }
            });
        }
        exec.shutdown();
        log.info("size={}",map.size());
    }
    public static void put(int threadNum){
        map.put(threadNum,"");
    }
}
