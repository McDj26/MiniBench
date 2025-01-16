package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsoluteMaxTest {
    @Test
    public void getMaxValueTest() {
        // Test case for null input
        assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue(null));
        assertThrows(IllegalArgumentException.class, () -> AbsoluteMax.getMaxValue()); // Empty array
        
        // Test case with positive numbers
        int[] positiveNumbers = {1, 2, 3, 4, 5};
        assertEquals(5, AbsoluteMax.getMaxValue(positiveNumbers)); // The maximum positive number is 5
        assertEquals(5, AbsoluteMax.getMaxValue(positiveNumbers[2], positiveNumbers[4])); // Using the same two numbers
        assertEquals(positiveNumbers[4], AbsoluteMax.getMaxValue(positiveNumbers)); // Verify that it returns an array element when abs max is equal to array element itself
        
        // Test case with negative numbers
        int[] negativeNumbers = {-1, -2, -3, -4, -5};
        assertEquals(-1, AbsoluteMax.getMaxValue(negativeNumbers)); // The absolute maximum value is -1 among the negative numbers even though -5 is a bigger number but its absolute value is smaller
        assertEquals(-1, AbsoluteMax.getMaxValue(-negativeNumbers[3])); // Testing a single negative number
        assertEquals(-negativeNumbers[0], AbsoluteMax.getMaxValue(-negativeNumbers)); // Same as previous case with verifying array element itself as the result
        
        // Test case with both positive and negative numbers
        int[] mixedNumbers = {-2, 4, -3, 9, -1}; // An example with both positive and negative numbers with an absolute max value of 9 in this case
        assertEquals(9, AbsoluteMax.getMaxValue(mixedNumbers)); // The absolute maximum value among the mixed numbers is 9
        assertEquals(mixedNumbers[3], AbsoluteMax.getMaxValue(mixedNumbers)); // Verify that it returns an array element when abs max is equal to array element itself (in this case it's the third element)
    }
}