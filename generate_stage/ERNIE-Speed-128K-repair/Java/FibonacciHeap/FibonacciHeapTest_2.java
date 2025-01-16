package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {
    @Test
    public void insertTest() {
        FibonacciHeap heap = new FibonacciHeap(); // Initialize a new Fibonacci heap
        HeapNode insertedNode = heap.insert(10); // Insert a node with key 10
        assertNotNull(insertedNode); // Assert that the inserted node is not null
        assertFalse(heap.empty()); // Assert that the heap is not empty after insertion
        assertEquals(1, heap.size()); // Assert that the size of the heap is 1 after insertion
        assertEquals(insertedNode, heap.findMin()); // Assert that the inserted node is the minimum in the heap
        assertEquals(1, totalCuts()); // Assert the total number of cuts after insertion is 1
        assertEquals(insertedNode, heap.deleteMin()); // Delete the minimum node and assert it is the same as the inserted node
        assertEquals(0, totalCuts()); // Assert that after deleting a node, the total cuts count is reduced to 0
    }
}