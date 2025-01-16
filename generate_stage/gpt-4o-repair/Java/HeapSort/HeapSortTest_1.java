package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    @Test
    public void sortTest() {
        HeapSort heapSort = new HeapSort();
        
        // Test case 1: Testing with an unsorted array
        Integer[] inputArray1 = {3, 5, 1, 2, 4};
        Integer[] expectedOutput1 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedOutput1, heapSort.sort(inputArray1));

        // Test case 2: Testing with an already sorted array
        Integer[] inputArray2 = {1, 2, 3, 4, 5};
        Integer[] expectedOutput2 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedOutput2, heapSort.sort(inputArray2));

        // Test case 3: Testing with a reverse sorted array
        Integer[] inputArray3 = {5, 4, 3, 2, 1};
        Integer[] expectedOutput3 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedOutput3, heapSort.sort(inputArray3));

        // Test case 4: Testing with an array containing duplicates
        Integer[] inputArray4 = {3, 1, 2, 3, 1};
        Integer[] expectedOutput4 = {1, 1, 2, 3, 3};
        assertArrayEquals(expectedOutput4, heapSort.sort(inputArray4));

        // Test case 5: Testing with a single element array
        Integer[] inputArray5 = {1};
        Integer[] expectedOutput5 = {1};
        assertArrayEquals(expectedOutput5, heapSort.sort(inputArray5));

        // Test case 6: Testing with an empty array
        Integer[] inputArray6 = {};
        Integer[] expectedOutput6 = {};
        assertArrayEquals(expectedOutput6, heapSort.sort(inputArray6));
    }
}