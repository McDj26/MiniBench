package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {
    @Test
    public void isArmstrongTest() {
        Armstrong armstrong = new Armstrong();
        
        // Test cases for Armstrong numbers
        assertTrue(armstrong.isArmstrong(153), "153 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(370), "370 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(371), "371 is an Armstrong number");
        assertTrue(armstrong.isArmstrong(407), "407 is an Armstrong number");
        
        // Test cases for non-Armstrong numbers
        assertFalse(armstrong.isArmstrong(123), "123 is not an Armstrong number");
        assertFalse(armstrong.isArmstrong(250), "250 is not an Armstrong number");
        assertFalse(armstrong.isArmstrong(111), "111 is not an Armstrong number");
        assertFalse(armstrong.isArmstrong(500), "500 is not an Armstrong number");
    }
}