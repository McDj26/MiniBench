package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {

    @Test
    public void insertTest() {
        FibonacciHeap fibonacciHeap = new FibonacciHeap();

        // Initially, the heap should be empty
        assertTrue(fibonacciHeap.empty());

        int key = 10;
        FibonacciHeap.HeapNode insertedNode = fibonacciHeap.insert(key);

        // The heap should not be empty after insertion
        assertFalse(fibonacciHeap.empty());

        // Check that the inserted node is the minimum
        assertEquals(key, fibonacciHeap.findMin().getKey());

        // Check that the number of nodes in the heap is incremented
        assertEquals(1, fibonacciHeap.size());

        // Check that the node was inserted correctly
        assertNotNull(insertedNode);
        assertEquals(key, insertedNode.getKey());

        // Inserting another node
        int secondKey = 5;
        FibonacciHeap.HeapNode secondInsertedNode = fibonacciHeap.insert(secondKey);

        // Since 5 is less than 10, it should now be the minimum
        assertEquals(secondKey, fibonacciHeap.findMin().getKey());

        // The size should be 2 now
        assertEquals(2, fibonacciHeap.size());

        // Check that the second node was inserted correctly
        assertNotNull(secondInsertedNode);
        assertEquals(secondKey, secondInsertedNode.getKey());
    }
}