package com.abdelqodous.thread._01;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {
    volatile int x = 1;
    AtomicInteger x0bj = new AtomicInteger(1);

    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        Runnable r1 = () -> {
            Thread trd = Thread.currentThread();
            while (t.x < 3) {
                System.out.print(trd.getName()+" : "+t.x+" : ");
                t.x++;
            }
        };
        Runnable r2=() -> {
            Thread trd = Thread.currentThread();
            while (t.x0bj.get() < 3) {
                System.out.print(trd.getName()+" : "+t.x0bj.get()+" : ");
                t.x0bj.getAndIncrement();
            }
        };
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();

    }
}
