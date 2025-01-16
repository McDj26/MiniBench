package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    @Test
    public void middleTest() {
        // Create a new SinglyLinkedList instance and populate it with data
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1); // Add some values to the list for testing
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        
        // Test the middle method for even length list
        Node middleNode = list.middle(); // Get the middle node of the list
        assertEquals(3, middleNode.value); // Assert that the middle node value is 3 for even length list
        
        // Test the middle method for odd length list
        list.insert(6); // Add another value to make the list odd length
        middleNode = list.middle(); // Get the middle node of the list again
        assertEquals(3, middleNode.value); // Assert that the middle node value is still 3 for odd length list (should return the node in the middle of the 'bottom half')
    }
}