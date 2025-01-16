package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {
    @Test
    public void sortTest() {
        Integer[] arr = {3, 4, 1, 5, 6}; // Test case with integers
        HeapSort hs = new HeapSort(); // Instantiate the HeapSort class
        Integer[] sortedArr = hs.sort(arr); // Sort the array using HeapSort
        assertArrayEquals(new Integer[]{1, 3, 4, 5, 6}, sortedArr); // Assert the sorted array
        assertEquals(sortedArr[0], arr[0]); // Assert that the original array is modified by the sort method
    }
}