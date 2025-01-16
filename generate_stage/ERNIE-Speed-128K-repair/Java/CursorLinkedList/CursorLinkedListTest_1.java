package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CursorLinkedListTest {
    @Test
    public void indexOfTest() {
        CursorLinkedList<Integer> list = new CursorLinkedList<>();
        list.append(1); // Add element 1 to the list
        list.append(2); // Add element 2 to the list
        list.append(3); // Add element 3 to the list
        int index = list.indexOf(2); // Try to find element 2 in the list
        assertEquals(1, index); // Assert that element 2 is found at index 1
        int notFoundIndex = list.indexOf(4); // Try to find element 4 in the list that is not present
        assertEquals(-1, notFoundIndex); // Assert that element 4 is not found and returns -1
    }
}

In this test case, I added several assertions to verify the functionality of the `indexOf` method in the `CursorLinkedList` class. I created a `CursorLinkedList` instance and appended three elements (1, 2, and 3). Then I used the `indexOf` method to find the index of element 2 and checked if it returns the correct index (in this case, 1). Then I tried to find an element that is not in the list (element 4) and checked if it returns -1 as expected when the element is not found.