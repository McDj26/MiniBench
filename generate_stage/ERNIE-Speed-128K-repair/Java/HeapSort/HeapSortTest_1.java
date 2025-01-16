package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {
    @Test
    public void sortTest() {
        Integer[] unsortedArray = {5, 3, 8, 4, 2}; // Test case with simple numbers
        HeapSort heapSort = new HeapSort(); // Instantiate the HeapSort class
        Integer[] sortedArray = heapSort.sort(unsortedArray); // Sort the array using HeapSort
        assertArrayEquals(new Integer[]{2, 3, 4, 5, 8}, sortedArray); // Assert that the array is sorted in ascending order
    }
}

In the provided test case, we first create an unsorted array of integers and instantiate the HeapSort class. Then we call the sort method on the unsorted array and store the sorted array in a new variable. Finally, we use the assertArrayEquals method to assert that the sorted array is in ascending order. This test case is just one example to test the sorting functionality of the HeapSort algorithm. Depending on the complexity of the algorithm and its potential edge cases, you might need to add more test cases to ensure thorough testing.