package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {
    @Test
    public void decimalToHexTest() {
        // Arrange
        int decimalNumber = 255; // Test case for decimal number ending in 15 (FF in hex)
        String expectedHex = "FF"; // Expected hexadecimal representation of the decimal number
        String actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation of the decimal number
        
        // Act & Assert
        assertNotNull(actualHex); // Ensure that the actual hexadecimal is not null
        assertEquals(expectedHex, actualHex); // Assert that the actual hexadecimal matches the expected hexadecimal representation of the decimal number
    }
    
    // Additional test cases to cover all possible scenarios
    @Test
    public void decimalToHexTestNegativeNumber() {
        int decimalNumber = -1; // Test case for negative decimal number
        String expectedHex = "0"; // Expected hexadecimal representation of negative number should be zero as per the Java specification
        String actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation of the negative decimal number
        assertEquals(expectedHex, actualHex); // Assert that the actual hexadecimal matches the expected result for negative numbers
    }
    
    @Test
    public void decimalToHexTestZero() {
        int decimalNumber = 0; // Test case for zero decimal number
        String expectedHex = "0"; // Expected hexadecimal representation of zero is itself zero
        String actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation of zero decimal number
        assertEquals(expectedHex, actualHex); // Assert that the actual hexadecimal matches the expected result for zero
    }
}