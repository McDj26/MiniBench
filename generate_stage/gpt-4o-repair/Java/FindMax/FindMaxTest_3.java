package com.thealgorithms.maths;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {

    @Test
    public void findMaxWithPositiveNumbers() {
        int[] array = {1, 3, 7, 0, 5};
        int expected = 7;
        assertEquals(expected, FindMax.findMax(array));
    }

    @Test
    public void findMaxWithNegativeNumbers() {
        int[] array = {-1, -3, -7, -2, -5};
        int expected = -1;
        assertEquals(expected, FindMax.findMax(array));
    }

    @Test
    public void findMaxWithMixedNumbers() {
        int[] array = {-1, 4, -3, 2, 0};
        int expected = 4;
        assertEquals(expected, FindMax.findMax(array));
    }

    @Test
    public void findMaxWithSingleElement() {
        int[] array = {42};
        int expected = 42;
        assertEquals(expected, FindMax.findMax(array));
    }

    @Test
    public void findMaxThrowsExceptionForEmptyArray() {
        int[] array = {};
        assertThrows(IllegalArgumentException.class, () -> FindMax.findMax(array));
    }
}