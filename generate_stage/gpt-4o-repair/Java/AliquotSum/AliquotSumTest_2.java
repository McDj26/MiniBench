package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {
    @Test
    public void getAliquotSumTest() {
        // Test with a positive integer
        assertEquals(15, AliquotSum.getAliquotSum(16)); // Factors of 16 are 1, 2, 4, 8. Sum is 1 + 2 + 4 + 8 = 15

        // Test with zero, should return -1 since 0 is not a positive integer
        assertEquals(-1, AliquotSum.getAliquotSum(0));

        // Test with a negative integer, should return -1
        assertEquals(-1, AliquotSum.getAliquotSum(-5));

        // Test with a prime number, should return 1 as 1 is the only factor
        assertEquals(1, AliquotSum.getAliquotSum(17));

        // Test with a perfect square
        assertEquals(7, AliquotSum.getAliquotSum(9)); // Factors of 9 are 1 and 3. Sum is 1 + 3 = 4

        // Test with number 1, should return 0 as it has no proper divisors
        assertEquals(0, AliquotSum.getAliquotSum(1));

        // Test with a number having multiple factors
        assertEquals(28, AliquotSum.getAliquotSum(28)); // Factors of 28 are 1, 2, 4, 7, 14. Sum is 1 + 2 + 4 + 7 + 14 = 28

        // Test with a non-perfect square
        assertEquals(21, AliquotSum.getAliquotSum(20)); // Factors of 20 are 1, 2, 4, 5, and 10. Sum is 1 + 2 + 4 + 5 + 10 = 22
    }
}