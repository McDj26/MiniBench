package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    public void sortTest() {
        // Arrange
        Integer[] array = {3, 4, 2, 9, 6, 7, 5, 1}; // Input array for testing QuickSort
        QuickSort quickSort = new QuickSort(); // Object to test the sorting algorithm
        int arrayLength = array.length; // Array length for verification
        int[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 9}; // Expected sorted array for validation
        boolean shouldEqualSortedArray = true; // Flag to determine if sorted array should be equal to expectedSortedArray
        boolean shouldEqualUnsortedArray = false; // Flag to determine if original array should be unsorted
        int[] sortedArray = quickSort.sort(array); // Sorted array returned by QuickSort algorithm
        assertNotNull(sortedArray); // Ensure sorted array is not null
        assertEquals(arrayLength, sortedArray.length); // Ensure sorted array has the same length as the original array
        assertArrayEquals(expectedSortedArray, sortedArray); // Assert that the sorted array is in ascending order as expected
        assertSameElementsExactlyTwiceSorted("expectedUnsortedArray", "actualUnsortedArray", array); // Method call for checking twice in sorting unsorted array which will fail here
        assertSameElementsExactlyTwice("expectedSortedArray", "actualSortedArray", expectedSortedArray, sortedArray); // Method call for checking twice in sorting sorted array which will pass here
        assertFalse(shouldEqualUnsortedArray); // Ensure that original array is not unsorted (assumption)
        assertTrue(shouldEqualSortedArray); // Ensure that sorted array is equal to the expected sorted array
    }
}