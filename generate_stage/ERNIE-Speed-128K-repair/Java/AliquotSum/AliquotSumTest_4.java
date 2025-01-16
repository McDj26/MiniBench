package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {
    @Test
    public void getAliquotSumTest() {
        // Test for small positive integer
        assertEquals(6, AliquotSum.getAliquotSum(6)); // 1 + 2 + 3 + 6 / 2 + 6 / 3 = 6
        assertEquals(1, AliquotSum.getAliquotSum(1)); // 1 is a perfect square so only addition of 1 is done
        assertEquals(-1, AliquotSum.getAliquotSum(0)); // Input is less than or equal to zero so return -1
        assertEquals(-1, AliquotSum.getAliquotSum(-1)); // Input is less than zero so return -1
        assertEquals(-1, AliquotSum.getAliquotSum(-5)); // Input is negative so return -1 as per code implementation
        assertEquals(9, AliquotSum.getAliquotSum(9)); // Factors of 9 are 1, 3 and itself which makes the sum as 9 + 3 + 3 = 9
        assertEquals(8, AliquotSum.getAliquotSum(8)); // Factors of 8 are 1, 2, 4 and itself which makes the sum as 8 + 4 + 2 = 8 + itself = 16 which is correct as per the logic in the code comment
        assertEquals(9, AliquotSum.getAliquotSum(9)); // <FILL> case where n is a perfect square
        assertEquals(AliquotSum.getAliquotSum(int value), expectedValue); // <FILL> test for other cases to cover all scenarios
    }
}