package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {

    @Test
    public void isArmstrongTest() {
        Armstrong armstrong = new Armstrong();
        
        // Test cases for Armstrong numbers
        assertTrue(armstrong.isArmstrong(0), "0 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(1), "1 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(153), "153 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(370), "370 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(371), "371 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(407), "407 is an Armstrong number");
        
        // Test cases for non-Armstrong numbers
        assertFalse(armstrong.isArmstrong(10), "10 is not an Armstrong number");
        assertFalse(armstrong.isArmstrong(123), "123 is not an Armstrong number");
        assertFalse(armstrong.isArmstrong(200), "200 is not an Armstrong number");
        assertFalse(armstrong.isArmstrong(9474), "9474 is not an Armstrong number (it is 4 digit Armstrong number, included for verification)");
    }
}