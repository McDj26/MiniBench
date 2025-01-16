package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {

    @Test
    public void decimalToHexTest() {
        // Test conversion of zero
        assertEquals("0", OctalToHexadecimal.decimalToHex(0), "Conversion of 0 is incorrect.");

        // Test conversion of a single-digit decimal
        assertEquals("A", OctalToHexadecimal.decimalToHex(10), "Conversion of 10 is incorrect.");
        assertEquals("F", OctalToHexadecimal.decimalToHex(15), "Conversion of 15 is incorrect.");
        
        // Test conversion of a double-digit decimal
        assertEquals("10", OctalToHexadecimal.decimalToHex(16), "Conversion of 16 is incorrect.");
        assertEquals("1A", OctalToHexadecimal.decimalToHex(26), "Conversion of 26 is incorrect.");

        // Test conversion of a larger decimal
        assertEquals("100", OctalToHexadecimal.decimalToHex(256), "Conversion of 256 is incorrect.");
        assertEquals("1F4", OctalToHexadecimal.decimalToHex(500), "Conversion of 500 is incorrect.");
        
        // Edge test for maximum integer value
        assertEquals("7FFFFFFF", OctalToHexadecimal.decimalToHex(2147483647), "Conversion of 2147483647 is incorrect.");
    }
}