package org.example;

public class CustomLinkedList<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next = null;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " can't be retrieved from the list with size " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " can't be removed from the list with size " + size);
        }

        Node<T> removed = null;
        if (index == 0) {
            removed = head;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removed = current.next;
            current.next = current.next.next;
        }

        size--;
        return removed.data;
    }

    public T set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " can't be set from the list with size " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        T oldValue = current.data;
        current.data = value;
        return oldValue;
    }

    public int indexOf(T value) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (value == null && current.data == null || value != null && value.equals(current.data)) {
                return index;
            } else {
                current = current.next;
                index++;
            }
        }

        return -1;
    }
}
