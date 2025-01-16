package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {

    @Test
    public void isArmstrongTest() {
        Armstrong armstrong = new Armstrong();
        
        // Test with known Armstrong numbers
        assertTrue(armstrong.isArmstrong(153), "153 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(370), "370 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(371), "371 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(407), "407 is an Armstrong number");

        // Test with non-Armstrong numbers
        assertFalse(armstrong.isArmstrong(123), "123 is not an Armstrong number");
        assertFalse(armstrong.isArmstrong(100), "100 is not an Armstrong number");
        assertFalse(armstrong.isArmstrong(9474), "9474 is not an Armstrong number for 4 digits");

        // Test with a single-digit number (all are Armstrong numbers)
        assertTrue(armstrong.isArmstrong(5), "5 is an Armstrong number as it is a single-digit");
    }
}