package com.thealgorithms.strings;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {
    @Test
    public void calculateHammingDistanceTest() {
        // Test case for equal length strings
        String s1 = "hello";
        String s2 = "hallo"; // Only one character difference, expected Hamming distance is 1
        int expectedDistance = 1;
        try {
            int actualDistance = HammingDistance.calculateHammingDistance(s1, s2);
            assertEquals(expectedDistance, actualDistance, "Hamming distance is not correct for equal length strings.");
        } catch (Exception e) {
            fail("Should not throw an exception for equal length strings.");
        }
        
        // Test case for unequal length strings
        String unequalLengthS1 = "hello";
        String unequalLengthS2 = "hello world"; // Lengths are not equal, should throw an exception
        Exception exception = assertThrows(Exception.class, () -> {
            HammingDistance.calculateHammingDistance(unequalLengthS1, unequalLengthS2);
        });
        assertEquals("String lengths must be equal", exception.getMessage()); // Check the exception message is correct
    }
}