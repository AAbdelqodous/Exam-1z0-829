package com.abdelqodous.concurrency.threadsafety.lock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {
    private final String name;
    private final ReentrantLock reentrantLock;

    public Worker(String name, ReentrantLock reentrantLock){
        this.name = name;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        boolean done = false;
        while (!done) {
            boolean  isAquired = reentrantLock.tryLock(); // waite if another thread has the lock

            if (isAquired) {
                try {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("-> task name : " + name + " outer lock acquired at "
                                    + simpleDateFormat.format(date)  + " Doing outer work");
                    Thread.sleep(5000);

                    reentrantLock.lock(); // does not waite if another thread has the lock
                    try {
                        date = new Date();
                        simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                        System.out.println("-> task name : " + name + " inner lock acquired at "
                                + simpleDateFormat.format(date)  + " Doing inner work");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        System.out.println("-> task name : " + name + " releasing inner lock");
                        reentrantLock.unlock();
                    }

                    System.out.println("Lock Hold Count : " + reentrantLock.getHoldCount());
                    System.out.println("task name : " + name + " work done");
                    done = true;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    // Outer lock release
                    System.out.println("-> task name : " + name + " releasing outer lock");
//                        if(reentrantLock.tryLock(5_000, TimeUnit.MILLISECONDS))
                            reentrantLock.unlock();
                    System.out.println("Lock Hold Count : " + reentrantLock.getHoldCount());
                }
            }else {
                System.out.println("task name : " + name + " waiting for lock");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
