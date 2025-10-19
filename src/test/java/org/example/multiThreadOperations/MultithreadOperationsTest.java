package org.example.multiThreadOperations;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class MultithreadOperationsTest {
    private static final int[] THREADS_NUMBERS = {1, 10, 100, 1_000};

    @Test
    void comparePerformance() {
        System.out.println("Multithread operations performance test started");

        try (FileWriter fileWriter = new FileWriter("Multithread_operations_test_result.csv");) {
        }
        catch (IOException e) {
            System.err.println("Error while writing to the file");
            e.printStackTrace();
        }
    }
}
