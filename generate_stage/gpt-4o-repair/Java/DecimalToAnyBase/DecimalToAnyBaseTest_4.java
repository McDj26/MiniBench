package com.thealgorithms.conversions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {

    @Test
    public void convertToAnyBaseTest() {
        // Test conversion of decimal number 10 to base 2
        assertEquals("1010", DecimalToAnyBase.convertToAnyBase(10, 2));

        // Test conversion of decimal number 255 to base 16
        assertEquals("FF", DecimalToAnyBase.convertToAnyBase(255, 16));

        // Test conversion of decimal number 35 to base 8
        assertEquals("43", DecimalToAnyBase.convertToAnyBase(35, 8));

        // Test conversion of decimal number 0 to any base (edge case)
        assertEquals("0", DecimalToAnyBase.convertToAnyBase(0, 2));
        assertEquals("0", DecimalToAnyBase.convertToAnyBase(0, 16));

        // Test conversion of decimal number 1 to different bases
        assertEquals("1", DecimalToAnyBase.convertToAnyBase(1, 2));
        assertEquals("1", DecimalToAnyBase.convertToAnyBase(1, 16));

        // Test conversion with a non-standard base (base 3)
        assertEquals("102", DecimalToAnyBase.convertToAnyBase(11, 3));
    }
}