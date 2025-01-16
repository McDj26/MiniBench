package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {
    @Test
    public void isArmstrongTest() {
        // Test case for Armstrong number with 3 digits
        int number = 153; // This is an Armstrong number since 1^3 + 5^3 + 3^3 = 153
        assertTrue(new Armstrong().isArmstrong(number), "The number " + number + " should be an Armstrong number.");
        
        // Test case for non-Armstrong number with 3 digits
        number = 154; // This is not an Armstrong number since no combination of 1^3, 5^3 and 4^3 equals to 154
        assertFalse(new Armstrong().isArmstrong(number), "The number " + number + " should not be an Armstrong number.");
        
        // Test case for Armstrong number with more than 3 digits
        number = 1634; // This is an Armstrong number since 1^4 + 6^4 + 3^4 + 4^4 = 1634
        assertTrue(new Armstrong().isArmstrong(number), "The number " + number + " should be an Armstrong number.");
        
        // Test case for negative number (should return false)
        number = -123; // Negative numbers are not Armstrong numbers by definition
        assertFalse(new Armstrong().isArmstrong(number), "The negative number " + number + " should not be an Armstrong number.");
    }
}