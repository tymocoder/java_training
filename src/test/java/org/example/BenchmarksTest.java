package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchmarksTest {
    private static final int FIRST_TEST_NUMBER = 1000000;
    private static final int SECOND_TEST_NUMBER = 10000;

    public static void main(String[] args) {
        System.out.println("Benchmarks test for add elements in bulk to the list");
        System.out.println("____________________________________________________");
        runBulkAddTest(new ArrayList<>(), "ArrayList");
        runBulkAddTest(new LinkedList<>(), "LinkedList");
        runBulkAddTest(new CustomList<>(), "CustomList");
        System.out.println();
        System.out.println("Benchmarks test for add and remove elements from the list");
        System.out.println("____________________________________________________");
        runAddRemoveTest(new ArrayList<>(), "ArrayList");
        runAddRemoveTest(new LinkedList<>(), "LinkedList");
        runAddRemoveTest(new CustomList<>(), "CustomList");
    }

    private static long getCurrentUsedMemoryAmount() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static void report(String listName, long memoryUsedAtStart, long timeAtStart, long timeAtEnd, long memoryUsedAtEnd) {
        long timePerRunMs = (timeAtEnd - timeAtStart) / 1000000;
        long memoryPerRunMb = (memoryUsedAtEnd - memoryUsedAtStart) / (1024 * 1024);

        System.out.println("Test run result for " + listName + ": Execution time: " + timePerRunMs + " Ms | Memory usage: " + memoryPerRunMb + " MB");
    }

    private static void runBulkAddTest(List<Integer> list, String listName) {
        long memoryUsedAtStart = getCurrentUsedMemoryAmount();
        long timeAtStart = System.nanoTime();

        for (int i = 0; i < FIRST_TEST_NUMBER; i++) {
            list.add(i);
        }

        long timeAtEnd = System.nanoTime();
        long memoryUsedAtEnd = getCurrentUsedMemoryAmount();

        report(listName, memoryUsedAtStart, timeAtStart, timeAtEnd, memoryUsedAtEnd);
    }

    private static void runAddRemoveTest (List<Integer> list, String listName) {
        long memoryUsedAtStart = getCurrentUsedMemoryAmount();
        long timeAtStart = System.nanoTime();

        for (int i = 0; i < SECOND_TEST_NUMBER; i++) {
            list.add(i);
        }

        for (int i = 0; i < SECOND_TEST_NUMBER; i++) {
            list.remove(0);
        }

        long timeAtEnd = System.nanoTime();
        long memoryUsedAtEnd = getCurrentUsedMemoryAmount();

        report(listName, memoryUsedAtStart, timeAtStart, timeAtEnd, memoryUsedAtEnd);
    }
}
