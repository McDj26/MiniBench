package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {

    @Test
    public void testFindMaxWithPositiveNumbers() {
        int[] array = {1, 2, 3, 4, 5};
        int result = FindMax.findMax(array);
        assertEquals(5, result);
    }
    
    @Test
    public void testFindMaxWithNegativeNumbers() {
        int[] array = {-1, -2, -3, -4, -5};
        int result = FindMax.findMax(array);
        assertEquals(-1, result);
    }
    
    @Test
    public void testFindMaxWithMixedNumbers() {
        int[] array = {-1, 0, 5, 3, -10};
        int result = FindMax.findMax(array);
        assertEquals(5, result);
    }

    @Test
    public void testFindMaxWithSingleElement() {
        int[] array = {42};
        int result = FindMax.findMax(array);
        assertEquals(42, result);
    }
    
    @Test
    public void testFindMaxThrowsExceptionOnEmptyArray() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            FindMax.findMax(new int[]{});
        });
        assertEquals("Array must be non-empty.", thrown.getMessage());
    }
}