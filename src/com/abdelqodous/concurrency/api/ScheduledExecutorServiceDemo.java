package com.abdelqodous.concurrency.api;

import java.util.concurrent.*;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> System.out.println("Hello zoo..");
        Callable<String> task2 = () -> "Monkey";
        Runnable task3 = () -> System.out.println("Scheduled at fixed rate...");
        Runnable task4 = () -> System.out.println("Scheduled at fixed delay...");

        try {
            ScheduledFuture<?> scheduledRunnable = service.schedule(task1, 10, TimeUnit.SECONDS);
            scheduledRunnable.get();

            ScheduledFuture<String> scheduledCallable = service.schedule(task2, 8, TimeUnit.SECONDS);
            System.out.println( scheduledCallable.get());

            ScheduledFuture<?> scheduleAtFixedRate = service.scheduleAtFixedRate(task3, 2, 1, TimeUnit.MINUTES);
            scheduleAtFixedRate.get();

            ScheduledFuture<?> scheduleWithFixedDelay = service.scheduleWithFixedDelay(task4, 1, 2, TimeUnit.MINUTES);
            scheduleWithFixedDelay.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }
}
