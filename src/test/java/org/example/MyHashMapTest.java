package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMapTest {
    @Test
    void putAndGetTest() {
        Map<String, Integer> map = new MyHashMap<>();
        assertNull(map.put("one", 1));
        assertNull(map.put("two", 2));
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertNull(map.get("three"));
        assertEquals(2, map.put("two", 22));
        assertEquals(22, map.get("two"));
    }

    @Test
    void sizeAndIsEmptyTest() {
        Map<String, Integer> map = new MyHashMap<>();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        assertNull(map.put("one", 1));
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        assertNull(map.put("two", 2));
        assertEquals(2, map.size());
    }

    @Test
    void resizeTest() {
        Map<String, Integer> map = new MyHashMap<>();
        for (int i = 0; i < 18; i++) {
            map.put("key" + i, i);
        }
        assertEquals(18, map.size());
    }

    @Test
    void removeTest() {
        Map<String, Integer> map = new MyHashMap<>();
        assertNull(map.remove("one"));
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, map.remove("two"));
        assertEquals(1, map.size());
    }

    @Test
    void containsKeyTest() {
        Map<String, Integer> map = new MyHashMap<>();
        assertFalse(map.containsKey("one"));
        map.put("one", 1);
        assertTrue(map.containsKey("one"));
    }

    @Test
    void entrySetTest() {
        Map<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        assertEquals(3, entries.size());
        for (Map.Entry<String, Integer> entry : entries) {
            assertNotNull(entry.getKey());
            assertNotNull(entry.getValue());
        }
    }

    @Test
    void keySetTest() {
        Map<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        Set<String> keys = map.keySet();
        assertTrue(keys.contains("one"));
        assertTrue(keys.contains("two"));
        assertEquals(2, keys.size());
    }

    @Test
    void valuesTest() {
        Map<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        Collection<Integer> values = map.values();
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
        assertEquals(2, values.size());
    }
}
