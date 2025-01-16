package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {

    @Test
    public void averageTest() {
        // Test with a normal array
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(3, Average.average(numbers), "The average of 1, 2, 3, 4, 5 should be 3.");

        // Test with an array containing a single element
        int[] singleNumber = {10};
        assertEquals(10, Average.average(singleNumber), "The average of a single element array (10) should be 10.");

        // Test with an array containing negative numbers
        int[] negativeNumbers = {-5, -10, -15};
        assertEquals(-10, Average.average(negativeNumbers), "The average of -5, -10, -15 should be -10.");

        // Test with an array containing both positive and negative numbers
        int[] mixedNumbers = {-10, 0, 10};
        assertEquals(0, Average.average(mixedNumbers), "The average of -10, 0, 10 should be 0.");

        // Test with an empty array to check if the correct exception is thrown
        int[] emptyArray = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Average.average(emptyArray), "Expected IllegalArgumentException for empty array");
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());

        // Test with a null array to check if the correct exception is thrown
        int[] nullArray = null;
        exception = assertThrows(IllegalArgumentException.class, () -> Average.average(nullArray), "Expected IllegalArgumentException for null array");
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());
    }
}