package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {
    @Test
    public void getAliquotSumTest() {
        int n = 1; // Test case for the number 1
        int expectedSum = 2; // Expected aliquot sum for number 1 is 2 (since 1 + 1 = 2)
        assertEquals(expectedSum, AliquotSum.getAliquotSum(n), "The aliquot sum of 1 should be 2.");
        
        n = 2; // Test case for the number 2
        expectedSum = 3; // Expected aliquot sum for number 2 is 3 (since we have factors 1 and itself, so 1 + 2 = 3)
        assertEquals(expectedSum, AliquotSum.getAliquotSum(n), "The aliquot sum of 2 should be 3.");
        
        n = 6; // Test case for a number with factors both before and after its square root
        expectedSum = 8; // Expected aliquot sum for number 6 is 8 (since factors are 1, 2, 3 and 6. So, sum of these factors is 8)
        assertEquals(expectedSum, AliquotSum.getAliquotSum(n), "The aliquot sum of 6 should be 8.");
        
        n = 9; // Test case for a perfect square number
        expectedSum = 9 + 9/3; // Expected aliquot sum for number 9 is the sum of its factors which are [1,3] and [9/3=3]
        assertEquals(expectedSum, AliquotSum.getAliquotSum(n), "The aliquot sum of a perfect square should exclude the square root.");
        
        n = 100; // Test case for a number with factors both before and after its square root, including factors after the root as well
        expectedSum = (int) (Math.sqrt(n)) + (n / (int) Math.sqrt(n)) + (int) Math.sqrt(n); // Sum of factors after root [10, 50, etc.]
        assertEquals(expectedSum, AliquotSum.getAliquotSum(n), "The aliquot sum of a large number should be calculated correctly.");
        
        // Test case for negative input
        n = -5; // Testing negative input
        assertNotEquals(-1, AliquotSum.getAliquotSum(n), "The function should return -1 only for positive inputs.");
    }
}