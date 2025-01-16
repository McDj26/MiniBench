package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {
    
    @Test
    public void calculateHammingDistanceTest() {
        try {
            // Test case 1: Equal strings
            String s1 = "10101";
            String s2 = "10101";
            int result = HammingDistance.calculateHammingDistance(s1, s2);
            assertEquals(0, result, "Hamming distance should be 0 for identical strings");

            // Test case 2: One character different
            s1 = "10101";
            s2 = "10001";
            result = HammingDistance.calculateHammingDistance(s1, s2);
            assertEquals(1, result, "Hamming distance should be 1 for one character difference");

            // Test case 3: All characters different
            s1 = "11111";
            s2 = "00000";
            result = HammingDistance.calculateHammingDistance(s1, s2);
            assertEquals(5, result, "Hamming distance should be 5 for all characters different");

            // Test case 4: Two characters different
            s1 = "11000";
            s2 = "10011";
            result = HammingDistance.calculateHammingDistance(s1, s2);
            assertEquals(3, result, "Hamming distance should be 3 for two characters different");

        } catch (Exception e) {
            fail("Exception should not be thrown for valid input");
        }
    }
    
    @Test
    public void calculateHammingDistanceTestWithException() {
        // Test case 5: Strings of different lengths
        assertThrows(Exception.class, () -> {
            HammingDistance.calculateHammingDistance("101", "1010");
        }, "Exception should be thrown for strings of unequal length");
    }
}