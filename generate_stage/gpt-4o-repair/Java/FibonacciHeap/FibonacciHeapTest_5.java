package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {

    @Test
    public void insertTest() {
        FibonacciHeap heap = new FibonacciHeap();
        
        // Test inserting the first node
        assertTrue(heap.empty(), "Heap should be initially empty");
        int initialKey = 10;
        FibonacciHeap.HeapNode insertedNode = heap.insert(initialKey);
        
        assertNotNull(insertedNode, "Inserted node should not be null");
        assertEquals(initialKey, insertedNode.getKey(), "Inserted node should contain the correct key");
        
        assertEquals(1, heap.size(), "Heap size should be 1 after first insertion");
        assertFalse(heap.empty(), "Heap should not be empty after insertion");
        
        assertEquals(insertedNode, heap.findMin(), "Inserted node should be the minimum");
        
        // Test inserting another node
        int secondKey = 5;
        FibonacciHeap.HeapNode secondNode = heap.insert(secondKey);

        assertNotNull(secondNode, "Second inserted node should not be null");
        assertEquals(secondKey, secondNode.getKey(), "Second inserted node should contain the correct key");
        
        assertEquals(2, heap.size(), "Heap size should be 2 after second insertion");
        assertEquals(secondNode, heap.findMin(), "Second inserted node should be the new minimum");
    }
}