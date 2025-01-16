package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {
    @Test
    public void getMaxValueTest() {
        // Test case with positive and negative numbers
        assertEquals(10, AbsoluteMax.getMaxValue(1, -10, 5, 3));

        // Test case with all positive numbers
        assertEquals(20, AbsoluteMax.getMaxValue(10, 15, 20, 3));

        // Test case with all negative numbers
        assertEquals(-1, AbsoluteMax.getMaxValue(-8, -6, -3, -1));

        // Test case with a mix of zero, positive, and negative numbers
        assertEquals(7, AbsoluteMax.getMaxValue(0, 7, -7, 3));

        // Test case with a single element
        assertEquals(-5, AbsoluteMax.getMaxValue(-5));

        // Test case where the absolute maximum is a negative value
        assertEquals(-100, AbsoluteMax.getMaxValue(3, -50, -100, 2));

        // Test case with multiple same absolute values
        assertEquals(-9, AbsoluteMax.getMaxValue(8, -9, 9, -8));

        // Verify IllegalArgumentException is thrown for null or empty input
        assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue());
        assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue(null));
    }
}