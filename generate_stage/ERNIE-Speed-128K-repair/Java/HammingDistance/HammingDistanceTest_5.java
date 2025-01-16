package com.thealgorithms.strings;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {
    @Test
    public void calculateHammingDistanceTest() {
        // Test case for equal length strings
        String s1 = "hello";
        String s2 = "heylo"; // only one character difference from s1
        int expectedDistance = 1; // expected hamming distance
        try {
            int actualDistance = HammingDistance.calculateHammingDistance(s1, s2);
            assertEquals(expectedDistance, actualDistance, "Hamming distance is not correct for equal length strings.");
        } catch (Exception e) {
            fail("Should not throw exception for equal length strings.");
        }
        
        // Test case for unequal length strings
        String s3 = "hello";
        String s4 = "hey"; // one character shorter than s3
        Exception exception = assertThrows(Exception.class, () -> {
            HammingDistance.calculateHammingDistance(s3, s4);
        });
        assertEquals("String lengths must be equal", exception.getMessage()); // exception message should match the expected message
        
        // Additional test case for empty strings
        String s5 = "";
        String s6 = ""; // both empty strings should have a hamming distance of 0
        try {
            int distanceForEmptyStrings = HammingDistance.calculateHammingDistance(s5, s6);
            assertEquals(0, distanceForEmptyStrings, "Hamming distance should be 0 for empty strings.");
        } catch (Exception e) {
            fail("Should not throw exception for empty strings.");
        }
    }
}