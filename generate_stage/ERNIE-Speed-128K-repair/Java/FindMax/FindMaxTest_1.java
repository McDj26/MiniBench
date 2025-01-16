package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {
    @Test
    public void findMaxTest() {
        // Test case for non-empty array
        int[] array = {5, 7, 2, 9, 1};
        int expectedMax = 9;
        int actualMax = FindMax.findMax(array);
        assertEquals(expectedMax, actualMax, "The maximum value is not correctly found.");
        
        // Test case for empty array
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int[] emptyArray = {};
            FindMax.findMax(emptyArray);
        }, "Should throw IllegalArgumentException for empty array.");
        
        // Test case with negative numbers in the array
        int[] negativeArray = {-3, -7, -2, -9};
        expectedMax = -3; // The 'max' is still -3 since it is negative and greater than other numbers in the array
        actualMax = FindMax.findMax(negativeArray);
        assertEquals(expectedMax, actualMax, "The maximum negative value is not correctly found.");
    }
}