package com.abdelqodous.concurrency.stream.Serial;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerialThread {
    private static int doWork(int input){
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return input;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List.of(1, 2, 3, 4, 5)
//                .stream() // 1    2   3   4   5
                .parallelStream() // 3  4   2   5   1 or any other order
                .map( (t) -> doWork(t))
                .forEach(System.out::println);

        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start) / 1_000;
        System.out.println("Task took: " + timeTaken + " seconds");

        System.out.println(
                List.of(1, 2, 3, 4, 5, 6)
                    .parallelStream()
                    .reduce(0, (a, b) -> b - a));

        System.out.println(
                List.of('w', 'o', 'l', 'f')
                    .parallelStream()
                    .reduce("",
                            (s1, c) -> s1 + c,
                            (s2, s3) -> s2 + s3));

        Stream<String> parallel = Stream.of("w", "o", "l", "f").parallel();
        ConcurrentSkipListSet<Object> set = parallel.collect(ConcurrentSkipListSet::new,
                                                                Set::add,
                                                                Set::addAll);
        System.out.println(set);

    }
}
