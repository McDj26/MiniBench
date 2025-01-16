package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    @Test
    public void middleTest() {
        // Create a new SinglyLinkedList instance
        SinglyLinkedList list = new SinglyLinkedList();
        Node head = new Node(1); // Let's assume this node has a value of 1 and no next node
        list.setHead(head); // Set the head of the list
        list.insertHead(2); // Insert 2 to the head of the list, so the list becomes 2 -> 1
        list.insertHead(3); // Insert 3 to the head of the list, so the list becomes 3 -> 2 -> 1
        list.insertHead(4); // Insert 4 to the head of the list, so the list becomes 4 -> 3 -> 2 -> 1
        Node middleNode = list.middle(); // Call the method to get the middle node
        assertNotNull(middleNode); // Assert that the middle node is not null
        assertEquals(middleNode.value, 3); // Assert that the middle node has a value of 3
    }
}