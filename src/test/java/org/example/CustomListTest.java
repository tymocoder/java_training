package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomListTest {

    private CustomList<String> list;

    @BeforeEach
    void setup() {
        list = new CustomList<>();
    }

    @Test
    void testAddGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        assertTrue(list.add("testItemOne"));
        assertTrue(list.add("testItemTwo"));
        assertEquals("testItemOne", list.get(0));
        assertEquals("testItemTwo", list.get(1));
    }

    @Test
    void testSet() {
        list.add("testItemOne");
        list.add("testItemTwo");
        assertEquals("testItemOne", list.set(0, "testItemThree"));
        assertEquals("testItemThree", list.get(0));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());

        list.add("testItemOne");
        list.add("testItemTwo");
        assertEquals(2, list.size());
    }

    @Test
    void testRemove() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));

        list.add("testItemOne");
        list.add("testItemTwo");

        assertEquals(2, list.size());
        assertEquals("testItemOne", list.remove(0));
        assertEquals("testItemTwo", list.get(0));
        assertEquals(1, list.size());
    }
}
