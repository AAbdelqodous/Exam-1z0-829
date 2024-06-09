package com.abdelqodous.concurrency.threadsafety.cyclic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args){

        ExecutorService service = Executors.newFixedThreadPool(4);

        try {
            var manager = new LionPenManager();
            var c1 = new CyclicBarrier(2); // it will activate twice
            var c2 = new CyclicBarrier(4, () -> System.out.println("--------Pen cleaned ---------"));
            for (int i = 0; i < 4; i++) {
                service.submit( () -> manager.performTask(c1, c2));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }
}
