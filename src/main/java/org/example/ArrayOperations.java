package org.example;

public class ArrayOperations {
    public static void shiftLeftSystemCopy(int[] array, int positions) {
        // Make sure any value of positions will work
        positions = positions % array.length;
        // Create temp array to store first <positions> elements into the temp array (they will be overwritten)
        int[] temp = new int[positions];

        // Store first <positions> elements into the temp array
        System.arraycopy(array, 0, temp, 0, positions);
        // shift left
        System.arraycopy(array, positions, array, 0, array.length - positions);
        // Add stored elements to the end
        System.arraycopy(temp, 0, array, array.length - positions, positions);
    }

    public static void shiftLeftManualLoop(int[] array, int positions) {
        positions = positions % array.length;
        int[] temp = new int[positions];

        for(int i = 0; i < positions; i++) {
            temp[i] = array[i];
        }

        for(int i = positions; i < array.length; i++) {
            array[i - positions] = array[i];
        }

        for(int i = 0; i < positions; i++) {
            array[array.length - positions + i] = temp[i];
        }
    }
}
