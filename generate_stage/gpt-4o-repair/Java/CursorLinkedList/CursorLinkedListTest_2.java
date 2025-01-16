package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {

    @Test
    public void indexOfTest() {
        CursorLinkedList<Integer> list = new CursorLinkedList<>();

        // Append elements to the list
        list.append(10);
        list.append(20);
        list.append(30);

        // Test: indexOf should return correct indices
        assertEquals(0, list.indexOf(10), "Index of 10 should be 0");
        assertEquals(1, list.indexOf(20), "Index of 20 should be 1");
        assertEquals(2, list.indexOf(30), "Index of 30 should be 2");

        // Test: indexOf should return -1 for non-existent element
        assertEquals(-1, list.indexOf(40), "Index of 40 should be -1");

        // Test: ensure indexOf handles null elements properly
        assertThrows(NullPointerException.class, () -> {
            list.indexOf(null);
        }, "Should throw NullPointerException for null element");
    }
}