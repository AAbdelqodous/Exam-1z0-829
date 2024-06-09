package com.abdelqodous.concurrency.threadsafety.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReententLockDemo {
    private static final int MAX_THREADS = 2;
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        ExecutorService service = Executors.newFixedThreadPool(MAX_THREADS);

        Runnable job1 = new Worker("Job1", reentrantLock);
        Runnable job2 = new Worker("Job2", reentrantLock);
        Runnable job3 = new Worker("Job3", reentrantLock);
        Runnable job4 = new Worker("Job4", reentrantLock);

        try {
            service.submit(job1);
            service.submit(job2);
            service.submit(job3);
            service.submit(job4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }
}
