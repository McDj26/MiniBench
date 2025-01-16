package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    @Test
    public void middleTest() {
        // Creating a new instance of SinglyLinkedList and setting nodes values for testing
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1); // head node
        list.insert(2); // node after head
        list.insert(3); // node after second node
        list.insert(4); // node after third node, now at the end of the list
        list.insert(5); // inserting another node at the end of the list to make it odd length list
        assertEquals(list.middle().value, 3, "The middle node should be the third node in the list.");
        assertEquals(list.size(), 5, "The size of the list should be 5."); // Checking size of the list after insertion
        assertTrue(!list.isEmpty(), "The list should not be empty."); // Checking if the list is not empty after insertion
        assertTrue(!list.detectLoop(), "The list should not have a loop."); // Checking if the list is not a loop
        assertEquals(list.count(), 1, "The count of nodes should be 1 for each value."); // Checking count of each value in list (This can be expanded for testing duplicate nodes if necessary)
        assertTrue(list.search(3), "The list should contain value 3."); // Searching for a value in the list and checking if it exists
        assertTrue(!list.search(6), "The list should not contain value 6."); // Searching for a value that does not exist in the list
        assertNotNull(list.getHead().value, "The head of the list should not be null."); // Checking if head is not null and has a value
        assertNotNull(list.getNth(1), "Getting a node at position 1 should not return null."); // Checking getting a node at a valid position returns non-null result
        assertEquals(list.getNth(2), 3, "Getting a node at position 2 should return value 3."); // Checking getting a node at a specific position returns correct value
        // Testing boundary conditions and exceptions (if applicable) can be added here as well (e.g., negative index, index exceeding list size, etc.)
    }
}