package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {
    @Test
    public void getAliquotSumTest() {
        // Test case for getAliquotSum method
        int number = 1; // Test number for aliquot sum calculation
        int expectedSum = 1; // Expected aliquot sum for the given number
        assertEquals(expectedSum, AliquotSum.getAliquotSum(number), "Aliquot sum calculation failed for number " + number);
        
        number = 2; // Test number for aliquot sum calculation
        expectedSum = 3; // Expected aliquot sum for the given number (2 + 2/1)
        assertEquals(expectedSum, AliquotSum.getAliquotSum(number), "Aliquot sum calculation failed for number " + number);
        
        number = 9; // Test number for aliquot sum calculation
        expectedSum = 7; // Expected aliquot sum for the given number (9 + 9/3)
        assertEquals(expectedSum, AliquotSum.getAliquotSum(number), "Aliquot sum calculation failed for number " + number);
        
        number = 24; // Test number for aliquot sum calculation
        expectedSum = 28; // Expected aliquot sum for the given number (24 + 24/4) since it is a perfect square and we subtract root from the sum of divisors, here the root is not a part of divisors.
        assertEquals(expectedSum, AliquotSum.getAliquotSum(number), "Aliquot sum calculation failed for number " + number);
        
        number = 36; // Test number for aliquot sum calculation
        expectedSum = 66; // Expected aliquot sum for the given number, including divisors after root: 36 + 36/6 + 36/9 + 36/2 = 66
        assertEquals(expectedSum, AliquotSum.getAliquotSum(number), "Aliquot sum calculation failed for number " + number);
    }
}