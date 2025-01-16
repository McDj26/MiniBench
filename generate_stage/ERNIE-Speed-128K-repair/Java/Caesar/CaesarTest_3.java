package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {
    @Test
    public void decodeTest() {
        Caesar caesar = new Caesar();
        String encryptedMessage = "HELLO"; // Assuming a shift of 1 for this test case
        int shift = 1; // Shift value for decryption
        String expectedDecodedMessage = "GDK"; // Expected decoded message after shifting each letter back by 1
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift); // Actual result from decryption method
        assertEquals(expectedDecodedMessage, actualDecodedMessage, "Decoding failed"); // Assert that the actual result matches the expected result
    }
}