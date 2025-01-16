package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {
    @Test
    public void decodeTest() {
        String encryptedMessage = "Hello World!"; // Test case for the decode method
        String cipherSmall = "cefmiknjhbvagh"; // Cipher for lowercase letters
        String expectedDecodedMessage = "hello world!"; // Expected decoded message
        String actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall); // Actual decoded message
        assertEquals(expectedDecodedMessage, actualDecodedMessage, "Decoded message does not match the expected message."); // Asserting the decoded message is correct
    }
}

Explanation:
The given test case aims to verify the behavior of the `decode` method of the `SimpleSubstitutionCipher` class. We define a test case with an encrypted message "Hello World!" and a corresponding cipher for lowercase letters "cefmiknjhbvagh". We expect the decode method to return "hello world!" as the result. We use JUnit's `assertEquals` method to assert that the actual decoded message matches the expected one. If they don't match, the test will fail and indicate that there is a problem with the `decode` method.