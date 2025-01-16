package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {
    @Test
    public void getMaxValueTest() {
        // Test with positive numbers
        int[] positiveNumbers = {3, 7, 2, 9, 5};
        int expectedPositiveMax = 9; // Absolute maximum is 9 in this case
        assertEquals(expectedPositiveMax, AbsoluteMax.getMaxValue(positiveNumbers));
        
        // Test with negative numbers
        int[] negativeNumbers = {-3, -7, -2, -9, -5};
        int expectedNegativeMax = -3; // Absolute maximum is -3 in this case
        assertEquals(expectedNegativeMax, AbsoluteMax.getMaxValue(negativeNumbers));
        
        // Test with mixed positive and negative numbers
        int[] mixedNumbers = {-3, 7, -2, 9, 5};
        int expectedMixedMax = 9; // Absolute maximum is still 9 despite the presence of negative numbers
        assertEquals(expectedMixedMax, AbsoluteMax.getMaxValue(mixedNumbers));
        
        // Test with empty array (expecting exception)
        assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue()); // Expected exception for empty array
        assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue(new int[0])); // Expected exception for empty array with explicit array initialization
    }
}