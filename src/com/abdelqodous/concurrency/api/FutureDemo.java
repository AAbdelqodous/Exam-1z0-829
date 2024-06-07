package com.abdelqodous.concurrency.api;

import java.util.concurrent.*;

public class FutureDemo {
    private static  int counter = 0;

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try{
            /* Future<?> future = service.submit(() -> {
                for (int i = 0; i < 1_000_000; i++)
                    counter++;
            });
            future.get(10, TimeUnit.MICROSECONDS); */
            Future<Integer> future = service.submit( () -> Math.addExact(10, 15));
            System.out.println( "Add result: " + future.get(10, TimeUnit.MICROSECONDS));
            System.out.println("Reached...");
        }catch(TimeoutException toe){
            System.out.println("Time out...");
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            service.shutdown();
        }
    }
}
