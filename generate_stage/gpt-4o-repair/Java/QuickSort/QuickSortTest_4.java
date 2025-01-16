package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void sortTest() {
        QuickSort quickSort = new QuickSort();
        
        // Test case 1: Sort an already sorted array
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        Integer[] result = quickSort.sort(sortedArray);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, result);

        // Test case 2: Sort a reverse order array
        Integer[] reverseArray = {5, 4, 3, 2, 1};
        result = quickSort.sort(reverseArray);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, result);

        // Test case 3: Sort an array with duplicate elements
        Integer[] duplicateArray = {3, 1, 2, 3, 3};
        result = quickSort.sort(duplicateArray);
        assertArrayEquals(new Integer[]{1, 2, 3, 3, 3}, result);
        
        // Test case 4: Sort an array with a single element
        Integer[] singleElementArray = {1};
        result = quickSort.sort(singleElementArray);
        assertArrayEquals(new Integer[]{1}, result);
        
        // Test case 5: Sort an empty array
        Integer[] emptyArray = {};
        result = quickSort.sort(emptyArray);
        assertArrayEquals(new Integer[]{}, result);

        // Test case 6: Sort an array with negative numbers
        Integer[] negativeArray = {0, -1, -3, -2, -4, -5};
        result = quickSort.sort(negativeArray);
        assertArrayEquals(new Integer[]{-5, -4, -3, -2, -1, 0}, result);
    }
}