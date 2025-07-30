package org.example;

import java.util.HashMap;
import java.util.Map;

import static org.example.PerformanceUtils.timeForRunNanosec;

public class MyHashMapPerformanceTest {
    private static final int NUMBER_OF_ACTIONS = 1_000;

    public static void main(String[] args) {
        performanceTest();
    }

    private static void performanceTest() {
        MyHashMap<String, Integer> myMap = new MyHashMap<>();
        Map<String, Integer> javaMap = new HashMap<>();

        long timePerRunPutJdkHashMap = timeForRunNanosec(() -> {
            for (int i = 0; i < NUMBER_OF_ACTIONS; i++) {
                javaMap.put("key" + i, i);
            }
        });

        long timePerRunPutMyHashMap = timeForRunNanosec(() -> {
            for (int i = 0; i < NUMBER_OF_ACTIONS; i++) {
                myMap.put("key" + i, i);
            }
        });

        System.out.println("Put method performance test:");
        System.out.println("Test run result for the JDK HashMap with the number of Put actions " + NUMBER_OF_ACTIONS + ": Execution time: " + timePerRunPutJdkHashMap + " Nanosec");
        System.out.println("Test run result for the MyHashMap with the number of Put actions " + NUMBER_OF_ACTIONS + ": Execution time: " + timePerRunPutMyHashMap + " Nanosec");
        System.out.println("-----------");

        long timePerRunGetJdkHashMap = timeForRunNanosec(() -> {
            for (int i = 0; i < NUMBER_OF_ACTIONS; i++) {
                javaMap.get("key" + i);
            }
        });

        long timePerRunGetMyHashMap = timeForRunNanosec(() -> {
            for (int i = 0; i < NUMBER_OF_ACTIONS; i++) {
                myMap.get("key" + i);
            }
        });

        System.out.println("Get method performance test:");
        System.out.println("Test run result for the JDK HashMap with the number of Get actions " + NUMBER_OF_ACTIONS + ": Execution time: " + timePerRunGetJdkHashMap + " Nanosec");
        System.out.println("Test run result for the MyHashMap with the number of Get actions " + NUMBER_OF_ACTIONS + ": Execution time: " + timePerRunGetMyHashMap + " Nanosec");
        System.out.println("-----------");
    }
}
