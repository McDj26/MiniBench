package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {
    @Test
    public void findMaxTest() {
        // Test case for an array with positive integers
        int[] arrayWithPositiveIntegers = {4, 9, 1, 7};
        int expectedMax = 9;
        int actualMax = FindMax.findMax(arrayWithPositiveIntegers);
        assertEquals(expectedMax, actualMax, "The maximum value is not correctly found.");
        
        // Test case for an empty array
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int[] emptyArray = {};
            FindMax.findMax(emptyArray);
        }, "Expected an IllegalArgumentException for an empty array.");
        
        // Test case for an array with negative integers and zeros
        int[] arrayWithNegativeIntegersAndZeros = {0, -5, -7, 4};
        expectedMax = 0; // Assuming 0 is considered as a positive number here
        actualMax = FindMax.findMax(arrayWithNegativeIntegersAndZeros);
        assertEquals(expectedMax, actualMax, "The maximum value is not correctly found for negative and zero values.");
        
        // Test case for a large array with varied values
        int[] largeArray = {Integer.MIN_VALUE, -100, -5, 0, 100, Integer.MAX_VALUE}; // Assuming Java int range
        expectedMax = Integer.MAX_VALUE; // Assuming the maximum value in an int array is Integer.MAX_VALUE
        actualMax = FindMax.findMax(largeArray);
        assertEquals(expectedMax, actualMax, "The maximum value is not correctly found in a large array.");
    }
}