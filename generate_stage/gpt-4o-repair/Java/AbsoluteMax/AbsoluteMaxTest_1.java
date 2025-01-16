package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {

    @Test
    public void getMaxValueTest() {
        // Test with positive numbers
        assertEquals(10, AbsoluteMax.getMaxValue(1, 2, 3, 10, 5));
        
        // Test with negative numbers
        assertEquals(-10, AbsoluteMax.getMaxValue(-1, -2, -3, -10, -5));
        
        // Test with mixed positive and negative numbers
        assertEquals(-20, AbsoluteMax.getMaxValue(-10, 5, -20, 3));
        
        // Test with all positive and negative numbers
        assertEquals(40, AbsoluteMax.getMaxValue(-40, 10, 20, 30));
        
        // Test when maximum is first
        assertEquals(50, AbsoluteMax.getMaxValue(50, 1, 2, 3, 4, 5));
        
        // Test when maximum is last
        assertEquals(-30, AbsoluteMax.getMaxValue(1, 2, 3, -30));
        
        // Test with all same numbers
        assertEquals(5, AbsoluteMax.getMaxValue(5, 5, 5, 5, 5));
        
        // Test with an array containing zero
        assertEquals(10, AbsoluteMax.getMaxValue(0, 0, 10, -5));
        
        // Test with an array containing negative and zero
        assertEquals(7, AbsoluteMax.getMaxValue(0, -7, 3));
    }

    @Test
    public void getMaxValueThrowsExceptionForEmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AbsoluteMax.getMaxValue();
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());
    }

    @Test
    public void getMaxValueThrowsExceptionForNullArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AbsoluteMax.getMaxValue(null);
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());
    }
}