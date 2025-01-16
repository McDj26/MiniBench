import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

package com.thealgorithms.sorts;

public class HeapSortTest {
    @Test
    public void sortTest() {
        Integer[] arr = {5, 3, 2, 4, 1}; // Test case with simple ascending order
        HeapSort heapSort = new HeapSort();
        Integer[] sortedArr = heapSort.sort(arr); // Sorting the array
        assertArrayEquals(Arrays.sort(arr), sortedArr); // Comparing the sorted array with the actual sorted array using Arrays.sort method
    }
    
    @Test
    public void sortDescendingTest() {
        Integer[] arrDesc = {5, 3, 2, 4, 1}; // Test case with descending order
        Collections.reverse(Arrays.asList(arrDesc)); // Reversing the array to simulate descending order input for testing purposes
        HeapSort heapSort = new HeapSort();
        Integer[] sortedArrDesc = heapSort.sort(arrDesc); // Sorting the array in descending order
        Integer[] expectedDesc = {5, 4, 3, 2, 1}; // Expected output after sorting in descending order
        assertArrayEquals(expectedDesc, sortedArrDesc); // Comparing the sorted array with the expected output
    }
    
    // Test case for edge cases and exception handling (if applicable) can be added here
    // ... additional tests can go here if there are other specific scenarios to cover ...
}