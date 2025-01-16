package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {
    @Test
    public void convertToAnyBaseTest() {
        // Test for base 2
        int decimalNumber = 10;
        int base = 2;
        String expectedOutput = "1010"; // Binary representation of 10
        String actualOutput = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedOutput, actualOutput, "Failed to convert decimal to base 2");

        // Test for base 8
        decimalNumber = 35; // Decimal representation of binary number '100011' which is octal '43'
        base = 8;
        expectedOutput = "43"; // Octal representation of 35
        actualOutput = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedOutput, actualOutput, "Failed to convert decimal to base 8");

        // Test for base 16
        decimalNumber = 255; // Decimal representation of hex 'FF' (Maximum value for an 8-bit unsigned byte)
        base = 16; // Hexadecimal base
        expectedOutput = "FF"; // Hexadecimal representation of 255
        actualOutput = DecimalToAnyBase.convertToAnyBase(decimalNumber, base);
        assertEquals(expectedOutput, actualOutput, "Failed to convert decimal to base 16");
    }
}