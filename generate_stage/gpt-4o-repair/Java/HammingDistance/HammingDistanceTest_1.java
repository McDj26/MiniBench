package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {

    @Test
    public void calculateHammingDistanceTest() {
        try {
            assertEquals(0, HammingDistance.calculateHammingDistance("abc", "abc"));
            assertEquals(1, HammingDistance.calculateHammingDistance("abc", "adc"));
            assertEquals(2, HammingDistance.calculateHammingDistance("101", "111"));
            assertEquals(3, HammingDistance.calculateHammingDistance("karolin", "kathrin"));
        } catch (Exception e) {
            fail("Exception should not be thrown for equal length strings");
        }

        Exception exception = assertThrows(Exception.class, () -> {
            HammingDistance.calculateHammingDistance("abc", "ab");
        });
        assertEquals("String lengths must be equal", exception.getMessage());
    }
}