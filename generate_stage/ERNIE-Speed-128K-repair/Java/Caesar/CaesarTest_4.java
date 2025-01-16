package com.thealgorithms.ciphers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {
    @Test
    public void decodeTest() {
        Caesar caesarCipher = new Caesar();
        String encodedMessage = "HELLO"; // Assuming a shift of 1 for this test case
        String shiftValue = 1; // The shift value for the decode operation
        String expectedDecodedMessage = "GKKN"; // Expected result after decryption with the given shift value
        String actualDecodedMessage = caesarCipher.decode(encodedMessage, shiftValue); // Execution of the decode method
        assertEquals(expectedDecodedMessage, actualDecodedMessage); // Assert that the actual result matches the expected result
    }
}