package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {
    @Test
    public void averageTest() {
        // Test case for average method with int array
        int[] numbers = {1, 2, 3, 4, 5};
        int expectedAverage = 3; // Sum of numbers divided by the number of elements in the array
        int actualAverage = Average.average(numbers);
        assertEquals(expectedAverage, actualAverage, "The average should be equal to the expected value.");
        
        // Test case for empty input array
        assertThrows(IllegalArgumentException.class, () -> {
            int[] emptyNumbers = {}; // Empty array
            Average.average(emptyNumbers); // Should throw IllegalArgumentException for empty array
        }, "Should throw IllegalArgumentException for empty input array.");
        
        // Test case for null input array
        assertThrows(IllegalArgumentException.class, () -> {
            int[] nullNumbers = null; // Null array
            Average.average(nullNumbers); // Should throw IllegalArgumentException for null array
        }, "Should throw IllegalArgumentException for null input array.");
        
        // Test case with negative numbers in the array
        int[] negativeNumbers = {-1, -2, -3}; // Array with negative numbers
        expectedAverage = -2; // Expected average value based on the given numbers in the array
        actualAverage = Average.average(negativeNumbers); // Calculate average with negative numbers
        assertEquals(expectedAverage, actualAverage, "The average should be equal to the expected value for negative numbers.");
    }
}