package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {
    @Test
    public void convertToAnyBaseTest() {
        // Test case for converting decimal to binary base
        int decimalNumber = 10; // Decimal input
        int base = 2; // Binary base
        String expectedResult = "1010"; // Expected result in binary base format
        String actualResult = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedResult, actualResult, "Decimal to Binary conversion failed");
        
        // Test case for converting decimal to octal base
        decimalNumber = 34; // Decimal input
        base = 8; // Octal base
        expectedResult = "42"; // Expected result in octal base format
        actualResult = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedResult, actualResult, "Decimal to Octal conversion failed");
        
        // Test case for converting decimal to hexadecimal base
        decimalNumber = 255; // Decimal input for hexadecimal representation of byte values
        base = 16; // Hexadecimal base
        expectedResult = "FF"; // Expected result in hexadecimal base format
        actualResult = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedResult, actualResult, "Decimal to Hexadecimal conversion failed");
        
        // Test case with negative input values for decimal and base
        decimalNumber = -5; // Negative decimal input
        base = -2; // Negative base input (should be handled as invalid)
        assertThrows(IllegalArgumentException.class, () -> DecimalToAnyBase.convertToAnyBase(decimalNumber, base), "Should throw IllegalArgumentException for negative base");
    }
}