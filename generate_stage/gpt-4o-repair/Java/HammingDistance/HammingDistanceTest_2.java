package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HammingDistanceTest {
    
    @Test
    public void calculateHammingDistanceTest() {
        try {
            // Test case 1: Strings of equal length with no differences
            assertEquals(0, HammingDistance.calculateHammingDistance("test", "test"));
            
            // Test case 2: Strings of equal length with differences
            assertEquals(3, HammingDistance.calculateHammingDistance("1011101", "1001001"));
            
            // Test case 3: Another case with differences
            assertEquals(1, HammingDistance.calculateHammingDistance("karolin", "kathrin"));
            
            // Test case 4: Strings of equal length with all differences
            assertEquals(5, HammingDistance.calculateHammingDistance("apple", "bcdef"));
            
            // Test case 5: Throws exception on unequal length
            Exception exception = assertThrows(Exception.class, () -> {
                HammingDistance.calculateHammingDistance("hello", "worldd");
            });
            assertEquals("String lengths must be equal", exception.getMessage());
            
        } catch (Exception e) {
            fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}