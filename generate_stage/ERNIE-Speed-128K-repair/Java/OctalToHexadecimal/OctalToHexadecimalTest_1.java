package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {
    @Test
    public void decimalToHexTest() {
        // Test cases for decimalToHex method
        int decimalNumber = 255; // Test case for decimal number up to 16^2
        String expectedHex = "FF"; // Expected hexadecimal representation of 255 is FF
        String actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation
        assertEquals(expectedHex, actualHex, "Decimal number should convert to hexadecimal correctly."); // Asserting if the actual hex matches the expected hex
        
        decimalNumber = 0; // Test case for zero input
        expectedHex = "0"; // Expected hexadecimal representation of zero is '0'
        actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation
        assertEquals(expectedHex, actualHex, "Decimal number zero should convert to hexadecimal '0'."); // Asserting the output for zero input case
        
        decimalNumber = -1; // Test case for negative input
        try {
            actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Attempt to get hexadecimal representation of negative number
            fail("Should throw an IllegalArgumentException for negative input."); // Expecting an exception for negative input
        } catch (IllegalArgumentException e) {
            // Expected exception for negative input
        } catch (Exception e) {
            fail("Expected IllegalArgumentException for negative input but got another exception."); // Fail if any other exception is caught
        }
    }
}