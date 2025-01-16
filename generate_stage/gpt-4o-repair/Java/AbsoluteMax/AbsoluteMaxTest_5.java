package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {

    @Test
    public void testGetMaxValueWithPositiveNumbers() {
        int result = AbsoluteMax.getMaxValue(1, 2, 3, 4, 5);
        assertEquals(5, result, "The maximum absolute value should be 5.");
    }

    @Test
    public void testGetMaxValueWithNegativeNumbers() {
        int result = AbsoluteMax.getMaxValue(-1, -2, -3, -4, -5);
        assertEquals(-5, result, "The maximum absolute value should be -5.");
    }

    @Test
    public void testGetMaxValueWithMixedNumbers() {
        int result = AbsoluteMax.getMaxValue(-10, -20, 5, 15, 0);
        assertEquals(-20, result, "The maximum absolute value should be -20.");
    }

    @Test
    public void testGetMaxValueWithSingleNumber() {
        int result = AbsoluteMax.getMaxValue(7);
        assertEquals(7, result, "The maximum absolute value should be 7.");
    }

    @Test
    public void testGetMaxValueWithZeroes() {
        int result = AbsoluteMax.getMaxValue(0, 0, 0);
        assertEquals(0, result, "The maximum absolute value should be 0.");
    }
    
    @Test
    public void testGetMaxValueWithExceptionForEmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AbsoluteMax.getMaxValue();
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());
    }

    @Test
    public void testGetMaxValueWithExceptionForNullArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AbsoluteMax.getMaxValue((int[])null);
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());
    }
}