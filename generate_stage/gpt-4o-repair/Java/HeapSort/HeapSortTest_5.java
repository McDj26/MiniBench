package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    @Test
    public void sortTest() {
        HeapSort heapSort = new HeapSort();

        // Test case 1: Unsorted array of integers
        Integer[] unsortedArray1 = {5, 3, 8, 4, 2};
        Integer[] sortedArray1 = {2, 3, 4, 5, 8};
        assertArrayEquals(sortedArray1, heapSort.sort(unsortedArray1));

        // Test case 2: Array with repeated elements
        Integer[] unsortedArray2 = {5, 1, 5, 3, 3};
        Integer[] sortedArray2 = {1, 3, 3, 5, 5};
        assertArrayEquals(sortedArray2, heapSort.sort(unsortedArray2));

        // Test case 3: Already sorted array
        Integer[] unsortedArray3 = {1, 2, 3, 4, 5};
        Integer[] sortedArray3 = {1, 2, 3, 4, 5};
        assertArrayEquals(sortedArray3, heapSort.sort(unsortedArray3));

        // Test case 4: Reverse sorted array
        Integer[] unsortedArray4 = {9, 6, 4, 3, 1};
        Integer[] sortedArray4 = {1, 3, 4, 6, 9};
        assertArrayEquals(sortedArray4, heapSort.sort(unsortedArray4));

        // Test case 5: Array with all elements the same
        Integer[] unsortedArray5 = {7, 7, 7, 7, 7};
        Integer[] sortedArray5 = {7, 7, 7, 7, 7};
        assertArrayEquals(sortedArray5, heapSort.sort(unsortedArray5));

        // Test case 6: Empty array
        Integer[] unsortedArray6 = {};
        Integer[] sortedArray6 = {};
        assertArrayEquals(sortedArray6, heapSort.sort(unsortedArray6));

        // Test case 7: Single element array
        Integer[] unsortedArray7 = {1};
        Integer[] sortedArray7 = {1};
        assertArrayEquals(sortedArray7, heapSort.sort(unsortedArray7));
    }
}