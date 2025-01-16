package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {
    @Test
    public void sortTest() {
        // Arrange
        HeapSort heapSort = new HeapSort();
        Integer[] unsortedArray = {9, 7, 5, 11, 12}; // Test case with multiple values
        Integer expectedSortedArray[] = {5, 7, 9, 11, 12}; // Expected sorted array
        
        // Act
        Integer sortedArray = heapSort.sort(unsortedArray);
        
        // Assert
        assertArrayEquals(expectedSortedArray, sortedArray, "The array is not sorted correctly");
    }
}

Explanation:
In the given test case, we are arranging an unsorted array "unsortedArray" with five integers and an expected sorted array "expectedSortedArray". We are then calling the "sort" method of the HeapSort class with the unsorted array as an argument. After sorting, we are using the "assertArrayEquals" method to assert that the sorted array matches the expected sorted array. If the assertion fails, it will throw an AssertionError with the provided message "The array is not sorted correctly".