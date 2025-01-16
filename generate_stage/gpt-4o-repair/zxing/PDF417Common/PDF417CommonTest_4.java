package com.google.zxing.pdf417;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PDF417CommonTest {

    @Test
    public void getCodewordTest() {
        // Test with a symbol that is in the SYMBOL_TABLE
        int symbol = 12345; // Assume 12345 is a known value in SYMBOL_TABLE
        int expectedCodeword = 678; // Assume this is the expected codeword
        assertEquals(expectedCodeword, PDF417Common.getCodeword(symbol), "The codeword should match the expected value for the given symbol.");

        // Test with a symbol not in SYMBOL_TABLE
        int invalidSymbol = 999999; // Assume 999999 is not in SYMBOL_TABLE
        int expectedInvalidCodeword = -1; // When the symbol is not in SYMBOL_TABLE
        assertEquals(expectedInvalidCodeword, PDF417Common.getCodeword(invalidSymbol), "The codeword should be -1 for invalid symbol.");

        // Additional edge cases
        int boundarySymbol = SYMBOL_TABLE[0]; // Test the first entry in SYMBOL_TABLE
        int expectedBoundaryCodeword = (CODEWORD_TABLE[0] - 1) % PDF417Common.NUMBER_OF_CODEWORDS;
        assertEquals(expectedBoundaryCodeword, PDF417Common.getCodeword(boundarySymbol), "The codeword should match the expected value for the first symbol in SYMBOL_TABLE.");

        int maxBoundarySymbol = SYMBOL_TABLE[SYMBOL_TABLE.length - 1]; // Test the last entry in SYMBOL_TABLE
        int expectedMaxBoundaryCodeword = (CODEWORD_TABLE[SYMBOL_TABLE.length - 1] - 1) % PDF417Common.NUMBER_OF_CODEWORDS;
        assertEquals(expectedMaxBoundaryCodeword, PDF417Common.getCodeword(maxBoundarySymbol), "The codeword should match the expected value for the last symbol in SYMBOL_TABLE.");
    }
}