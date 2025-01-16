package com.google.zxing.pdf417;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PDF417CommonTest {

    @Test
    public void getCodewordTest() {
        // Given a symbol that exists in the SYMBOL_TABLE
        int validSymbol = 12345; // Example value, must exist in SYMBOL_TABLE for test to be valid
        int expectedIndex = Arrays.binarySearch(PDF417Common.SYMBOL_TABLE, validSymbol & 0x3FFFF);
        if (expectedIndex >= 0) {
            int expectedCodeword = (PDF417Common.CODEWORD_TABLE[expectedIndex] - 1) % PDF417Common.NUMBER_OF_CODEWORDS;
            assertEquals(expectedCodeword, PDF417Common.getCodeword(validSymbol));
        }

        // Given a symbol that does not exist in the SYMBOL_TABLE
        int invalidSymbol = -1; // Example value, must not exist in SYMBOL_TABLE for test to be valid
        assertEquals(-1, PDF417Common.getCodeword(invalidSymbol));
    }
}