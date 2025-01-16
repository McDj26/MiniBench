package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {

    @Test
    public void calculateHammingDistanceTest() {
        try {
            assertEquals(3, HammingDistance.calculateHammingDistance("10110", "10001"), 
                "Hamming distance between '10110' and '10001' should be 3");
            assertEquals(0, HammingDistance.calculateHammingDistance("abcde", "abcde"), 
                "Hamming distance between two identical strings should be 0");
            assertEquals(1, HammingDistance.calculateHammingDistance("abcd", "abcf"), 
                "Hamming distance between 'abcd' and 'abcf' should be 1");
        } catch (Exception e) {
            fail("Exception should not have been thrown.");
        }
    }

    @Test
    public void calculateHammingDistanceDifferentLengthsTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            HammingDistance.calculateHammingDistance("101", "1001");
        }, "Expected exception for strings of different lengths");
        assertEquals("String lengths must be equal", exception.getMessage());
    }
}