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

        // Test with mixed positive and negative numbers
        assertEquals(-5, AbsoluteMax.getMaxValue(1, -5, 3, 4, 2));

        // Test with zero included
        assertEquals(3, AbsoluteMax.getMaxValue(0, 3, -3, 2));

        // Test with equal absolute values
        assertEquals(3, AbsoluteMax.getMaxValue(3, -3, 2, -2));

        // Test with single value
        assertEquals(42, AbsoluteMax.getMaxValue(42));

        // Test with repeated maximum absolute value
        assertEquals(-10, AbsoluteMax.getMaxValue(-10, -10, 10));

        // Test with an empty array, expecting an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AbsoluteMax.getMaxValue();
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());

        // Test with null array, expecting an exception
        exception = assertThrows(IllegalArgumentException.class, () -> {
            AbsoluteMax.getMaxValue((int[]) null);
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());
    }
}