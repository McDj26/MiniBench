package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {
    @Test
    public void getMaxValueTest() {
        // Test case for getMaxValue method with positive numbers
        int[] positiveNumbers = {3, 7, 2, 9, 5};
        int expectedMax = 9; // Absolute maximum value in the array is 9
        int actualMax = AbsoluteMax.getMaxValue(positiveNumbers);
        assertEquals(expectedMax, actualMax, "The absolute maximum value is not correct.");
        
        // Test case for getMaxValue method with negative numbers
        int[] negativeNumbers = {-3, -7, -2, -9, -5};
        expectedMax = -3; // Absolute maximum value in the array is -3 (considering absolute value)
        actualMax = AbsoluteMax.getMaxValue(negativeNumbers);
        assertEquals(expectedMax, actualMax, "The absolute maximum value is not correct for negative numbers.");
        
        // Test case for getMaxValue method with both positive and negative numbers
        int[] mixedNumbers = {3, -7, 2, -9, 5};
        expectedMax = Math.abs(mixedNumbers[0]); // The absolute maximum is the first number because it's positive compared to others in this case
        actualMax = AbsoluteMax.getMaxValue(mixedNumbers);
        assertEquals(expectedMax, actualMax, "The absolute maximum value is not correct when both positive and negative numbers are present.");
        
        // Test case with empty array
        assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue()); // Should throw IllegalArgumentException for empty array
    }
}