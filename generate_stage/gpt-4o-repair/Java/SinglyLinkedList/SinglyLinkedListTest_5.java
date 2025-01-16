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
        list2.insert(1);
        assertEquals(1, list2.middle().value, "Middle of a list with one element should be that element.");

        // Test case 3: List with two elements
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.insert(1);
        list3.insert(2);
        assertEquals(1, list3.middle().value, "Middle of a list with two elements should be the first element.");

        // Test case 4: List with odd number of elements
        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.insert(1);
        list4.insert(2);
        list4.insert(3);
        assertEquals(2, list4.middle().value, "Middle of a list with three elements should be the second element.");

        // Test case 5: List with even number of elements
        SinglyLinkedList list5 = new SinglyLinkedList();
        list5.insert(1);
        list5.insert(2);
        list5.insert(3);
        list5.insert(4);
        assertEquals(2, list5.middle().value, "Middle of a list with four elements should be the second element.");
    }
}