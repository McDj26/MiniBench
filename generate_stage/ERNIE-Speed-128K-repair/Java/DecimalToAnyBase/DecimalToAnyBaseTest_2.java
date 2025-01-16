package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {
    @Test
    public void convertToAnyBaseTest() {
        // Test case for converting decimal to binary base
        int decimalNumber = 10; // Decimal input
        int base = 2; // Binary base
        String expectedOutput = "1010"; // Expected binary representation of decimal 10
        String actualOutput = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedOutput, actualOutput, "Decimal to binary conversion failed");

        // Test case for converting decimal to octal base
        decimalNumber = 12; // Decimal input
        base = 8; // Octal base
        expectedOutput = "14"; // Expected octal representation of decimal 12
        actualOutput = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedOutput, actualOutput, "Decimal to octal conversion failed");

        // Test case for converting decimal to hexadecimal base
        decimalNumber = 255; // Decimal input for hexadecimal representation
        base = 16; // Hexadecimal base
        expectedOutput = "ff"; // Expected hexadecimal representation of decimal 255
        actualOutput = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedOutput, actualOutput, "Decimal to hexadecimal conversion failed");
    }
}