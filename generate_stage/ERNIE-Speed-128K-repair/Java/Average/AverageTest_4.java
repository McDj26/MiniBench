package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {
    @Test
    public void averageTest() {
        int[] numbers = {2, 3, 4, 5}; // Set of test numbers
        int expectedAverage = 3; // Expected average value
        int actualAverage = Average.average(numbers); // Call the method to test
        assertEquals(expectedAverage, actualAverage, "The average should be equal to " + expectedAverage); // Assert if the actual average is equal to expected average
    }
    
    @Test
    public void testWithEmptyArray() {
        int[] numbers = {}; // Test with an empty array
        assertThrows(IllegalArgumentException.class, () -> Average.average(numbers), "Should throw IllegalArgumentException for empty array"); // Assert that an IllegalArgumentException is thrown for an empty array
    }
    
    @Test
    public void testWithNullArray() {
        int[] numbers = null; // Test with null array
        assertThrows(IllegalArgumentException.class, () -> Average.average(numbers), "Should throw IllegalArgumentException for null array"); // Assert that an IllegalArgumentException is thrown for a null array
    }
}