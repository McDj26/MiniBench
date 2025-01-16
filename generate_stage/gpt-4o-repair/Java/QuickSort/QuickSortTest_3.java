package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void sortTest() {
        QuickSort quickSort = new QuickSort();
        
        // Test with an already sorted array
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        Integer[] sortedArrayResult = quickSort.sort(sortedArray.clone());
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, sortedArrayResult);
        
        // Test with a reverse sorted array
        Integer[] reverseArray = {5, 4, 3, 2, 1};
        Integer[] reverseArrayResult = quickSort.sort(reverseArray.clone());
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, reverseArrayResult);
        
        // Test with a random array
        Integer[] randomArray = {3, 5, 1, 4, 2};
        Integer[] randomArrayResult = quickSort.sort(randomArray.clone());
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, randomArrayResult);
        
        // Test with an array of duplicate values
        Integer[] duplicatesArray = {2, 3, 2, 3, 2};
        Integer[] duplicatesArrayResult = quickSort.sort(duplicatesArray.clone());
        assertArrayEquals(new Integer[]{2, 2, 2, 3, 3}, duplicatesArrayResult);
        
        // Test with an empty array
        Integer[] emptyArray = {};
        Integer[] emptyArrayResult = quickSort.sort(emptyArray.clone());
        assertArrayEquals(new Integer[]{}, emptyArrayResult);
        
        // Test with a single element array
        Integer[] singleElementArray = {1};
        Integer[] singleElementArrayResult = quickSort.sort(singleElementArray.clone());
        assertArrayEquals(new Integer[]{1}, singleElementArrayResult);
    }
}