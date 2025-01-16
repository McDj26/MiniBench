package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {
    
    @Test
    public void averageTest() {
        // Test case 1: typical case
        int[] numbers1 = {2, 4, 6, 8, 10};
        assertEquals(6, Average.average(numbers1));

        // Test case 2: single element array
        int[] numbers2 = {5};
        assertEquals(5, Average.average(numbers2));

        // Test case 3: array with negative numbers
        int[] numbers3 = {-2, -4, -6, -8, -10};
        assertEquals(-6, Average.average(numbers3));

        // Test case 4: array with mixed positive and negative numbers
        int[] numbers4 = {5, -5, 10, -10};
        assertEquals(0, Average.average(numbers4));

        // Test case 5: large numbers
        int[] numbers5 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertEquals(Integer.MAX_VALUE, Average.average(numbers5));

        // Test case 6: check handling null array
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            Average.average(null);
        });
        assertEquals("Numbers array cannot be empty or null", exception1.getMessage());

        // Test case 7: check handling empty array
        int[] numbers7 = {};
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            Average.average(numbers7);
        });
        assertEquals("Numbers array cannot be empty or null", exception2.getMessage());
    }
}