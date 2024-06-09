package com.abdelqodous.concurrency.threadsafety.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LionPenManager {
    private void removeLion(){
        System.out.println(Thread.currentThread().getName()+ " Removing lion..");
    }

    private void cleanPen(){
        System.out.println(Thread.currentThread().getName()+ " Cleaning pen..");
    }

    private void addLion(){
        System.out.println(Thread.currentThread().getName()+ " Adding lion..");
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2){

        try {
            removeLion();
            c1.await();
            cleanPen();
            c2.await();
            addLion();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
