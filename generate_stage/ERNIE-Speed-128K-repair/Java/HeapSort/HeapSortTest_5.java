package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {
    @Test
    public void sortTest() {
        HeapSort heapSort = new HeapSort(); // Initialize the HeapSort object
        Integer[] unsortedArray = {5, 3, 8, 4, 2}; // Define an unsorted array
        Integer[] sortedArray = {2, 3, 4, 5, 8}; // Define the expected sorted array
        Integer[] result = heapSort.sort(unsortedArray); // Sort the unsorted array using HeapSort
        assertArrayEquals(sortedArray, result); // Assert that the sorted array is correct
    }
}