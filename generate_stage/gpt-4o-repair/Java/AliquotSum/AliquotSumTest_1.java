package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {

    @Test
    public void getAliquotSumTest() {
        // Test when n is a positive integer with known divisors
        assertEquals(8, AliquotSum.getAliquotSum(15)); // divisors: 1, 3, 5
        assertEquals(11, AliquotSum.getAliquotSum(20)); // divisors: 1, 2, 4, 5, 10

        // Test for perfect square
        assertEquals(15, AliquotSum.getAliquotSum(16)); // divisors: 1, 2, 4, 8

        // Test for n equals to 1
        assertEquals(1, AliquotSum.getAliquotSum(1));  // divisor: 1 itself

        // Test for prime number
        assertEquals(1, AliquotSum.getAliquotSum(17)); // divisor: 1 itself

        // Test when n is zero
        assertEquals(-1, AliquotSum.getAliquotSum(0));

        // Test for negative number, should return -1
        assertEquals(-1, AliquotSum.getAliquotSum(-10));
    }
}