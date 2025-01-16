package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {
    @Test
    public void convertToAnyBaseTest() {
        // Test case for converting decimal to binary base
        int decimal = 10;
        int base = 2;
        String expected = "1010"; // Binary representation of decimal 10
        String actual = DecimalToAnyBase.convertToAnyBase(decimal, base);
        assertEquals(expected, actual, "Decimal to binary conversion failed");

        // Test case for converting decimal to octal base
        decimal = 12; // Octal representation of decimal 12 is "14" in base 8 system
        base = 8;
        expected = "14"; // Octal representation of decimal 12 in base 8 system
        actual = DecimalToAnyBase.convertToAnyBase(decimal, base);
        assertEquals(expected, actual, "Decimal to octal conversion failed");

        // Test case for converting decimal to hexadecimal base
        decimal = 25; // Hexadecimal representation of decimal 25 is "19" in base 16 system
        base = 16; // 16 as hexadecimal representation starts with A and B for 10 and 11 respectively
        expected = "19"; // Hexadecimal representation of decimal 25 in base 16 system
        actual = DecimalToAnyBase.convertToAnyBase(decimal, base); // Will give 'Wrong Number Format' error for inputs outside of normal decimal values
        assertEquals(expected, actual, "Decimal to hexadecimal conversion failed"); // Add proper handling for negative and large inputs outside of standard range in case it exists in the implementation of the function convertToAnyBase
    }
}