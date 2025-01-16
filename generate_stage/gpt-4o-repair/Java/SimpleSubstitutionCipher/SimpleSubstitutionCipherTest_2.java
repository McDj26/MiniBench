package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {
    @Test
    public void decodeTest() {
        // Arrange
        String encryptedMessage = "bcd";
        String cipherSmall = "zyxwvutsrqponmlkjihgfedcba";
        
        // Act
        String decodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);
        
        // Assert
        assertEquals("xyz", decodedMessage);
        
        // Additional Tests
        // Test with uppercase letters
        encryptedMessage = "BCD";
        decodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);
        assertEquals("XYZ", decodedMessage);
        
        // Test with mixed case and punctuation
        encryptedMessage = "BcD! @12";
        decodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);
        assertEquals("XyZ! @12", decodedMessage);

        // Test with an empty string
        encryptedMessage = "";
        decodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);
        assertEquals("", decodedMessage);

        // Test with a string that has no alphabetic characters
        encryptedMessage = "12345!@#";
        decodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);
        assertEquals("12345!@#", decodedMessage);
    }
}