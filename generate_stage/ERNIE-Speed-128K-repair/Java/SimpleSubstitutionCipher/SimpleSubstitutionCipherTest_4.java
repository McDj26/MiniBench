package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {
    @Test
    public void decodeTest() {
        String encryptedMessage = "AbcDeFghIjKlmNoPqRsTuVwXyZ"; // Sample encrypted message
        String cipherSmall = "fjqcnoilpd"; // Sample cipher key for small letters
        String expectedDecodedMessage = "bcdfghjklmnoprtuvwxya"; // Expected decoded message
        String actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);
        assertEquals(expectedDecodedMessage, actualDecodedMessage); // Assert the actual decoded message matches the expected one
    }
}

Explanation: This test case checks the correctness of the `decode` method by comparing the actual decoded message with the expected decoded message for a given sample input. The test uses JUnit's `assertEquals` assertion to verify if both messages are the same.