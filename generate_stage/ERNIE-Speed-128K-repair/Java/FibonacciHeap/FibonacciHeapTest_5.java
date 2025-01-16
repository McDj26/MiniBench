package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {
    @Test
    public void insertTest() {
        FibonacciHeap heap = new FibonacciHeap(); // Initialize the Fibonacci heap
        assertTrue(heap.empty(), "Heap should be empty initially"); // Check if the heap is initially empty
        HeapNode insertedNode = heap.insert(10); // Insert a node with key 10
        assertNotNull(insertedNode, "Inserted node should not be null"); // Ensure the inserted node is not null
        assertFalse(heap.empty(), "Heap should not be empty after insertion"); // Heap should not be empty after insertion
        assertEquals(1, heap.size(), "Number of nodes in the heap should be 1 after insertion"); // Check the size of the heap after insertion
        assertEquals(insertedNode, heap.findMin(), "Inserted node should be the minimum in the heap"); // The inserted node should be the minimum in the heap
    }
}