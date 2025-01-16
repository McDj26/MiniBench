package com.thealgorithms.ciphers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {

    private Caesar caesar;

    @BeforeEach
    public void setUp() {
        caesar = new Caesar();
    }

    @Test
    public void decodeTestWithPositiveShift() {
        String encryptedMessage = "BCDE";
        int shift = 1;
        String expectedDecodedMessage = "ABCD";
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift);

        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }

    @Test
    public void decodeTestWithNegativeShift() {
        String encryptedMessage = "YZAB";
        int shift = -2;
        String expectedDecodedMessage = "ABCD";
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift);

        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }

    @Test
    public void decodeTestWithNoShift() {
        String encryptedMessage = "ABCD";
        int shift = 0;
        String expectedDecodedMessage = "ABCD";
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift);

        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }

    @Test
    public void decodeTestWithWrapAround() {
        String encryptedMessage = "ZABC";
        int shift = 1;
        String expectedDecodedMessage = "YZAB";
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift);

        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }

    @Test
    public void decodeTestWithNonLatinCharacters() {
        String encryptedMessage = "A!B@C#D";
        int shift = 1;
        String expectedDecodedMessage = "Z!A@B#C";
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift);

        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }
}