package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {

    @Test
    public void calculateHammingDistanceTest() {
        // Test case 1: Strings of equal length with different characters
        try {
            int result = HammingDistance.calculateHammingDistance("karolin", "kathrin");
            assertEquals(3, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for equal length strings");
        }

        // Test case 2: Strings of equal length with same characters
        try {
            int result = HammingDistance.calculateHammingDistance("abc", "abc");
            assertEquals(0, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for equal length strings");
        }

        // Test case 3: Strings of different lengths
        assertThrows(Exception.class, () -> {
            HammingDistance.calculateHammingDistance("abcd", "abc");
        });

        // Test case 4: Another example of equal length strings
        try {
            int result = HammingDistance.calculateHammingDistance("1011101", "1001001");
            assertEquals(2, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for equal length strings");
        }
    }
}