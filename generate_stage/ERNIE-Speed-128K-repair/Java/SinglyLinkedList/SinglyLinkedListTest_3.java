package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    @Test
    public void middleTest() {
        // Create a new SinglyLinkedList instance
        SinglyLinkedList list = new SinglyLinkedList();
        // Insert some nodes into the list
        list.insertHead(1); // Node with value 1
        list.insertHead(2); // Node with value 2
        list.insertHead(3); // Node with value 3
        list.insertHead(4); // Node with value 4
        // Ensure the list is not empty for middle calculation
        assertNotNull(list);
        // Call the middle method and assert the result is correct for even length list
        Node middleNode = list.middle();
        assertEquals(Integer.valueOf(2), middleNode.value); // Since it's an even length list, middle should be the second node from the head
        // Clean up the list to avoid memory leak
        list.clear();
    }
}