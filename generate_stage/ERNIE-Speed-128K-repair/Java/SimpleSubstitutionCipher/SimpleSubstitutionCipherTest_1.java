package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {
    @Test
    public void decodeTest() {
        String encryptedMessage = "This is a secret message!"; // Sample encrypted message
        String cipherSmall = "t1o2r3u4a5c6h7e8"; // Cipher for small letters
        String expectedDecodedMessage = "this is a secret message!"; // Expected decoded message
        String actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall); // Actual decoded message
        assertEquals(expectedDecodedMessage, actualDecodedMessage); // Assert that the actual decoded message matches the expected one
    }
}

In this test case, we have provided a sample encrypted message and a corresponding cipher for small letters. The expected decoded message is known, so we can use the assertEquals method to verify that the actual decoded message matches the expected one after calling the decode method from SimpleSubstitutionCipher class.