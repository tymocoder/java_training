package org.example;

public class CustomStack <T> {
    private Object[] stack;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomStack() {
        stack = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T value) {
        if (size == stack.length) {
            int newCapacity = stack.length * 2;
            Object[] newStack = new Object[newCapacity];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[size] = value;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        T value = (T) stack[size - 1];
        stack[size - 1] = null;
        size--;
        return value;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        return (T) stack[size - 1];
    }
}
