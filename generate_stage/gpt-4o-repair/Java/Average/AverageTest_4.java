package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {

    @Test
    public void averageTest() {
        // test case with positive numbers
        int[] positiveNumbers = {1, 2, 3, 4, 5};
        assertEquals(3, Average.average(positiveNumbers), "Average of 1, 2, 3, 4, 5 should be 3");

        // test case with negative numbers
        int[] negativeNumbers = {-1, -2, -3, -4, -5};
        assertEquals(-3, Average.average(negativeNumbers), "Average of -1, -2, -3, -4, -5 should be -3");

        // test case with a mix of positive and negative numbers
        int[] mixedNumbers = {-1, 0, 1};
        assertEquals(0, Average.average(mixedNumbers), "Average of -1, 0, 1 should be 0");

        // test case with a single element
        int[] singleElement = {10};
        assertEquals(10, Average.average(singleElement), "Average of single element 10 should be 10");

        // test case with maximum int values
        int[] maxIntValues = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertEquals(Integer.MAX_VALUE, Average.average(maxIntValues), "Average of max int values should be max int");

        // test case to expect IllegalArgumentException for null array
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Average.average(null);
        });
        assertEquals("Numbers array cannot be empty or null", exception.getMessage());

        // test case to expect IllegalArgumentException for empty array
        Exception exceptionEmpty = assertThrows(IllegalArgumentException.class, () -> {
            Average.average(new int[]{});
        });
        assertEquals("Numbers array cannot be empty or null", exceptionEmpty.getMessage());
    }
}