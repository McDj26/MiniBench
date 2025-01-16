package com.thealgorithms.ciphers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {
    @Test
    public void decodeTest() {
        Caesar caesar = new Caesar();
        String encryptedMessage = "HELLO"; // Assuming a shift of 1 for this test case
        int shift = 1; // Shift value for decryption
        String expectedDecodedMessage = "GKNNJ"; // Expected result after decryption with shift of 1
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift); // Actual result after decryption
        assertEquals(expectedDecodedMessage, actualDecodedMessage, "Decoding failed"); // Assert that the actual result matches the expected result
    }
}

In this test case, we assume that the `Caesar` class has already been properly defined and `decode()` method exists in the class. The test case checks the functionality of the `decode()` method by encrypting a message "HELLO" with a shift of 1 and then decrypting it to check if it returns the original message "GKNNJ". If the decrypted message matches the expected result, the test passes, otherwise it fails.