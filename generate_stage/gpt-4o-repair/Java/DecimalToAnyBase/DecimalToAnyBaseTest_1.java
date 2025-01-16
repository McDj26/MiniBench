package com.thealgorithms.conversions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {

    @Test
    public void convertToAnyBaseTest() {
        // Test case 1: Decimal to Binary
        assertEquals("1010", DecimalToAnyBase.convertToAnyBase(10, 2), 
            "10 in decimal should be 1010 in binary");

        // Test case 2: Decimal to Octal
        assertEquals("12", DecimalToAnyBase.convertToAnyBase(10, 8), 
            "10 in decimal should be 12 in octal");

        // Test case 3: Decimal to Hexadecimal
        assertEquals("A", DecimalToAnyBase.convertToAnyBase(10, 16), 
            "10 in decimal should be A in hexadecimal");

        // Test case 4: Edge case, converting 0 should return "0"
        assertEquals("0", DecimalToAnyBase.convertToAnyBase(0, 2), 
            "0 in decimal should be 0 in any base");

        // Test case 5: Converting number with base higher than 10
        assertEquals("100", DecimalToAnyBase.convertToAnyBase(100, 10), 
            "100 in decimal should be 100 in base 10");

        // Additional test cases can be added here
    }
}