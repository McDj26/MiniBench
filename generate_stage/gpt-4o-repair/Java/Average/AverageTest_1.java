package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {
    @Test
    public void averageTest() {
        // Test case 1: average of a regular array of integers
        int[] numbers1 = {2, 4, 6, 8, 10};
        assertEquals(6, Average.average(numbers1));

        // Test case 2: single element array
        int[] numbers2 = {5};
        assertEquals(5, Average.average(numbers2));

        // Test case 3: all elements are the same
        int[] numbers3 = {7, 7, 7, 7, 7, 7, 7};
        assertEquals(7, Average.average(numbers3));

        // Test case 4: mix of negative and positive numbers
        int[] numbers4 = {-3, -1, 0, 1, 3};
        assertEquals(0, Average.average(numbers4));

        // Test case 5: larger numbers in the array
        int[] numbers5 = {1000000000, 1000000000, 1000000000, 1000000000, 1000000000};
        assertEquals(1000000000, Average.average(numbers5));

        // Test case 6: Test for IllegalArgumentException on null input
        assertThrows(IllegalArgumentException.class, () -> Average.average(null));

        // Test case 7: Test for IllegalArgumentException on empty array
        assertThrows(IllegalArgumentException.class, () -> Average.average(new int[]{}));
    }
}