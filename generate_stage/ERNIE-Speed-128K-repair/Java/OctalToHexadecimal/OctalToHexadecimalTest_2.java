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
        assertEquals(expectedHex, actualHex, "The hexadecimal representation of decimal number 255 should be FF"); // Assert that the actual and expected hexadecimal values are equal
        
        // Test case with a negative number
        decimalNumber = -1; // Test with a negative value
        expectedHex = "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"; // Expected hexadecimal representation of the negative decimal number is multiple F followed by an error as it cannot be represented in the same way as positive numbers in hexadecimal format
        actualHex = OctalToHexadecimal.decimalToHex(decimalNumber); // Actual hexadecimal representation obtained from the method for negative number
        assertNotEquals(expectedHex, actualHex, "Negative decimal numbers cannot be converted to hexadecimal directly as it requires two's complement representation"); // Assert that the actual and expected hexadecimal values are not equal for negative numbers (we expect an exception or different result due to two's complement representation)
    }
}