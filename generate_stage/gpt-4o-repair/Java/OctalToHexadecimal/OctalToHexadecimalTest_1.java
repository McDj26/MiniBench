package com.thealgorithms.conversions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {

    @Test
    public void decimalToHexTest() {
        // Test case 1: Testing conversion of 0
        assertEquals("0", OctalToHexadecimal.decimalToHex(0));

        // Test case 2: Testing conversion of a positive decimal number
        assertEquals("1A", OctalToHexadecimal.decimalToHex(26));

        // Test case 3: Testing conversion of another positive decimal number
        assertEquals("FF", OctalToHexadecimal.decimalToHex(255));

        // Test case 4: Testing conversion of a small positive decimal number
        assertEquals("7", OctalToHexadecimal.decimalToHex(7));

        // Test case 5: Testing conversion of yet another positive decimal number
        assertEquals("100", OctalToHexadecimal.decimalToHex(256));

        // Test case 6: Testing conversion of a large decimal number
        assertEquals("2F6A", OctalToHexadecimal.decimalToHex(12138));

        // Test case 7: Testing conversion of the minimum valid positive integer
        assertEquals("1", OctalToHexadecimal.decimalToHex(1));

        // Test case 8: Testing conversion of a negative decimal number
        assertEquals("0", OctalToHexadecimal.decimalToHex(-10)); // As negative value is not handled and should return "0"
    }
}