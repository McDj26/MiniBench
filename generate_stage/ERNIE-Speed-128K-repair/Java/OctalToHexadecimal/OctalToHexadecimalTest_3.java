package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {
    @Test
    public void decimalToHexTest() {
        // Test cases for decimalToHex method
        int decimalNumber = 255; // Test case for decimal number up to 255
        String expectedHex = "FF"; // Expected hexadecimal representation of 255 is FF
        String actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Method call to convert decimal to hex
        assertEquals(expectedHex, actualHex, "Conversion of decimal number 255 to hexadecimal failed"); // Assert if the conversion is correct
        
        decimalNumber = 0; // Test case for zero decimal number
        expectedHex = "0"; // Expected hexadecimal representation of zero is 0
        actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Method call to convert decimal to hex
        assertEquals(expectedHex, actualHex, "Conversion of decimal number 0 to hexadecimal failed"); // Assert if the conversion is correct for zero case
        
        decimalNumber = -1; // Test case for negative decimal number
        try {
            actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Method call to convert decimal to hex
            fail("Method should throw an IllegalArgumentException for negative numbers"); // Expect an IllegalArgumentException for negative numbers
        } catch (IllegalArgumentException e) {
            // Exception is caught as expected for negative input numbers
        }
    }
}