package com.abdelqodous.concurrency.threadsafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
//    private int sheepCount = 0;
//    private volatile int sheepCount = 0;
    private final AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport(){
        System.out.println( sheepCount.incrementAndGet() +" ");
    }

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
        SheepManager manager = new SheepManager();

        try {
            for (int i = 0; i < 100; i++) {
                fixedThreadPool.submit(manager::incrementAndReport);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fixedThreadPool.shutdown();
        }
    }
}
