package org.example;

import java.util.Arrays;
import java.util.List;

public class CustomList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] customListElementsArray;

    public CustomList() {
        customListElementsArray = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(E element) {
        if (size == customListElementsArray.length) {
            // The bitwise shift right used for performance
            int newCapacity = customListElementsArray.length + (customListElementsArray.length >> 1);
            /* The next block handles cases when the capacity was decreased by another possible method
                The bitwise shift will not work for 1 or 0 since 1 + (1 >> 1) = 1 + 0 = 1
             */
            if (newCapacity - (size + 1) < 0) {
                newCapacity = size + 1;
            }
            customListElementsArray = Arrays.copyOf(customListElementsArray, newCapacity);
        }
        customListElementsArray[size] = element;
        size++;
        return true;
    }
}
