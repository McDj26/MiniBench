package com.thealgorithms.ciphers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {
    @Test
    public void decodeTest() {
        Caesar caesar = new Caesar();
        String encryptedMessage = "HELLO"; // Assuming a shift of 1 for this test case
        int shift = 1; // Test with a shift of 1
        String expectedDecodedMessage = "GKLLN"; // Expected decoded message after shifting each letter back by 1
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift); // Actual decoded message
        assertEquals(expectedDecodedMessage, actualDecodedMessage, "Decoded message should match the expected message."); // Asserting the expected result
    }
}