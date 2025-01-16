package com.thealgorithms.strings;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {
    @Test
    public void calculateHammingDistanceTest() {
        // Test Case 1: Strings of equal length
        String s1 = "abcd";
        String s2 = "bcde";
        int expectedDistance = 1; // 'a' vs 'b' at position 0
        assertEquals(expectedDistance, HammingDistance.calculateHammingDistance(s1, s2));
        
        // Test Case 2: Strings of different lengths
        String s3 = "abc"; // Length 3
        String s4 = "abcd"; // Length 4
        assertThrows(Exception.class, () -> HammingDistance.calculateHammingDistance(s3, s4)); // Exception expected due to unequal lengths
        
        // Test Case 3: Strings with the same characters at all positions
        String s5 = "1234"; // Same as s6 below
        String s6 = "1234"; // Same as s5 above
        assertEquals(0, HammingDistance.calculateHammingDistance(s5, s6)); // Hamming distance should be zero for identical strings
        
        // Test Case 4: Strings with maximum Hamming distance
        String s7 = "123"; // Every character different from s8
        String s8 = "ABC"; // Every character different from s7
        assertEquals(3, HammingDistance.calculateHammingDistance(s7, s8)); // Every position is different
    }
}