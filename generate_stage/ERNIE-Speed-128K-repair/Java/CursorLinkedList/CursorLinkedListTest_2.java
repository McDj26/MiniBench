package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {
    private CursorLinkedList<Integer> list;
    private final int COUNT = 5; // Number of elements to be added to the list

    @BeforeEach
    public void setUp() {
        list = new CursorLinkedList<>(); // Initialize a new instance of CursorLinkedList
        for (int i = 0; i < COUNT; i++) { // Add elements to the list for testing
            list.append(i);
        }
    }

    @Test
    public void indexOfTest() {
        int expectedIndex = 0; // Expected index of the element in the list
        Integer element = 0; // Element to be searched in the list
        assertEquals(expectedIndex, list.indexOf(element), "Element should be found at index " + expectedIndex); // Assert that the element is found at the expected index
        element = 2; // Change the element to search for a different element in the list
        expectedIndex = 2; // Update the expected index accordingly
        assertEquals(expectedIndex, list.indexOf(element), "Element should be found at index " + expectedIndex); // Assert that the new element is found at the new expected index
        element = COUNT + 1; // Try to find an element that is not in the list
        assertEquals(-1, list.indexOf(element), "Element should not be found in the list"); // Assert that the element is not found and returns -1
    }
}