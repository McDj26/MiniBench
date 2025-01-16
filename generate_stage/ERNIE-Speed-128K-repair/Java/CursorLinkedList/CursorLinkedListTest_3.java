package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {
    private CursorLinkedList<Integer> list;
    private int expectedIndex;
    private Integer element;
    private int actualIndex;

    @BeforeEach
    public void setUp() {
        list = new CursorLinkedList<>();
        element = 10; // Assume the element we are searching for in the list
    }

    @Test
    public void indexOfTest() {
        // Insert some elements into the list for testing indexOf method
        list.append(element); // Add the element to the list at some position
        list.append(20); // Add another element for testing purpose (not to be searched)
        list.append(element); // Add another instance of the element to test indexOf with duplicates
        expectedIndex = 0; // Assume the first element is the one we are searching for (it's not a fixed assumption)
        actualIndex = list.indexOf(element); // Call the method to test
        assertEquals(expectedIndex, actualIndex, "The indexOf method should return the correct index of the element."); // Assert if the actual index matches our expected index
    }
}