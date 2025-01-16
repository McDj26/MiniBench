package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSortTest {

    @Test
    public void sortTest() {
        // Create an instance of HeapSort class
        HeapSort heapSort = new HeapSort();

        // Define test cases
        Integer[] unsortedArray1 = {3, 5, 1, 4, 2};
        Integer[] expectedSortedArray1 = {1, 2, 3, 4, 5};

        String[] unsortedArray2 = {"banana", "apple", "cherry", "date"};
        String[] expectedSortedArray2 = {"apple", "banana", "cherry", "date"};

        // Call the sort method and check the results
        assertArrayEquals(expectedSortedArray1, heapSort.sort(unsortedArray1));
        assertArrayEquals(expectedSortedArray2, heapSort.sort(unsortedArray2));
    }
}