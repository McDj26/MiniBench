package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {
    
    @Test
    public void sortTest() {
        HeapSort heapSort = new HeapSort();

        // Test with unsorted array of integers
        Integer[] unsortedArray = {10, 3, 76, 34, 23, 32, 45};
        Integer[] sortedArray = {3, 10, 23, 32, 34, 45, 76};
        assertArrayEquals(sortedArray, heapSort.sort(unsortedArray));
        
        // Test with unsorted array of strings
        String[] unsortedStrings = {"banana", "apple", "orange"};
        String[] sortedStrings = {"apple", "banana", "orange"};
        assertArrayEquals(sortedStrings, heapSort.sort(unsortedStrings));

        // Test with an already sorted array
        Integer[] sortedAlready = {1, 2, 3, 4, 5};
        assertArrayEquals(sortedAlready, heapSort.sort(sortedAlready));

        // Test with single element array
        Integer[] singleElementArray = {42};
        Integer[] singleElementSorted = {42};
        assertArrayEquals(singleElementSorted, heapSort.sort(singleElementArray));

        // Test with empty array
        Integer[] emptyArray = {};
        Integer[] emptyArraySorted = {};
        assertArrayEquals(emptyArraySorted, heapSort.sort(emptyArray));
    }
}