package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {
    @Test
    public void isArmstrongTest() {
        Armstrong armstrong = new Armstrong();
        assertTrue(armstrong.isArmstrong(1)); // Test for Armstrong number 1
        assertTrue(armstrong.isArmstrong(947)); // Test for Armstrong number 947
        assertFalse(armstrong.isArmstrong(2)); // Test for non-Armstrong number 2
        assertFalse(armstrong.isArmstrong(9)); // Test for non-Armstrong number 9 that doesn't meet Armstrong criteria
    }
}