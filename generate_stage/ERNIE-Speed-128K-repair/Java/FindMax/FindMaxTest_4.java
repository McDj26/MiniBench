package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {
    @Test
    public void findMaxTest() {
        // Test case for an array with positive integers
        int[] arrayWithPositiveIntegers = {5, 2, 8, 1};
        int expectedMax = 8; // The expected maximum value in the array
        int actualMax = FindMax.findMax(arrayWithPositiveIntegers); // Call the function to find the maximum value
        assertEquals(expectedMax, actualMax, "The maximum value is not correct."); // Assert that the actual maximum is as expected
        
        // Test case for an array with negative integers
        int[] arrayWithNegativeIntegers = {-5, -8, -1, -3};
        expectedMax = -1; // The expected maximum value in the array is -1, even though it's a negative number
        actualMax = FindMax.findMax(arrayWithNegativeIntegers); // Call the function to find the maximum value
        assertEquals(expectedMax, actualMax, "The maximum value is not correct for negative integers."); // Assert that the actual maximum is as expected
        
        // Test case for an empty array
        Assertions.assertThrows(IllegalArgumentException.class, () -> { // Assert that an IllegalArgumentException is thrown when an empty array is provided
            FindMax.findMax(new int[]{}); // Call the function with an empty array to trigger the exception
        });
    }
}