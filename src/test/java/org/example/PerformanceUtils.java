package org.example;

public class PerformanceUtils {
    public static long timeForRunMillis(Runnable task) {
        long timeOnStart = System.currentTimeMillis();
        task.run();
        long timeOnFinish = System.currentTimeMillis();
        return timeOnFinish - timeOnStart;
    }

    public static long memoryPerRunBytes(Runnable task) {
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long memoryOnStartUsed = runtime.totalMemory() - runtime.freeMemory();
        task.run();
        System.gc();
        long memoryOnFinishUsed = runtime.totalMemory() - runtime.freeMemory();
        return memoryOnFinishUsed - memoryOnStartUsed;
    }
}
