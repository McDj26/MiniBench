package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {
    @Test
    public void insertTest() {
        FibonacciHeap heap = new FibonacciHeap();
        assertTrue(heap.empty(), "The heap should initially be empty");

        int key = 10;
        FibonacciHeap.HeapNode node = heap.insert(key);

        assertNotNull(node, "Inserted node should not be null");
        assertEquals(key, node.getKey(), "The node key should be the same as the inserted key");
        assertFalse(heap.empty(), "The heap should not be empty after insertion");
        assertEquals(1, heap.size(), "The heap size should be 1 after the first insertion");
        assertEquals(node, heap.findMin(), "Inserted node should be the minimum as it is the only node");

        int newKey = 5;
        FibonacciHeap.HeapNode newNode = heap.insert(newKey);

        assertNotNull(newNode, "Newly inserted node should not be null");
        assertEquals(newKey, newNode.getKey(), "The new node key should be the same as the inserted key");
        assertFalse(heap.empty(), "The heap should not be empty after second insertion");
        assertEquals(2, heap.size(), "The heap size should be 2 after second insertion");
        assertEquals(newNode, heap.findMin(), "Newly inserted node with smaller key should be the minimum");
    }
}