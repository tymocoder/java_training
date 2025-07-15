package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.*;
import java.util.*;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        String packageName = "org.example";
        String path = packageName.replace('.', '/');
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL resource = loader.getResource(path);

        if (resource == null) throw new IllegalArgumentException("Package " + packageName + " not found");

        Path dirPath = Paths.get(resource.toURI());
        List<Class<?>> testClasses = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath, "*.class")) {
            for (Path file : stream) {
                String className = file.getFileName().toString().replace(".class", "");
                Class<?> testClass = Class.forName(packageName + "." + className);
                testClasses.add(testClass);
            }
        }

        int amountOfTests = 0;
        int passedTests = 0;
        int failedTests = 0;
        long totalTime = 0;
        List<String> results = new ArrayList<>();

        for (Class<?> testClass : testClasses) {
            Object testInstance = testClass.getDeclaredConstructor().newInstance();

            for (Method method : testClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    amountOfTests++;
                    String methodName = method.getName();
                    long startTime = System.nanoTime();
                    try {
                        method.invoke(testInstance);
                        passedTests++;
                        results.add("Test " + methodName + " passed");
                    } catch (Exception e) {
                        failedTests++;
                        results.add("Test " + methodName + " failed: " + e.getMessage());
                    }
                    long endTime = System.nanoTime();
                    totalTime += endTime - startTime;
                }
            }
        }

        System.out.println("Amount of tests: " + amountOfTests);
        System.out.println("Passed tests: " + passedTests);
        System.out.println("Failed tests: " + failedTests);
        System.out.println("Total time: " + totalTime / 1000000 + " Ms");
        for (String result : results) {
            System.out.println(result);
        }

    }
}
