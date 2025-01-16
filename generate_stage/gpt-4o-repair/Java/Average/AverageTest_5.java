package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {

    @Test
    public void averageTest() {
        // Test with a normal array of positive integers
        int[] numbers1 = {2, 4, 6, 8, 10};
        assertEquals(6, Average.average(numbers1));

        // Test with a normal array including negative numbers
        int[] numbers2 = {5, -5, 10, -10, 20};
        assertEquals(4, Average.average(numbers2));

        // Test with a single element array
        int[] numbers3 = {42};
        assertEquals(42, Average.average(numbers3));

        // Test with an array leading to rounding
        int[] numbers4 = {1, 2};
        assertEquals(1, Average.average(numbers4));

        // Test with a mix of positive and negative numbers
        int[] numbers5 = {-1, -1, 1, 1, 0};
        assertEquals(0, Average.average(numbers5));

        // Ensure the exception is thrown for null
        assertThrows(IllegalArgumentException.class, () -> {
            Average.average(null);
        });

        // Ensure the exception is thrown for empty array
        assertThrows(IllegalArgumentException.class, () -> {
            Average.average(new int[]{});
        });
    }
}