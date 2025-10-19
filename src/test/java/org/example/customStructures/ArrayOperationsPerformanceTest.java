package org.example.customStructures;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.example.customStructures.PerformanceUtils.*;

public class ArrayOperationsPerformanceTest {
    private static final int[] ARRAY_SIZES = {1_000, 10_000, 100_000, 1_000_000};
    private static final int[] SHIFT_POSITIONS = {1, 10, 100, 1_000};

    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    @Test
    void executionTimeTest() {
        System.out.println("Array shift performance test");

        for(int size: ARRAY_SIZES) {
            for(int shift: SHIFT_POSITIONS) {
                if(shift >= size) {
                    continue;
                }

                int[] testArrayOne = generateRandomArray(size);
                int[] testArraytwo = Arrays.copyOf(testArrayOne, testArrayOne.length);

                long timePerRunSystemCopy = timeForRunNanosec(() -> ArrayOperations.shiftLeftSystemCopy(testArrayOne, shift));
                long timePerRunManualLoop = timeForRunNanosec(() -> ArrayOperations.shiftLeftManualLoop(testArraytwo, shift));

                System.out.println("Test run result for the System.arraycopy with the array size " + size + ", shift value " + shift + ": Execution time: " + timePerRunSystemCopy + " Nanosec");
                System.out.println("Test run result for the manual loop with the array size " + size + ", shift value " + shift + ": Execution time: " + timePerRunManualLoop + " Nanosec");
                System.out.println("-----------");
            }
        }
        // Both methods have the same time 0(n) and space 0(n) complexity, but the System.arraycopy has better performance for large arrays
    }
}
