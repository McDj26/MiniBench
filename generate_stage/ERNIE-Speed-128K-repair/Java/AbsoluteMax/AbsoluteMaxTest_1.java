package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {
    @Test
    public void getMaxValueTest() {
        // Test case for an array with positive numbers
        int[] positiveNumbers = {3, 7, 2, 9, 5};
        int expectedMax = 9; // Absolute maximum value in the array
        int actualMax = AbsoluteMax.getMaxValue(positiveNumbers);
        assertEquals(expectedMax, actualMax, "The absolute maximum value is not correct.");
        
        // Test case for an array with negative numbers
        int[] negativeNumbers = {-3, -7, -2, -9, -5};
        expectedMax = -3; // Absolute maximum value in the array (considering absolute value)
        actualMax = AbsoluteMax.getMaxValue(negativeNumbers);
        assertEquals(expectedMax, actualMax, "The absolute maximum value is not correct for negative numbers.");
        
        // Test case for an empty array
        Assertions.assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue(), "Should throw IllegalArgumentException for an empty array");
        
        // Test case for null array input
        Assertions.assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue(null), "Should throw IllegalArgumentException for null array input");
    }
}