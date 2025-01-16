package com.thealgorithms.sorts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    @Test
    public void sortTest() {
        HeapSort heapSort = new HeapSort();
        
        Integer[] unsortedArray = {4, 10, 3, 5, 1};
        Integer[] expectedSortedArray = {1, 3, 4, 5, 10};
        
        Integer[] resultArray = heapSort.sort(unsortedArray);
        
        assertArrayEquals(expectedSortedArray, resultArray, "The array should be sorted correctly");
    }
    
    // Additional test cases can be added here to further verify functionality.
    
    @Test
    public void sortAlreadySortedArrayTest() {
        HeapSort heapSort = new HeapSort();
        
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        
        Integer[] resultArray = heapSort.sort(sortedArray);
        
        assertArrayEquals(sortedArray, resultArray, "The already sorted array should remain unchanged");
    }
    
    @Test
    public void sortEmptyArrayTest() {
        HeapSort heapSort = new HeapSort();
        
        Integer[] emptyArray = {};
        
        Integer[] resultArray = heapSort.sort(emptyArray);
        
        assertArrayEquals(emptyArray, resultArray, "The empty array should remain unchanged");
    }
    
    @Test
    public void sortSingleElementArrayTest() {
        HeapSort heapSort = new HeapSort();
        
        Integer[] singleElementArray = {42};
        
        Integer[] resultArray = heapSort.sort(singleElementArray);
        
        assertArrayEquals(singleElementArray, resultArray, "The single-element array should remain unchanged");
    }
}