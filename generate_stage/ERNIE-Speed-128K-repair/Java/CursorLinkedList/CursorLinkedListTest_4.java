package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {
    private CursorLinkedList<Integer> list;
    private final int COUNT = 10; // number of elements in the list for this test case

    @BeforeEach
    public void setUp() {
        list = new CursorLinkedList<>();
        for (int i = 0; i < COUNT; i++) {
            list.append(i); // Add elements to the list for testing purposes
        }
    }

    @Test
    public void indexOfTest() {
        // Test indexOf method for valid elements in the list
        for (int i = 0; i < COUNT; i++) {
            assertEquals(i, list.indexOf(list.get(i))); // Assert that indexOf returns the correct index for each element in the list
        }
        // Test indexOf method for an element that is not in the list
        assertEquals(-1, list.indexOf(COUNT + 1)); // Assert that indexOf returns -1 for an element not in the list
    }
}