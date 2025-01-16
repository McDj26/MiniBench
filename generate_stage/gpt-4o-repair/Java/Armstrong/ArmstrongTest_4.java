package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {
    @Test
    public void isArmstrongTest() {
        Armstrong armstrong = new Armstrong();

        // Test with a 3-digit Armstrong number
        assertTrue(armstrong.isArmstrong(153), "153 is an Armstrong number");

        // Test with another 3-digit Armstrong number
        assertTrue(armstrong.isArmstrong(370), "370 is an Armstrong number");

        // Test with a 4-digit Armstrong number
        assertTrue(armstrong.isArmstrong(9474), "9474 is an Armstrong number");

        // Test with a non-Armstrong number
        assertFalse(armstrong.isArmstrong(123), "123 is not an Armstrong number");

        // Test with another non-Armstrong number
        assertFalse(armstrong.isArmstrong(100), "100 is not an Armstrong number");

        // Edge case: Test with zero
        assertTrue(armstrong.isArmstrong(0), "0 is considered an Armstrong number");

        // Edge case: Test with a single digit number
        assertTrue(armstrong.isArmstrong(5), "Single digit numbers are considered Armstrong numbers");
    }
}