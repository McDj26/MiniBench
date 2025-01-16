package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {
    private CursorLinkedList<Integer> list;
    private int expectedIndex;
    private Integer elementToFind;

    @BeforeEach
    public void setUp() {
        list = new CursorLinkedList<>();
        elementToFind = 5;
        expectedIndex = 3; // Assuming we are trying to find an element at index 3
    }

    @Test
    public void indexOfTest() {
        // Append elements to the list to make it easier to find the elementToFind later on
        for (int i = 0; i < 10; i++) { // Assuming we append at least 5 elements to simulate a list with the elementToFind at index 3
            list.append(i); // Assuming the append method works correctly to insert elements into the list
        }
        // Now the list should contain the elementToFind at index expectedIndex or throws NoSuchElementException if not found
        assertTrue(list.indexOf(elementToFind) == expectedIndex, "Element should be found at index " + expectedIndex);
        // Now let's test a case where the element is not in the list
        elementToFind = Integer.MAX_VALUE; // An element that is not in the list
        assertThrows(NoSuchElementException.class, () -> { list.indexOf(elementToFind); }, "Element not found"); // Should throw NoSuchElementException since the element is not in the list
    }
}