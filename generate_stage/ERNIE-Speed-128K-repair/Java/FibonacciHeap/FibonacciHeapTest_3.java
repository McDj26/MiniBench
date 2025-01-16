package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {

    @Test
    public void insertTest() {
        FibonacciHeap heap = new FibonacciHeap(); // Initialize the heap
        assertTrue(heap.empty(), "Heap should be empty initially"); // Check if the heap is initially empty
        HeapNode insertedNode = heap.insert(10); // Insert a node with key 10
        assertNotNull(insertedNode, "Inserted node should not be null"); // Verify the inserted node is not null
        assertFalse(heap.empty(), "Heap should not be empty after insertion"); // Check if the heap is not empty after insertion
        assertEquals(heap.size(), 1, "Heap size should be 1 after inserting one node"); // Check if the size of the heap is 1
        assertEquals(heap.findMin().getKey(), 10, "The minimum key in the heap should be 10"); // Check if the minimum key in the heap is 10 (since it's the only node)
        
        // Insert another node with a smaller key to test the updateMin method
        HeapNode anotherInsertedNode = heap.insert(5);
        assertNotNull(anotherInsertedNode, "Second inserted node should not be null"); // Verify the second inserted node is not null
        assertFalse(heap.empty(), "Heap should not be empty after second insertion"); // Check if the heap still not empty after second insertion
        assertEquals(heap.size(), 2, "Heap size should be 2 after inserting another node"); // Check if the size of the heap is now 2
        assertEquals(heap.findMin().getKey(), 5, "The minimum key in the heap should now be 5"); // Check if the minimum key in the heap is now 5 (because we inserted a node with key 5)
    }
}