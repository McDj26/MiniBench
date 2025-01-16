package com.thealgorithms.ciphers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {

    @Test
    public void decodeTest() {
        Caesar caesar = new Caesar();
        
        // Test with a simple right shift and expect regular letters
        String encodedMessage = "B";
        int shift = 1;
        String expectedDecodedMessage = "A";
        assertEquals(expectedDecodedMessage, caesar.decode(encodedMessage, shift));

        // Test with lowercase letters
        encodedMessage = "b";
        expectedDecodedMessage = "a";
        assertEquals(expectedDecodedMessage, caesar.decode(encodedMessage, shift));

        // Test with a full cycle shift (e.g., shifting by 26 should return the original text)
        encodedMessage = "HelloWorld";
        shift = 26;
        expectedDecodedMessage = "HelloWorld";
        assertEquals(expectedDecodedMessage, caesar.decode(encodedMessage, shift));

        // Test with a larger shift (e.g., 27 which is equivalent to 1 due to modulus operation)
        encodedMessage = "B";
        shift = 27;
        expectedDecodedMessage = "A";
        assertEquals(expectedDecodedMessage, caesar.decode(encodedMessage, shift));

        // Test with mixed characters (letters and non-letters)
        encodedMessage = "A1B2C3";
        shift = 1;
        expectedDecodedMessage = "Z1A2B3";
        assertEquals(expectedDecodedMessage, caesar.decode(encodedMessage, shift));
        
        // Test with no shift
        encodedMessage = "The quick brown fox jumps over 13 lazy dogs.";
        shift = 0;
        expectedDecodedMessage = "The quick brown fox jumps over 13 lazy dogs.";
        assertEquals(expectedDecodedMessage, caesar.decode(encodedMessage, shift));

        // Test with an empty string
        encodedMessage = "";
        expectedDecodedMessage = "";
        assertEquals(expectedDecodedMessage, caesar.decode(encodedMessage, shift));
    }
}