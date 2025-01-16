package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindMaxTest {

    @Test
    public void findMaxTest() {
        // Test case 1: Normal case with positive integers
        int[] array1 = {1, 3, 5, 7, 9};
        assertEquals(9, FindMax.findMax(array1), "The max value should be 9.");

        // Test case 2: Including negative numbers
        int[] array2 = {-2, -7, -3, -8, -1};
        assertEquals(-1, FindMax.findMax(array2), "The max value should be -1.");

        // Test case 3: Array with one element
        int[] array3 = {42};
        assertEquals(42, FindMax.findMax(array3), "The max value should be 42.");

        // Test case 4: Array with duplicate maximum values
        int[] array4 = {5, 7, 7, 3, 7};
        assertEquals(7, FindMax.findMax(array4), "The max value should be 7.");

        // Test case 5: Mixed positive and negative integers
        int[] array5 = {3, -2, 7, -8, 5};
        assertEquals(7, FindMax.findMax(array5), "The max value should be 7.");
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FindMax.findMax(emptyArray);
        });

        String expectedMessage = "Array must be non-empty.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should be 'Array must be non-empty.'");
    }
}