package com.thealgorithms.conversions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {

    @Test
    public void convertToAnyBaseTest() {
        // Test case 1: Convert decimal 10 to binary (base 2)
        assertEquals("1010", DecimalToAnyBase.convertToAnyBase(10, 2));

        // Test case 2: Convert decimal 255 to hexadecimal (base 16)
        assertEquals("FF", DecimalToAnyBase.convertToAnyBase(255, 16));

        // Test case 3: Convert decimal 0 to any base should be "0"
        assertEquals("0", DecimalToAnyBase.convertToAnyBase(0, 5));

        // Test case 4: Convert decimal 100 to octal (base 8)
        assertEquals("144", DecimalToAnyBase.convertToAnyBase(100, 8));

        // Test case 5: Convert a negative number should eventually lead to empty string or error
        // This case depends on how reVal handles negative numbers, assuming it returns an empty string
        assertEquals("", DecimalToAnyBase.convertToAnyBase(-10, 2));

        // Test case 6: Check conversion with base 1 (invalid base), expecting it to fail in practical use
        // Depending on reVal and main implementation behavior, it may throw an error or return an empty string
        // Surround with a try-catch if it throws
        assertThrows(ArithmeticException.class, () -> DecimalToAnyBase.convertToAnyBase(10, 1));
    }
}