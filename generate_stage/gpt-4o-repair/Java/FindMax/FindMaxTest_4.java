package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {

    @Test
    public void findMaxTest() {
        // Test case 1: Normal case
        int[] array1 = {1, 3, 2, 8, 5, 7};
        assertEquals(8, FindMax.findMax(array1), "The maximum value should be 8");

        // Test case 2: Single element
        int[] array2 = {4};
        assertEquals(4, FindMax.findMax(array2), "The maximum value should be 4");

        // Test case 3: All elements are the same
        int[] array3 = {7, 7, 7, 7};
        assertEquals(7, FindMax.findMax(array3), "The maximum value should be 7");

        // Test case 4: Negative numbers
        int[] array4 = {-5, -1, -3, -4};
        assertEquals(-1, FindMax.findMax(array4), "The maximum value should be -1");

        // Test case 5: Array with both positive and negative numbers
        int[] array5 = {0, -3, -2, 2, 3};
        assertEquals(3, FindMax.findMax(array5), "The maximum value should be 3");
    }

    @Test
    public void findMaxEmptyArrayTest() {
        // Test case 6: Empty array should throw an exception
        int[] array6 = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FindMax.findMax(array6);
        });
        assertEquals("Array must be non-empty.", exception.getMessage());
    }
}