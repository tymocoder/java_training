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

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " can't be retrieved from the list with size " + size);
        }
        return (E) customListElementsArray[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E newElement) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " can't be set to the list with size " + size);
        }
        E oldElement = (E) customListElementsArray[index];
        customListElementsArray[index] = newElement;
        return oldElement;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " can't be removed from the list with size " + size);
        }
        E removedElement = (E) customListElementsArray[index];
        int numberOfElementsToShift = size - index - 1;

        if(numberOfElementsToShift > 0) {
            // The System.arraycopy() method was used instead of the for() loop for the performance efficiency
            System.arraycopy(customListElementsArray, index + 1, customListElementsArray, index, numberOfElementsToShift);
        }

        size--;
        // Clear the last element reference to allow garbage collection
        customListElementsArray[size] = null;

        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            customListElementsArray[i] = null;
        size = 0;
    }
}
