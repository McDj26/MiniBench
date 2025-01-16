package com.thealgorithms.conversions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {
    @Test
    public void decimalToHexTest() {
        // Test case for zero input
        assertEquals("0", OctalToHexadecimal.decimalToHex(0));

        // Test case for a positive number
        assertEquals("A", OctalToHexadecimal.decimalToHex(10));
        assertEquals("FF", OctalToHexadecimal.decimalToHex(255));
        assertEquals("1A3F", OctalToHexadecimal.decimalToHex(6719));

        // Test case for numbers that convert to two digits
        assertEquals("10", OctalToHexadecimal.decimalToHex(16));
        assertEquals("7B", OctalToHexadecimal.decimalToHex(123));

        // Test case for a number that converts to a long hex number
        assertEquals("12345", OctalToHexadecimal.decimalToHex(74565));

        // Test negative number, should return "0" by the method's current logic
        assertEquals("0", OctalToHexadecimal.decimalToHex(-10));
    }
}