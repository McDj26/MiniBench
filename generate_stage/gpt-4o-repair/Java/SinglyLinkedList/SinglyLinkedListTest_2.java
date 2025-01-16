package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    @Test
    public void middleTest() {
        // Test case 1: Empty list
        SinglyLinkedList list1 = new SinglyLinkedList();
        assertNull(list1.middle(), "Middle of an empty list should be null.");

        // Test case 2: List with one element
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insert(10);
        assertEquals(10, list2.middle().value, "Middle of a list with one element should be the element itself.");

        // Test case 3: List with odd number of elements
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.insert(1);
        list3.insert(2);
        list3.insert(3);
        list3.insert(4);
        list3.insert(5);
        assertEquals(3, list3.middle().value, "Middle of the list should be 3.");

        // Test case 4: List with even number of elements
        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.insert(1);
        list4.insert(2);
        list4.insert(3);
        list4.insert(4);
        assertEquals(2, list4.middle().value, "Middle of the list should be the second element, 2, when the list length is even.");
    }
}