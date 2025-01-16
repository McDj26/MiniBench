package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {

    @Test
    public void insertTest() {
        // Arrange
        FibonacciHeap fibHeap = new FibonacciHeap();
        int initialSize = fibHeap.size();
        int insertKey = 10;

        // Act
        FibonacciHeap.HeapNode insertedNode = fibHeap.insert(insertKey);

        // Assert
        assertNotNull(insertedNode, "Inserted node should not be null");
        assertEquals(insertKey, insertedNode.getKey(), "Inserted node's key should be the same as the key passed to insert method");
        assertEquals(initialSize + 1, fibHeap.size(), "Size of the heap should be incremented by 1 after insertion");
        assertFalse(fibHeap.empty(), "Heap should not be empty after insertion");
        assertEquals(insertedNode, fibHeap.findMin(), "Inserted node should be the minimum node when it's the only one");
    }
}