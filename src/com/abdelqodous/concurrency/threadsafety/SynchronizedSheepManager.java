package com.abdelqodous.concurrency.threadsafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedSheepManager {
    private int sheepCount = 0;

    private void incrementAndReport(){
        System.out.println( ++sheepCount +" ");
    }

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
        SynchronizedSheepManager manager = new SynchronizedSheepManager();

        try {
            for (int i = 0; i < 100; i++) {
                synchronized (manager) {
                    fixedThreadPool.submit(manager::incrementAndReport);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fixedThreadPool.shutdown();
        }
    }
}
