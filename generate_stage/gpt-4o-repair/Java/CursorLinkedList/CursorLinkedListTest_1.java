package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {

    @Test
    public void indexOfTest() {
        CursorLinkedList<String> list = new CursorLinkedList<>();
        
        // Since the original code context doesn't provide actual implementations
        // for methods like append, we are assuming they exist as suggested.
        list.append("apple");
        list.append("banana");
        list.append("cherry");

        // Test for existing elements
        assertEquals(0, list.indexOf("apple"));
        assertEquals(1, list.indexOf("banana"));
        assertEquals(2, list.indexOf("cherry"));

        // Test for a non-existing element
        assertEquals(-1, list.indexOf("date"));

        // Test for null elements (should throw exception)
        Exception exception = assertThrows(NullPointerException.class, () -> {
            list.indexOf(null);
        });
        assertEquals("element must not be null", exception.getMessage());
    }
}