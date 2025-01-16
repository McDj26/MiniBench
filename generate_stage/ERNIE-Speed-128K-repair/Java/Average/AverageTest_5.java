package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {
    @Test
    public void averageTestWithValidInput() {
        int[] numbers = {1, 2, 3, 4, 5};
        int expectedAverage = 3; // (1+2+3+4+5)/5 = 3
        int actualAverage = Average.average(numbers);
        assertEquals(expectedAverage, actualAverage, "The average should be equal to the expected value.");
    }

    @Test
    public void averageTestWithEmptyArray() {
        int[] numbers = {}; // Empty array
        assertThrows(IllegalArgumentException.class, () -> {
            Average.average(numbers); // This should throw IllegalArgumentException for empty array
        }, "Should throw IllegalArgumentException for empty array.");
    }

    @Test
    public void averageTestWithNullArray() {
        int[] numbers = null; // Null array
        assertThrows(IllegalArgumentException.class, () -> {
            Average.average(numbers); // This should throw IllegalArgumentException for null array
        }, "Should throw IllegalArgumentException for null array.");
    }
}