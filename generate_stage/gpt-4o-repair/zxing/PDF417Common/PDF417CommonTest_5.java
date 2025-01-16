package com.google.zxing.pdf417;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PDF417CommonTest {
    @Test
    public void getCodewordTest() {
        // Test with a symbol that exists in the SYMBOL_TABLE
        int existingSymbol = SYMBOL_TABLE[0]; // Assuming the first symbol in SYMBOL_TABLE
        int expectedCodeword = (CODEWORD_TABLE[0] - 1) % NUMBER_OF_CODEWORDS; // Corresponding codeword
        assertEquals(expectedCodeword, PDF417Common.getCodeword(existingSymbol));

        // Test with a symbol that does not exist in the SYMBOL_TABLE
        int nonExistingSymbol = -1; // A value not in SYMBOL_TABLE
        assertEquals(-1, PDF417Common.getCodeword(nonExistingSymbol));

        // Additional test cases for edge cases or additional symbols can be added as needed
        // Test with another valid symbol
        int anotherExistingSymbol = SYMBOL_TABLE[SYMBOL_TABLE.length - 1]; // Last symbol in SYMBOL_TABLE
        int anotherExpectedCodeword = (CODEWORD_TABLE[SYMBOL_TABLE.length - 1] - 1) % NUMBER_OF_CODEWORDS;
        assertEquals(anotherExpectedCodeword, PDF417Common.getCodeword(anotherExistingSymbol));
    }
}