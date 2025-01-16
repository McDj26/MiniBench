package com.thealgorithms.strings;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {
    @Test
    public void calculateHammingDistanceTest() {
        // Test case for equal length strings
        String s1 = "hello";
        String s2 = "world";
        assertEquals(HammingDistance.calculateHammingDistance(s1, s2), 3); // Expected distance between 'h' and 'w', 'e' and 'o', 'l' and 'r' is 3
        
        // Test case for unequal length strings
        assertThrows(Exception.class, () -> HammingDistance.calculateHammingDistance("hello", "hello world")); // Exception should be thrown for unequal length strings
        
        // Test case with zero distance (identical strings)
        String s3 = "identical";
        String s4 = "identical";
        assertEquals(HammingDistance.calculateHammingDistance(s3, s4), 0); // Strings are identical, hence distance is zero
    }
}