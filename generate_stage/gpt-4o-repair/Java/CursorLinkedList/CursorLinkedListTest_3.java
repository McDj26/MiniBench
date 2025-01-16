package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {
    @Test
    public void indexOfTest() {
        CursorLinkedList<String> list = new CursorLinkedList<>();
        
        // Assuming append is a method to add elements to the list
        list.append("first");
        list.append("second");
        list.append("third");

        // Test the index of existing elements
        assertEquals(0, list.indexOf("first"), "Index of 'first' should be 0");
        assertEquals(1, list.indexOf("second"), "Index of 'second' should be 1");
        assertEquals(2, list.indexOf("third"), "Index of 'third' should be 2");

        // Test index of a non-existing element
        assertEquals(-1, list.indexOf("fourth"), "Index of 'fourth' should be -1 (not found)");

        // Test index of null element
        assertThrows(NullPointerException.class, () -> list.indexOf(null), "Should throw NullPointerException for null input");
    }
}