package com.thealgorithms.ciphers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {

    @Test
    public void decodeTest() {
        Caesar caesar = new Caesar();
        
        // Test 1: Basic decode test with a small positive shift
        String encryptedMessage1 = "BCD";
        int shift1 = 1;
        String expectedDecodedMessage1 = "ABC";
        String actualDecodedMessage1 = caesar.decode(encryptedMessage1, shift1);
        assertEquals(expectedDecodedMessage1, actualDecodedMessage1, 
            "Decoding of BCD with shift 1 should return ABC.");
        
        // Test 2: Decode test with a wrap around shift
        String encryptedMessage2 = "AZY";
        int shift2 = 2;
        String expectedDecodedMessage2 = "YXW";
        String actualDecodedMessage2 = caesar.decode(encryptedMessage2, shift2);
        assertEquals(expectedDecodedMessage2, actualDecodedMessage2, 
            "Decoding of AZY with shift 2 should return YXW.");

        // Test 3: Decode test with small letters
        String encryptedMessage3 = "bcd";
        int shift3 = 1;
        String expectedDecodedMessage3 = "abc";
        String actualDecodedMessage3 = caesar.decode(encryptedMessage3, shift3);
        assertEquals(expectedDecodedMessage3, actualDecodedMessage3, 
            "Decoding of bcd with shift 1 should return abc.");

        // Test 4: Decode with shift equal to 0 (no shift)
        String encryptedMessage4 = "HELLO";
        int shift4 = 0;
        String expectedDecodedMessage4 = "HELLO";
        String actualDecodedMessage4 = caesar.decode(encryptedMessage4, shift4);
        assertEquals(expectedDecodedMessage4, actualDecodedMessage4, 
            "Decoding of HELLO with shift 0 should return HELLO.");

        // Test 5: Decode with non-Latin characters
        String encryptedMessage5 = "A! B @ C";
        int shift5 = 1;
        String expectedDecodedMessage5 = "Z! A @ B";
        String actualDecodedMessage5 = caesar.decode(encryptedMessage5, shift5);
        assertEquals(expectedDecodedMessage5, actualDecodedMessage5, 
            "Decoding of A! B @ C with shift 1 should return Z! A @ B.");
    }
}