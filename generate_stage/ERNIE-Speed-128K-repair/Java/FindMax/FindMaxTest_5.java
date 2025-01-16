package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {
    @Test
    public void findMaxTest() {
        // Test with positive integer array
        int[] positiveArray = {1, 5, 2, 9, 3};
        int expectedMax = 9; // Maximum value in the array
        int actualMax = FindMax.findMax(positiveArray);
        assertEquals(expectedMax, actualMax, "Expected maximum value does not match for positive array.");
        
        // Test with negative integer array
        int[] negativeArray = {-1, -5, -2, -9, -3};
        expectedMax = -1; // Maximum value in the array (which is positive)
        actualMax = FindMax.findMax(negativeArray);
        assertEquals(expectedMax, actualMax, "Expected maximum value does not match for negative array.");
        
        // Test with empty array to check IllegalArgumentException is thrown
        Assertions.assertThrows(IllegalArgumentException.class, () -> FindMax.findMax(new int[0]));
    }
}