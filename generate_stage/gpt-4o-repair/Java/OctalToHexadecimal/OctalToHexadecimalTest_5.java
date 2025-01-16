package com.thealgorithms.conversions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {

    @Test
    public void decimalToHexTest() {
        // Test case 1: Zero decimal
        assertEquals("0", OctalToHexadecimal.decimalToHex(0));

        // Test case 2: Positive decimal number
        assertEquals("1A", OctalToHexadecimal.decimalToHex(26));

        // Test case 3: Another positive decimal number
        assertEquals("FF", OctalToHexadecimal.decimalToHex(255));

        // Test case 4: Large decimal number
        assertEquals("7FFFFFFF", OctalToHexadecimal.decimalToHex(2147483647));

        // Test case 5: Small positive decimal number
        assertEquals("8", OctalToHexadecimal.decimalToHex(8));

        // Test case 6: Negative number, should return "0" since the method is not designed for negatives
        assertEquals("0", OctalToHexadecimal.decimalToHex(-10));
    }
}