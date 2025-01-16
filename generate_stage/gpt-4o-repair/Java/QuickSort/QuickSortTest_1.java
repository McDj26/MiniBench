package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void sortTest() {
        QuickSort quickSort = new QuickSort();

        // Test with an array of integers
        Integer[] intArray = {5, 3, 8, 4, 2};
        Integer[] sortedIntArray = {2, 3, 4, 5, 8};
        assertArrayEquals(sortedIntArray, quickSort.sort(intArray));

        // Test with an array of strings
        String[] stringArray = {"apple", "banana", "cherry"};
        String[] sortedStringArray = {"apple", "banana", "cherry"};
        assertArrayEquals(sortedStringArray, quickSort.sort(stringArray));

        // Test with an empty array
        Integer[] emptyArray = {};
        Integer[] sortedEmptyArray = {};
        assertArrayEquals(sortedEmptyArray, quickSort.sort(emptyArray));

        // Test with an array of a single element
        Integer[] singleElementArray = {1};
        Integer[] sortedSingleElementArray = {1};
        assertArrayEquals(sortedSingleElementArray, quickSort.sort(singleElementArray));

        // Test with an array of duplicates
        Integer[] duplicatesArray = {4, 4, 4, 4};
        Integer[] sortedDuplicatesArray = {4, 4, 4, 4};
        assertArrayEquals(sortedDuplicatesArray, quickSort.sort(duplicatesArray));
    }
}