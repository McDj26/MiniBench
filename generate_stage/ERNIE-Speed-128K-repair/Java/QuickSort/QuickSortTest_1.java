package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    public void sortTest() {
        Integer[] array = {3, 2, 9, 1, 7}; // Assuming this is the array to be sorted
        QuickSort quickSort = new QuickSort(); // Instantiate the QuickSort class
        Integer[] sortedArray = quickSort.sort(array); // Sort the array using QuickSort
        assertArrayEquals(sortedArray, new Integer[]{1, 2, 3, 7, 9}); // Assert that the array is sorted in ascending order
    }
}

Explanation:
In the provided test case, we first create an array of integers that we want to sort using QuickSort algorithm. Then we instantiate the QuickSort class and call its sort method with the array as an argument. After sorting the array, we assert that the sorted array is equal to the expected sorted array in ascending order using the assertArrayEquals method from JUnit library. This test case checks if the QuickSort algorithm works correctly and sorts the array as expected.