package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void sortTest() {
        QuickSort quickSort = new QuickSort();
        
        // Test with an integer array
        Integer[] array = {3, 5, 1, 4, 2};
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        assertArrayEquals(sortedArray, quickSort.sort(array));

        // Test with an empty array
        Integer[] emptyArray = {};
        Integer[] emptySortedArray = {};
        assertArrayEquals(emptySortedArray, quickSort.sort(emptyArray));

        // Test with a single element array
        Integer[] singleElementArray = {1};
        Integer[] singleElementSortedArray = {1};
        assertArrayEquals(singleElementSortedArray, quickSort.sort(singleElementArray));

        // Test with already sorted array
        Integer[] alreadySortedArray = {1, 2, 3, 4, 5};
        Integer[] alreadySortedArrayClone = {1, 2, 3, 4, 5};
        assertArrayEquals(alreadySortedArrayClone, quickSort.sort(alreadySortedArray));

        // Test with a reverse sorted array
        Integer[] reverseSortedArray = {5, 4, 3, 2, 1};
        assertArrayEquals(sortedArray, quickSort.sort(reverseSortedArray));

        // Test with duplicate elements
        Integer[] arrayWithDuplicates = {3, 1, 2, 3, 3, 1};
        Integer[] sortedArrayWithDuplicates = {1, 1, 2, 3, 3, 3};
        assertArrayEquals(sortedArrayWithDuplicates, quickSort.sort(arrayWithDuplicates));
    }
}