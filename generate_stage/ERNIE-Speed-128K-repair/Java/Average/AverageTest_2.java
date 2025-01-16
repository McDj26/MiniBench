package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {
    @Test
    public void averageTest() {
        // Test case for average method with int array
        int[] numbers = {1, 2, 3, 4, 5};
        int expectedAverage = 3; // Expected average value
        int actualAverage = Average.average(numbers); // Method call to test
        assertEquals(expectedAverage, actualAverage, "The average of the numbers is not correct.");
        
        // Test case for empty array
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int[] emptyNumbers = {}; // Empty array to test for null or empty input exception
            Average.average(emptyNumbers); // Should throw IllegalArgumentException
        }, "Method should throw IllegalArgumentException for empty or null array.");
        
        // Test case for null array
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int[] nullNumbers = null; // Null array to test for null input exception
            Average.average(nullNumbers); // Should throw IllegalArgumentException
        }, "Method should throw IllegalArgumentException for null array.");
    }
}