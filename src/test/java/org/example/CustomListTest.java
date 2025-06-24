package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomListTest {

    @Test
    void testAddGet() {
        CustomList<String> list = new CustomList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        assertTrue(list.add("testItemOne"));
        assertTrue(list.add("testItemTwo"));
        assertEquals("testItemOne", list.get(0));
        assertEquals("testItemTwo", list.get(1));
    }

    @Test
    void testSet() {
        CustomList<String> list = new CustomList<>();

        list.add("testItemOne");
        list.add("testItemTwo");
        assertEquals("testItemOne", list.set(0, "testItemThree"));
        assertEquals("testItemThree", list.get(0));
    }

    @Test
    void testSize() {
        CustomList<String> list = new CustomList<>();

        assertEquals(0, list.size());

        list.add("testItemOne");
        list.add("testItemTwo");
        assertEquals(2, list.size());
    }

    @Test
    void testRemove() {
        CustomList<String> list = new CustomList<>();

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
