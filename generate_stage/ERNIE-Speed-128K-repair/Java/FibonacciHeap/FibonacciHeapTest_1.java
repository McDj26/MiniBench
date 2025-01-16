package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {

    private FibonacciHeap fibHeap;

    @BeforeEach
    public void setUp() {
        fibHeap = new FibonacciHeap(); // Initialize the Fibonacci heap
    }

    @Test
    public void insertTest() {
        int testKey = 5; // Insertion key for this test case
        HeapNode insertedNode = fibHeap.insert(testKey); // Insert a node into the heap
        assertNotNull(insertedNode); // Assert that the inserted node is not null
        assertEquals(testKey, insertedNode.getKey()); // Assert that the key of the inserted node is correct
        assertEquals(fibHeap.size(), 1); // Assert that the number of nodes in the heap is 1 after insertion
        assertFalse(fibHeap.empty()); // Assert that the heap is not empty after insertion
    }
}