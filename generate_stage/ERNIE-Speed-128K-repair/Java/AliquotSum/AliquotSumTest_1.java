package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {
    @Test
    public void getAliquotSumTest() {
        int n = 1; // Test case for a positive integer
        int expectedSum = 2; // Expected aliquot sum for n = 1 is 2 (1 + 1)
        int actualSum = getAliquotSum(n); // Calculate actual aliquot sum using the method
        assertEquals(expectedSum, actualSum, "Aliquot sum for positive integer should match"); // Assert if actual sum matches the expected sum
        
        n = 2; // Test case for a perfect square number
        expectedSum = 5; // Expected aliquot sum for n = 2 is 5 (1 + 2 + 2/1)
        actualSum = getAliquotSum(n); // Calculate actual aliquot sum using the method
        assertEquals(expectedSum, actualSum, "Aliquot sum for perfect square should match"); // Assert if actual sum matches the expected sum for perfect square
        
        n = 8; // Test case for a number that is not a perfect square and has factors greater than its root
        expectedSum = 18; // Expected aliquot sum for n = 8 is 18 (1 + 2 + 4 + 8 + 8/2 + 8/4)
        actualSum = getAliquotSum(n); // Calculate actual aliquot sum using the method
        assertEquals(expectedSum, actualSum, "Aliquot sum for number with factors greater than root should match"); // Assert if actual sum matches the expected sum for this case
        
        n = negativeNumber; // Test case for negative number where method should return -1 as per the condition in the source code
        actualSum = getAliquotSum(n); // Calculate actual aliquot sum using the method for negative number
        assertEquals(-1, actualSum, "Aliquot sum for negative number should be -1"); // Assert if actual sum is -1 for negative number as expected by the method
    }
}