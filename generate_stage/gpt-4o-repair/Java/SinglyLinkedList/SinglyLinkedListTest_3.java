package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    
    @Test
    public void middleTest() {
        // Create a new SinglyLinkedList instance
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Test with an empty list
        assertNull(list.middle(), "Middle of an empty list should be null");
        
        // Add nodes to the list: {10}
        list.insertHead(10);
        assertEquals(10, list.middle().value, "Middle of the list with one element should be the only element");

        // Add nodes to the list: {10, 20}
        list.insert(20);
        assertEquals(10, list.middle().value, "Middle of the list with two elements should be the first element");

        // Add nodes to the list: {10, 20, 30}
        list.insert(30);
        assertEquals(20, list.middle().value, "Middle of the list with three elements should be the second element");

        // Add nodes to the list: {10, 20, 30, 40}
        list.insert(40);
        assertEquals(20, list.middle().value, "Middle of the list with four elements should be the second element");

        // Add nodes to the list: {10, 20, 30, 40, 50}
        list.insert(50);
        assertEquals(30, list.middle().value, "Middle of the list with five elements should be the third element");
    }
}