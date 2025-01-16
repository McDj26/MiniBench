package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {
    @Test
    public void isArmstrongTest() {
        // Test case for Armstrong number with 3 digits
        int number = 153; // 1^3 + 5^3 + 3^3 = 153, hence an Armstrong number
        assertTrue(new Armstrong().isArmstrong(number), "The number " + number + " should be an Armstrong number.");
        
        // Test case for non-Armstrong number with 3 digits
        number = 124; // Not an Armstrong number as 1^3 + 2^3 != 4^3
        assertFalse(new Armstrong().isArmstrong(number), "The number " + number + " should not be an Armstrong number.");
        
        // Test case for Armstrong number with more than 3 digits
        number = 4074; // 4^4 + 0^4 + 7^4 + 4^4 = 4074, hence an Armstrong number
        assertTrue(new Armstrong().isArmstrong(number), "The number " + number + " should be an Armstrong number.");
        
        // Test case for negative numbers (should return false as Armstrong numbers are positive)
        number = -1; // Not an Armstrong number as it is negative
        assertFalse(new Armstrong().isArmstrong(number), "The number " + number + " should not be an Armstrong number.");
        
        // Test case for zero (should return false as zero is not an Armstrong number)
        number = 0; // Not an Armstrong number as the sum of the cube of its digits is not equal to the original number
        assertFalse(new Armstrong().isArmstrong(number), "The number " + number + " should not be an Armstrong number.");
    }
}