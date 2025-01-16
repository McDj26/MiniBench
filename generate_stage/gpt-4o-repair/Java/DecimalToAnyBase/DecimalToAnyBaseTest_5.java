package com.thealgorithms.conversions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {

    @Test
    public void convertToAnyBaseTest() {
        // Test converting 10 to binary (base 2)
        assertEquals("1010", DecimalToAnyBase.convertToAnyBase(10, 2));

        // Test converting 10 to hexadecimal (base 16)
        assertEquals("A", DecimalToAnyBase.convertToAnyBase(10, 16));

        // Test converting 255 to hexadecimal
        assertEquals("FF", DecimalToAnyBase.convertToAnyBase(255, 16));

        // Test converting 0 to any base should return "0"
        assertEquals("0", DecimalToAnyBase.convertToAnyBase(0, 2));

        // Test converting a large number to base 36
        assertEquals("Z", DecimalToAnyBase.convertToAnyBase(35, 36));

        // Test converting 100 to base 10 (should remain 100)
        assertEquals("100", DecimalToAnyBase.convertToAnyBase(100, 10));

        // Edge case: converting 1 to base 2
        assertEquals("1", DecimalToAnyBase.convertToAnyBase(1, 2));
    }
}