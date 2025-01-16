package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {

    @Test
    public void isArmstrongTest() {
        Armstrong armstrong = new Armstrong();
        
        // Test with a known Armstrong number
        assertTrue(armstrong.isArmstrong(153), "153 should be an Armstrong number");
        
        // Test with another known Armstrong number
        assertTrue(armstrong.isArmstrong(370), "370 should be an Armstrong number");
        
        // Test with a non-Armstrong number
        assertFalse(armstrong.isArmstrong(123), "123 should not be an Armstrong number");
        
        // Test edge case with a single digit number (all single digits are Armstrong numbers)
        assertTrue(armstrong.isArmstrong(5), "5 should be an Armstrong number");
        
        // Test with a large Armstrong number
        assertTrue(armstrong.isArmstrong(9474), "9474 should be an Armstrong number");
        
        // Test with a large non-Armstrong number
        assertFalse(armstrong.isArmstrong(9475), "9475 should not be an Armstrong number");
    }
}