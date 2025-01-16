package com.thealgorithms.datastructures.heaps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {

    @Test
    public void insertTest() {
        FibonacciHeap heap = new FibonacciHeap();
        
        // Initially the Fibonacci heap should be empty
        assertTrue(heap.empty(), "Heap should be empty initially");
        
        // Insert a node with key 10
        HeapNode insertedNode = heap.insert(10);
        
        // After insertion, the heap should not be empty
        assertFalse(heap.empty(), "Heap should not be empty after insertion");
        
        // The size of the heap should be 1
        assertEquals(1, heap.size(), "Heap size should be 1 after one insertion");
        
        // The minimum key should be the key of the newly inserted node
        assertEquals(10, heap.findMin().getKey(), "The minimum key should be 10");
        
        // The returned node should have key 10
        assertEquals(10, insertedNode.getKey(), "Inserted node key should be 10");
        
        // Insert another node with key 5
        HeapNode secondInsertedNode = heap.insert(5);
        
        // The heap size should now be 2
        assertEquals(2, heap.size(), "Heap size should be 2 after two insertions");
        
        // The minimum key should be updated to 5
        assertEquals(5, heap.findMin().getKey(), "The minimum key should be updated to 5");
        
        // The second inserted node should have key 5
        assertEquals(5, secondInsertedNode.getKey(), "Second inserted node key should be 5");
        
        // Verify heap properties after insertion
        assertEquals(2, heap.numOfTrees(), "Number of trees should be 2 after two insertions");
        assertEquals(2, heap.numOfHeapNodes(), "Number of heap nodes should be 2 after two insertions");
    }
}