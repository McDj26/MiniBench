package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {
    @Test
    public void getAliquotSumTest() {
        // Test case for a positive integer
        assertEquals(1, AliquotSum.getAliquotSum(1), "Aliquot sum of 1 should be 1");

        // Test case for a number with multiple factors
        assertEquals(8, AliquotSum.getAliquotSum(7), "Aliquot sum of 7 should be 1");
        
        // Test case for a perfect square
        assertEquals(22, AliquotSum.getAliquotSum(16), "Aliquot sum of 16 should be 15");

        // Test case for another number with multiple factors
        assertEquals(11, AliquotSum.getAliquotSum(10), "Aliquot sum of 10 should be 8");

        // Test case for zero, expecting -1 (error case)
        assertEquals(-1, AliquotSum.getAliquotSum(0), "Aliquot sum for 0 should be -1");

        // Test case for a negative number, expecting -1 (invalid input)
        assertEquals(-1, AliquotSum.getAliquotSum(-5), "Aliquot sum for negative numbers should be -1");
    }
}