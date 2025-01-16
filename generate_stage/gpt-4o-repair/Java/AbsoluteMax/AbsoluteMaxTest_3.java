package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {

    @Test
    public void getMaxValueTest() {
        // Test with positive numbers
        assertEquals(5, AbsoluteMax.getMaxValue(1, 2, 3, 4, 5));

        // Test with negative numbers
        assertEquals(-5, AbsoluteMax.getMaxValue(-1, -2, -3, -4, -5));

        // Test with a mix of positive and negative numbers
        assertEquals(5, AbsoluteMax.getMaxValue(-1, -2, -3, 4, 5));

        // Test with zero included
        assertEquals(5, AbsoluteMax.getMaxValue(0, -2, 5, -3, 0));

        // Test with a single element
        assertEquals(42, AbsoluteMax.getMaxValue(42));

        // Test with multiple max absolute numbers
        assertEquals(-5, AbsoluteMax.getMaxValue(1, 2, -5, 5, 3));

        // Test with exception for empty array
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AbsoluteMax.getMaxValue();
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());

        // Test with exception for null array
        exception = assertThrows(IllegalArgumentException.class, () -> {
            AbsoluteMax.getMaxValue((int[]) null);
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());
    }
}