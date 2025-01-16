package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {
    @Test
    public void isArmstrongTest() {
        Armstrong armstrong = new Armstrong();
        
        // Test case for Armstrong number with 3 digits
        assertTrue(armstrong.isArmstrong(165)); // 1^3 + 6^3 + 5^3 = 153, so it should return true for Armstrong number 165
        
        // Test case for non-Armstrong number with 3 digits
        assertFalse(armstrong.isArmstrong(405)); // 4^3 + 0^3 + 5^3 is not equal to 405, so it should return false for non-Armstrong number 405
        
        // Test case for Armstrong number with more than 3 digits
        assertTrue(armstrong.isArmstrong(37158)); // Check if the number is an Armstrong number for a case with more than 3 digits
        
        // Test case for a single-digit number (should still be considered as an Armstrong number)
        assertTrue(armstrong.isArmstrong(4)); // 4^1 = 4, so it should return true for a single-digit number
        
        // Test case for negative numbers (should not be considered as Armstrong numbers)
        assertFalse(armstrong.isArmstrong(-1)); // Armstrength numbers are non-negative by definition, so it should return false for negative numbers
    }
}