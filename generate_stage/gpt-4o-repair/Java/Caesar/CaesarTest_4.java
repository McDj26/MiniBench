package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {

    @Test
    public void decodeTest() {
        Caesar caesar = new Caesar();
        // Test case 1: Shift by 1
        String encryptedMessage1 = "B";
        int shift1 = 1;
        String expectedDecodedMessage1 = "A";
        assertEquals(expectedDecodedMessage1, caesar.decode(encryptedMessage1, shift1));

        // Test case 2: Shift by 3
        String encryptedMessage2 = "Ebiil";
        int shift2 = 3;
        String expectedDecodedMessage2 = "Hello";
        assertEquals(expectedDecodedMessage2, caesar.decode(encryptedMessage2, shift2));

        // Test case 3: Shift by 26 (full rotation)
        String encryptedMessage3 = "Hello";
        int shift3 = 26;
        String expectedDecodedMessage3 = "Hello";
        assertEquals(expectedDecodedMessage3, caesar.decode(encryptedMessage3, shift3));

        // Test case 4: Shift by 27 (equivalent to shift by 1)
        String encryptedMessage4 = "Ifmmp";
        int shift4 = 27;
        String expectedDecodedMessage4 = "Hello";
        assertEquals(expectedDecodedMessage4, caesar.decode(encryptedMessage4, shift4));

        // Test case 5: Mixed case with symbols
        String encryptedMessage5 = "Khoor, Zruog!";
        int shift5 = 3;
        String expectedDecodedMessage5 = "Hello, World!";
        assertEquals(expectedDecodedMessage5, caesar.decode(encryptedMessage5, shift5));
    }
}