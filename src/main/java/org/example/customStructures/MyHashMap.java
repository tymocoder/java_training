package org.example.customStructures;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {
    private static class Entry<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    private Entry<K, V>[] table;
    private int threshhold;

    public MyHashMap() {
        table = new Entry[DEFAULT_CAPACITY];
        threshhold = (int) (DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
    }

    private int index(Object key) {
        return (key == null ? 0 : (key.hashCode() & 0x7fffffff) % table.length);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        int i = index(key);
        Entry<K, V> head = table[i];
        for (Entry<K, V> e = head; e != null; e = e.next) {
            if (Objects.equals(key, e.key)) {
                return e.setValue(value);
            }
        }
        table[i] = new Entry<>(key, value, head);
        size++;
        if (size > threshhold) {
            resize();
        }
        return null;
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        int newCapacity = oldTable.length * 2;
        threshhold = (int) (newCapacity * DEFAULT_LOAD_FACTOR);
        table = new Entry[newCapacity];

        for (Entry<K, V> e : oldTable) {
            while (e != null) {
                Entry<K, V> next = e.next;
                int i = (e.key == null ? 0 : (e.key.hashCode() & 0x7fffffff) % table.length);
                e.next = table[i];
                table[i] = e;
                e = next;
            }
        }
    }

    public V get(Object key) {
        int i = index(key);
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            if (Objects.equals(key, e.key)) {
                return e.value;
            }
        }
        return null;
    }

    public V remove(Object key) {
        int i = index(key);
        Entry<K, V> prev = null;
        for (Entry<K, V> e = table[i]; e != null;) {
            if (Objects.equals(key, e.key)) {
                if (prev == null) {
                    table[i] = e.next;
                }
                else {
                    prev.next = e.next;
                }
                size--;
                return e.value;
            }
            prev = e;
            e = e.next;
        }
        return null;
    }

    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (Entry<K, V> e : table) {
            while (e != null) {
                set.add(e);
                e = e.next;
            }
        }
        return set;
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Entry<K, V> e : table) {
            while (e != null) {
                set.add(e.key);
                e = e.next;
            }
        }
        return set;
    }

    public Collection<V> values() {
        List<V> list = new ArrayList<>();
        for (Entry<K, V> e : table) {
            while (e != null) {
                list.add(e.value);
                e = e.next;
            }
        }
        return list;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
