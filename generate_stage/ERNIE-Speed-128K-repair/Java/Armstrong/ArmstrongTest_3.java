package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {
    @Test
    public void isArmstrongTest() {
        // Test case for Armstrong number with a three-digit number
        int number = 153; // This is an Armstrong number because 1^3 + 5^3 + 3^3 = 153
        Armstrong armstrong = new Armstrong();
        assertTrue(armstrong.isArmstrong(number), "The number should be an Armstrong number.");
        
        // Test case for a non-Armstrong number with a four-digit number
        number = 1024; // This is not an Armstrong number because 1^4 + 0^4 + 2^4 + 4^4 is not equal to 1024
        assertFalse(armstrong.isArmstrong(number), "The number should not be an Armstrong number.");
        
        // Test case for a negative number
        number = -1; // Negative numbers are not Armstrong numbers by definition
        assertThrows(IllegalArgumentException.class, () -> armstrong.isArmstrong(number), "Should throw IllegalArgumentException for negative numbers.");
        
        // Test case for a zero
        number = 0; // Zero is not an Armstrong number as well since the power of any digit of zero is zero and it should be only checked with the power of its digits count
        assertFalse(armstrong.isArmstrong(number), "Zero should not be considered as an Armstrong number.");
    }
}