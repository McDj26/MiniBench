package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {
    @Test
    public void getMaxValueTest() {
        // Test with positive numbers
        int[] positiveNumbers = {3, 7, 5, 9};
        int expectedMax = 9; // Absolute maximum value in the array is 9
        assertEquals(expectedMax, AbsoluteMax.getMaxValue(positiveNumbers));
        
        // Test with negative numbers
        int[] negativeNumbers = {-3, -7, -5, -9};
        expectedMax = -3; // Absolute maximum value in the array is -3 since it's not comparing actual magnitude but values as they are
        assertEquals(expectedMax, AbsoluteMax.getMaxValue(negativeNumbers));
        
        // Test with mixed numbers
        int[] mixedNumbers = {-3, 7, -5, 9, -1};
        expectedMax = 9; // Absolute maximum value in the array is 9 as the positive value surpasses negative values when absolute comparison is done
        assertEquals(expectedMax, AbsoluteMax.getMaxValue(mixedNumbers));
        
        // Test with an empty array
        Assertions.assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue()); // Expect IllegalArgumentException since the array is empty
        
        // Test with null array
        Assertions.assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue(null)); // Expect IllegalArgumentException since the array is null
    }
}