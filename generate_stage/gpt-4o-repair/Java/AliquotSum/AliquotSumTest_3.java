package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {
    
    @Test
    public void getAliquotSumTest() {
        // Test with a positive integer having aliquot sum
        assertEquals(15, AliquotSum.getAliquotSum(16)); // Factors are 1, 2, 4, 8
        
        // Test with a perfect number
        assertEquals(28, AliquotSum.getAliquotSum(28)); // Factors are 1, 2, 4, 7, 14
        
        // Test with a smaller number
        assertEquals(1, AliquotSum.getAliquotSum(2)); // Factors are 1
        
        // Test with number 1, which should have an aliquot sum of 0
        assertEquals(0, AliquotSum.getAliquotSum(1)); // No factors other than 1 itself
        
        // Test with 0 which is an edge case
        assertEquals(-1, AliquotSum.getAliquotSum(0)); // Invalid input, expected return -1
        
        // Test with a negative number which is invalid
        assertEquals(-1, AliquotSum.getAliquotSum(-5)); // Invalid input, expected return -1

        // Test with a perfect square
        assertEquals(1 + 2 + 4, AliquotSum.getAliquotSum(4)); // Factors are 1, 2
    }
}