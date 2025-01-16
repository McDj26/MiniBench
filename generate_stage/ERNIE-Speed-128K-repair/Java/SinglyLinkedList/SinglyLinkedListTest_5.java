package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    @Test
    public void middleTest() {
        // Create a new SinglyLinkedList instance
        SinglyLinkedList list = new SinglyLinkedList();
        // Add some nodes to the list for testing purposes
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        list.insertHead(4);
        list.insertHead(5); // List becomes 5 -> 4 -> 3 -> 2 -> 1
        // Assert that the middle node is the third node (index 2)
        Node middleNode = list.middle();
        assertEquals(3, middleNode.value); // Expected value of the middle node
        // Clear the list after testing
        list.clear(); // Ensure to clear the list to avoid memory leaks or unexpected behavior in subsequent tests
    }
}