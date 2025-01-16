package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    public void sortTest() {
        Integer[] array = {Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(9)};
        QuickSort quickSort = new QuickSort();
        Integer[] sortedArray = quickSort.sort(array);
        assertArrayEquals(sortedArray, new Integer[]{Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(9)});
        assertEquals(sortedArray[0], Integer.valueOf(3)); // Test for the smallest element in the sorted array
        assertEquals(sortedArray[sortedArray.length - 1], Integer.valueOf(9)); // Test for the largest element in the sorted array
        assertEquals(sortedArray[array.length / 2], Integer.valueOf(6)); // Test for the middle element in the sorted array
    }
}

Here is the completed unit test for the `QuickSort` class in Java using JUnit framework. The test case `sortTest` sorts an array using the `sort` method of `QuickSort` and then checks if the resulting array is sorted in ascending order using the `assertArrayEquals` assertion method from JUnit framework. Additionally, it checks if the smallest, largest and middle elements are in their correct positions.