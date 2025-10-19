package org.example.customStructures;

public class CustomQueue<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next = null;

        Node(T data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public CustomQueue() {
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;

        if (head == null) {
            head = newNode;
        }

        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        T value = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return value;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        return head.data;
    }

    public T peekLast() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        return tail.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
