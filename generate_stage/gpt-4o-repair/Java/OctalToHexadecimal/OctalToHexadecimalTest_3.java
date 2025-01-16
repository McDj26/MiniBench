package com.thealgorithms.conversions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToHexadecimalTest {

    @Test
    public void decimalToHexTest() {
        assertEquals("0", OctalToHexadecimal.decimalToHex(0), "Decimal 0 should convert to Hex 0");
        assertEquals("1", OctalToHexadecimal.decimalToHex(1), "Decimal 1 should convert to Hex 1");
        assertEquals("A", OctalToHexadecimal.decimalToHex(10), "Decimal 10 should convert to Hex A");
        assertEquals("F", OctalToHexadecimal.decimalToHex(15), "Decimal 15 should convert to Hex F");
        assertEquals("10", OctalToHexadecimal.decimalToHex(16), "Decimal 16 should convert to Hex 10");
        assertEquals("1A", OctalToHexadecimal.decimalToHex(26), "Decimal 26 should convert to Hex 1A");
        assertEquals("FF", OctalToHexadecimal.decimalToHex(255), "Decimal 255 should convert to Hex FF");
        assertEquals("100", OctalToHexadecimal.decimalToHex(256), "Decimal 256 should convert to Hex 100");
        assertEquals("7F", OctalToHexadecimal.decimalToHex(127), "Decimal 127 should convert to Hex 7F");
        assertEquals("80", OctalToHexadecimal.decimalToHex(128), "Decimal 128 should convert to Hex 80");
    }
}