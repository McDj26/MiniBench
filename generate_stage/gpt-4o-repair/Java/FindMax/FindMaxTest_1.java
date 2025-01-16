package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {

    @Test
    public void findMaxTestWithPositiveNumbers() {
        int[] array = {1, 2, 3, 4, 5};
        int result = FindMax.findMax(array);
        assertEquals(5, result, "The maximum of {1, 2, 3, 4, 5} should be 5");
    }

    @Test
    public void findMaxTestWithNegativeNumbers() {
        int[] array = {-1, -2, -3, -4, -5};
        int result = FindMax.findMax(array);
        assertEquals(-1, result, "The maximum of {-1, -2, -3, -4, -5} should be -1");
    }

    @Test
    public void findMaxTestWithMixedNumbers() {
        int[] array = {1, -2, 3, -4, 5};
        int result = FindMax.findMax(array);
        assertEquals(5, result, "The maximum of {1, -2, 3, -4, 5} should be 5");
    }

    @Test
    public void findMaxTestWithSingleElement() {
        int[] array = {42};
        int result = FindMax.findMax(array);
        assertEquals(42, result, "The maximum of {42} should be 42");
    }

    @Test
    public void findMaxTestWithEmptyArray() {
        int[] array = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FindMax.findMax(array);
        });
        assertEquals("Array must be non-empty.", exception.getMessage());
    }
}