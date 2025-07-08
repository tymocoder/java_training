package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciAlgorithmsTest {
    @Test
    void correctnessTest() {
        for(int n = 0; n <= 35; n++) {
            long recursiveResult = FibonacciAlgorithms.fibonacciRecursive(n);
            long memoizedResult = FibonacciAlgorithms.fibonacciMemoized(n);
            long iterativeResult = FibonacciAlgorithms.fibonacciIterative(n);

            assertEquals(recursiveResult, memoizedResult, "Test for value: " + n);
            assertEquals(recursiveResult, iterativeResult, "Test for value: " + n);
        }
    }

    @Test
    void performanceBenchmark() {
        int[] inputValues = {10, 20, 30, 35};

        for(int value: inputValues) {
            long recursiveResult = PerformanceUtils.timeForRunMillis(() -> FibonacciAlgorithms.fibonacciRecursive(value));
            long memoizedResult = PerformanceUtils.timeForRunMillis(() -> FibonacciAlgorithms.fibonacciMemoized(value));
            long iterativeResult = PerformanceUtils.timeForRunMillis(() -> FibonacciAlgorithms.fibonacciIterative(value));

            System.out.println("Test run result for recursive function with the value: " + value + ": Execution time: " + recursiveResult + " Ms");
            System.out.println("Test run result for memoized recursive function with the value: " + value + ": Execution time: " + memoizedResult + " Ms");
            System.out.println("Test run result for iterative function with the value: " + value + ": Execution time: " + iterativeResult + " Ms");
            System.out.println();
        }
    }

    @Test
    void memoryUsageAnalysis() {
        int value = 35;

        long recursiveResult = PerformanceUtils.memoryPerRunBytes(() -> FibonacciAlgorithms.fibonacciRecursive(value));
        long memoizedResult = PerformanceUtils.memoryPerRunBytes(() -> FibonacciAlgorithms.fibonacciMemoized(value));
        long iterativeResult = PerformanceUtils.memoryPerRunBytes(() -> FibonacciAlgorithms.fibonacciIterative(value));

        System.out.println("Test run result for recursive function with the value: " + value + ": Memory used: " + recursiveResult + " Bytes");
        System.out.println("Test run result for memoized recursive function with the value: " + value + ": Memory used: " + memoizedResult + " Bytes");
        System.out.println("Test run result for iterative function with the value: " + value + ": Memory used: " + iterativeResult + " Bytes");
        System.out.println();
    }
}
