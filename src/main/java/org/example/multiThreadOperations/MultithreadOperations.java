package org.example.multiThreadOperations;

import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;

public class MultithreadOperations {
    private static final int ARRAY_SIZE = 100_000_000;
    private static final short[] ARRAY = new short[ARRAY_SIZE];

    static {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            ARRAY[i] = 1;
        }
    }

    public static long sumParallelStream(int treadsNumber) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(treadsNumber);

        try {
            return forkJoinPool.submit(() -> IntStream.range(0, ARRAY_SIZE).parallel().mapToLong(i -> ARRAY[i]).sum()).get();
        }
        catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        finally {
            forkJoinPool.shutdown();
        }
    }

    // method splits array into parts and calculate sum in each part
    public static long sumParallelThreads(int treadsNumber) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(treadsNumber);
        int elementsNumberPerPart = ARRAY.length / treadsNumber;
        List<Future<Long>> futures = new ArrayList<>();

        for (int i = 0; i < treadsNumber; i++) {
            int start = i * elementsNumberPerPart;
            int end = (i == treadsNumber - 1) ? ARRAY.length : start + elementsNumberPerPart;

            futures.add(executorService.submit(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += ARRAY[j];
                }
                return sum;
            }));
        }

        long sum = 0;
        for (Future<Long> future : futures) {
            sum += future.get();
        }
        executorService.shutdown();
        return sum;
    }
}
