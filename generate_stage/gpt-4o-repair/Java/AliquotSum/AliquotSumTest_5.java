package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {

    @Test
    public void getAliquotSumTest() {
        // Test for a positive number - Normal case
        assertEquals(15, AliquotSum.getAliquotSum(28), "Aliquot sum of 28 should be 15");
        
        // Test for a perfect square
        assertEquals(13, AliquotSum.getAliquotSum(16), "Aliquot sum of 16 should be 15 - 4 + 4 = 13");

        // Test for a prime number (should return 1)
        assertEquals(1, AliquotSum.getAliquotSum(13), "Aliquot sum of a prime number like 13 should be 1");

        // Test for 1 (edge case)
        assertEquals(0, AliquotSum.getAliquotSum(1), "Aliquot sum of 1 should be 0");

        // Test for 0 (edge case)
        assertEquals(-1, AliquotSum.getAliquotSum(0), "Aliquot sum of 0 should be -1 as per the implementation");

        // Test for a negative number (edge case)
        assertEquals(-1, AliquotSum.getAliquotSum(-10), "Aliquot sum for a negative number should return -1");
    }
}