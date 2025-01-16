package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void sortTest() {
        QuickSort quickSort = new QuickSort();
        
        // Test with an empty array
        Integer[] emptyArray = new Integer[]{};
        Integer[] expectedEmptyArray = new Integer[]{};
        assertArrayEquals(expectedEmptyArray, quickSort.sort(emptyArray));

        // Test with a single element array
        Integer[] singleElementArray = new Integer[]{5};
        Integer[] expectedSingleElementArray = new Integer[]{5};
        assertArrayEquals(expectedSingleElementArray, quickSort.sort(singleElementArray));

        // Test with a sorted array
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        Integer[] expectedSortedArray = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(expectedSortedArray, quickSort.sort(sortedArray));

        // Test with an unsorted array
        Integer[] unsortedArray = new Integer[]{3, 5, 1, 4, 2};
        Integer[] expectedUnsortedArray = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(expectedUnsortedArray, quickSort.sort(unsortedArray));

        // Test with an array with duplicate elements
        Integer[] arrayWithDuplicates = new Integer[]{4, 3, 4, 1, 2, 1};
        Integer[] expectedArrayWithDuplicates = new Integer[]{1, 1, 2, 3, 4, 4};
        assertArrayEquals(expectedArrayWithDuplicates, quickSort.sort(arrayWithDuplicates));

        // Test with a larger array
        Integer[] largeArray = new Integer[]{13, 18, 27, 2, 19, 25, 22, 1, 17};
        Integer[] expectedLargeArray = new Integer[]{1, 2, 13, 17, 18, 19, 22, 25, 27};
        assertArrayEquals(expectedLargeArray, quickSort.sort(largeArray));
    }
}