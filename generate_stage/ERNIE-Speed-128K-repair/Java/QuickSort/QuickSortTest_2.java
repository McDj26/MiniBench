package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    public void sortTest() {
        // Arrange
        Integer[] arr = {5, 3, 8, 4, 2}; // Test array
        QuickSort quickSort = new QuickSort(); // Instance of QuickSort class
        Integer expectedSortedArray[] = {2, 3, 4, 5, 8}; // Expected sorted array
        Integer[] actualSortedArray; // Actual sorted array after sorting
        
        // Act
        actualSortedArray = quickSort.sort(arr); // Sorting the array using QuickSort algorithm
        
        // Assert
        assertArrayEquals(expectedSortedArray, actualSortedArray); // Comparing sorted array with expected sorted array
    }
}