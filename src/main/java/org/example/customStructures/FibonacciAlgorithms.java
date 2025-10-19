package org.example.customStructures;

import java.util.HashMap;
import java.util.Map;

public class FibonacciAlgorithms {
    /*
    Each number in the fibonacci sequence is the sum of the two previous numbers
    The function takes index as a parameter and returns value for that index from the fibonacci sequence
    Time complexity 0(2^n). The function makes two recursive calls for each value on n
    Space complexity 0(n). Space consumption is linear to n
    */
    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Memoization it is storing results of function calls to prevent repeating calculations
    // The time complexity reduced to linear 0(n) using cache. Each position is calculated only one time
    // The space complexity is also linear 0(n). Each position is stored only one time
    public static long fibonacciMemoized(int n) {
        return fibonacciMemoized(n, new HashMap<>());
    }

    private static long fibonacciMemoized(int n, Map<Integer, Long> cache) {
        if(n <= 1) {
            return n;
        }

        // Check if such a key already was computed and stored in cache. Return it if so
        if(cache.containsKey(n)) {
            return cache.get(n);
        }

        // Compute and store key and value in cache
        long result = fibonacciMemoized(n - 1, cache) + fibonacciMemoized(n - 2, cache);
        cache.put(n, result);
        return result;
    }

    // The time complexity is linear 0(n). Each position is calculated only one time
    // The space complexity is 0(1). Only three variables used. So space doesn't grow with the bigger input
    public static long fibonacciIterative(int n) {
        if(n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;

        for(int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }
}
