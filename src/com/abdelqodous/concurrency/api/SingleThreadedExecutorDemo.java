package com.abdelqodous.concurrency.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedExecutorDemo {
    public static void main(String[] args) {
        Runnable printInventory = new Runnable() {
            @Override
            public void run() {
                System.out.println("printing zoo inventory");
            }
        };
        Runnable printRecords = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("printing record: " +i);
                }
            }
        };
        /* 3 threads + main thread */
        /*System.out.println("<-- Begin -->");
        new Thread(printInventory).start();
        new Thread(printRecords).start();
        new Thread(printInventory).start();
        System.out.println("<-- End! -->");*/

        /* 1 thread + main thread */
//        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
//        does not implements AutoClosable, so you can't use try with resources

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("<-- Begin -->");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("<-- End! -->");

//            service.shutdown();
            service.shutdownNow();

            System.out.println(".. Is Shutdown? " +service.isShutdown());
            System.out.println(".. Is Terminated? " +service.isTerminated());
        }finally {
            assert service != null;
            service.shutdown();
            System.out.println(".. finally: Is Shutdown? " +service.isShutdown());
            System.out.println(".. finally: Is Terminated? " +service.isTerminated());
        }

    }
}
