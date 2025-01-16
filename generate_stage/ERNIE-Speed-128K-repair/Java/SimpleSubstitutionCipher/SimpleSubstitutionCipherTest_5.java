package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {
    @Test
    public void decodeTest() {
        String encryptedMessage = "Hello World!"; // Test case 1
        String cipherSmall = "abcdefg"; // The corresponding cipher for small letters in the test case 1
        String expectedDecodedMessage = "bdfmn qpsol!"; // The expected decoded message for the test case 1
        String actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall); // Execute the decode method with the given inputs
        assertEquals(expectedDecodedMessage, actualDecodedMessage); // Assert that the actual decoded message matches the expected one
        
        encryptedMessage = "Hello World!"; // Test case 2 for special characters handling
        cipherSmall = "xyzabcfeghijk"; // The corresponding cipher for small letters in the test case 2, with special characters in between
        expectedDecodedMessage = "hbbo ylrc!"; // The expected decoded message with only alphabets due to special characters in the cipher string
        actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall); // Execute the decode method with the test case 2 inputs
        assertTrue(actualDecodedMessage.matches(".*[a-zA-Z].*")); // Assert that the actual decoded message contains at least one alphabetic character due to special characters in the cipher string
        assertEquals(expectedDecodedMessage, actualDecodedMessage.replaceAll("[^a-zA-Z]", "")); // Assert that only alphabetic characters match the expected decoded message after removing special characters from actual message
    }
}