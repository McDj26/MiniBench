package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {
    @Test
    public void findMaxTest() {
        // Test case for an array with positive integers
        int[] arrayWithPositiveIntegers = {4, 7, 2, 9, 1};
        int expectedMax = 9;
        int actualMax = FindMax.findMax(arrayWithPositiveIntegers);
        assertEquals(expectedMax, actualMax, "The maximum value is not correctly found.");
        
        // Test case for an array with negative integers
        int[] arrayWithNegativeIntegers = {-4, -7, -2, -9, -1};
        expectedMax = -4; // In this case, even though the maximum value is negative, the test should pass if the method returns the correct maximum value.
        actualMax = FindMax.findMax(arrayWithNegativeIntegers);
        assertEquals(expectedMax, actualMax, "The maximum value of negative integers is not correctly found.");
        
        // Test case for an empty array
        assertThrows(IllegalArgumentException.class, () -> FindMax.findMax(new int[0]), "An empty array should throw IllegalArgumentException.");
    }
}