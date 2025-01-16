package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {
    @Test
    public void convertToAnyBaseTest() {
        // Test case for decimal 10 in base 2
        int decimal = 10;
        int base = 2;
        String expectedOutput = "1010"; // Binary representation of decimal 10
        String actualOutput = DecimalToAnyBase.convertToAnyBase(decimal, base);
        assertEquals(expectedOutput, actualOutput, "Decimal to base 2 conversion failed");
        
        // Test case for decimal 27 in base 16
        decimal = 27;
        base = 16;
        expectedOutput = "1B"; // Hexadecimal representation of decimal 27
        actualOutput = DecimalToAnyBase.convertToAnyBase(decimal, base);
        assertEquals(expectedOutput, actualOutput, "Decimal to base 16 conversion failed");
        
        // Test case for decimal -1 in base 36 (Hex is subset of base 36)
        decimal = -1; // Represents the letter 'Z' in hexadecimal system and can be extended to full base 36 representation as well
        base = 36; // Using Hex characters (0-9, A-F) for representation
        expectedOutput = "ZZZZ"; // Base 36 representation of decimal -1 using hexadecimal characters only (0-9, A-F) followed by a series of Zs representing non-positive integers (-9 is FF in hex)
        actualOutput = DecimalToAnyBase.convertToAnyBase(decimal, base); // This will throw an IllegalArgumentException as negative numbers are not allowed in the current implementation of convertToAnyBase method
        assertThrows(IllegalArgumentException.class, () -> actualOutput = DecimalToAnyBase.convertToAnyBase(decimal, base), "Negative decimal to base 36 conversion should throw IllegalArgumentException"); // Expecting IllegalArgumentException for negative input in convertToAnyBase method
    }
}