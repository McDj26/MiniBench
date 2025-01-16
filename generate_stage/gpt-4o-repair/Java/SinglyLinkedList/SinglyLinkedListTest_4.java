package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    @Test
    public void middleTest() {
        // Test with an empty list
        SinglyLinkedList emptyList = new SinglyLinkedList();
        assertNull(emptyList.middle(), "Middle of an empty list should be null");

        // Test with a list of one element
        SinglyLinkedList singleElementList = new SinglyLinkedList();
        singleElementList.insertHead(1);
        assertEquals(1, singleElementList.middle().value, "Middle of a single element list should be the head");

        // Test with a list of odd number of elements
        SinglyLinkedList oddList = new SinglyLinkedList();
        oddList.insertHead(3);
        oddList.insertHead(2);
        oddList.insertHead(1); // The list is now 1 -> 2 -> 3
        assertEquals(2, oddList.middle().value, "Middle of the list should be 2");

        // Test with a list of even number of elements
        SinglyLinkedList evenList = new SinglyLinkedList();
        evenList.insertHead(4);
        evenList.insertHead(3);
        evenList.insertHead(2);
        evenList.insertHead(1); // The list is now 1 -> 2 -> 3 -> 4
        assertEquals(2, evenList.middle().value, "Middle of the list with even number of elements should be the first of the two middle elements (2)");

        // Test with another odd number of elements
        SinglyLinkedList anotherOddList = new SinglyLinkedList();
        anotherOddList.insertHead(5);
        anotherOddList.insertHead(4);
        anotherOddList.insertHead(3);
        anotherOddList.insertHead(2);
        anotherOddList.insertHead(1); // The list is now 1 -> 2 -> 3 -> 4 -> 5
        assertEquals(3, anotherOddList.middle().value, "Middle of the list should be 3");
    }
}