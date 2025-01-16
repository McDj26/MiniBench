package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    @Test
    public void middleTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Test when the list is empty
        assertNull(list.middle(), "The middle of an empty list should be null.");
        
        // Test with odd number of nodes
        list.insert(1);
        list.insert(2);
        list.insert(3);
        Node middleNode = list.middle();
        assertNotNull(middleNode, "The middle node should not be null for a non-empty list.");
        assertEquals(2, middleNode.value, "The middle node of [1, 2, 3] should have value 2.");
        
        // Test with even number of nodes
        list.insert(4);
        middleNode = list.middle();
        assertNotNull(middleNode, "The middle node should not be null for a non-empty list.");
        assertEquals(2, middleNode.value, "The middle node of [1, 2, 3, 4] should have value 2.");
        
        // Test with a longer list
        list.insert(5);
        list.insert(6);
        middleNode = list.middle();
        assertNotNull(middleNode, "The middle node should not be null for a non-empty list.");
        assertEquals(3, middleNode.value, "The middle node of [1, 2, 3, 4, 5, 6] should have value 3.");
    }
}