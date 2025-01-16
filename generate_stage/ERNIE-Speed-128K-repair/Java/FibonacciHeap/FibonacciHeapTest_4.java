package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {
    @Test
    public void insertTest() {
        FibonacciHeap fibHeap = new FibonacciHeap(); // Initialize the Fibonacci heap
        assertTrue(fibHeap.empty(), "Heap should be empty initially"); // Check if the heap is initially empty
        
        // Insert nodes into the heap and test the properties
        HeapNode node1 = fibHeap.insert(5); // Insert a node with key 5
        assertNotNull(node1, "Inserted node should not be null"); // Ensure the inserted node is not null
        assertFalse(fibHeap.empty(), "Heap should not be empty after insertion"); // Heap should not be empty now
        assertEquals(fibHeap.size(), 1, "Number of nodes in the heap should be 1 after insertion"); // Check if the heap size is correct
        assertEquals(fibHeap.findMin().getKey(), 5, "Minimum key in the heap should be 5 after insertion"); // Check if the minimum key is correct
        
        // Insert another node with a smaller key to test updateMin method
        HeapNode node2 = fibHeap.insert(3); // Insert a node with key 3
        assertNotNull(node2, "Second inserted node should not be null"); // Ensure the second inserted node is not null
        assertEquals(fibHeap.size(), 2, "Number of nodes in the heap should be 2 after second insertion"); // Check if the heap size is updated correctly after second insertion
        assertEquals(fibHeap.findMin().getKey(), 3, "Minimum key in the heap should be 3 after second insertion"); // Check if the minimum key is updated correctly after second insertion
        
        // Further tests can be done by inserting more nodes and performing other operations like deleteMin, decreaseKey etc.
    }
}