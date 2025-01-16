package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {
    @Test
    public void decodeTest() {
        String encryptedMessage = "Hello World!"; // Test case for the decode method
        String cipherSmall = "wvutuinyhzfoyssdagpbmcxkjdrrvlerlctqmojepulb"; // Cipher for the test case
        String expectedDecodedMessage = "Hello World!"; // Expected decoded message
        String actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall); // Actual decoded message
        assertEquals(expectedDecodedMessage, actualDecodedMessage); // Assert that the actual decoded message is equal to the expected one
    }
}

This is a basic test case for the `decode` method in `SimpleSubstitutionCipher`. The test checks if the `decode` method correctly decodes a given encrypted message using a provided cipher by comparing the actual decoded message with the expected decoded message.