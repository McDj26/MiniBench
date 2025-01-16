package com.thealgorithms.strings;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {
    @Test
    public void calculateHammingDistanceTest() {
        // Test case for equal length strings
        String s1 = "abcd";
        String s2 = "abce"; // Different at the last character
        int expectedDistance = 1; // One character difference
        try {
            int actualDistance = HammingDistance.calculateHammingDistance(s1, s2);
            assertEquals(expectedDistance, actualDistance, "Hamming distance is not calculated correctly.");
        } catch (Exception e) {
            fail("Should not throw an exception for equal length strings.");
        }
        
        // Test case for unequal length strings
        String unequalLengthS1 = "abc"; // Length is 3
        String unequalLengthS2 = "abcd"; // Length is 4, should throw an exception
        assertThrows(Exception.class, () -> HammingDistance.calculateHammingDistance(unequalLengthS1, unequalLengthS2), "Should throw an exception for unequal length strings.");
    }
}