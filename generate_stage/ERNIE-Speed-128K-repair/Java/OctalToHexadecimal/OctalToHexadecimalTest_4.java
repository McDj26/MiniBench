package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {
    @Test
    public void decimalToHexTest() {
        // Test case for decimalToHex method
        int decimalNumber = 255; // Test with a value that will result in FF in hexadecimal
        String expectedHex = "FF"; // Expected hexadecimal representation of the decimal number
        String actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation obtained from the method
        assertEquals(expectedHex, actualHex, "The hexadecimal representation is incorrect."); // Assert if the actual hexadecimal matches the expected one
    }
    
    // Additional test cases for edge cases and various inputs can be added here
    @Test
    public void decimalToHexNegativeNumberTest() {
        int decimalNumber = -1; // Test with a negative number
        String expectedHex = "0"; // Expected hexadecimal representation for negative numbers should be 0 as per the Java documentation
        String actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation obtained from the method
        assertEquals(expectedHex, actualHex, "The hexadecimal representation of a negative number is incorrect."); // Assert if the actual hexadecimal matches the expected one for negative numbers
    }
    
    @Test
    public void decimalToHexZeroTest() {
        int decimalNumber = 0; // Test with zero
        String expectedHex = "0"; // Expected hexadecimal representation of zero should be '0'
        String actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation obtained from the method
        assertEquals(expectedHex, actualHex, "The hexadecimal representation of zero is incorrect."); // Assert if the actual hexadecimal matches the expected one for zero input
    }
}