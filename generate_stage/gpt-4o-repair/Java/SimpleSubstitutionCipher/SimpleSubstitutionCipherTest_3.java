package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {

    @Test
    public void decodeTest() {
        // Arrange
        String encryptedMessage = "nobody";
        String cipherSmall = "zyxwvutsrqponmlkjihgfedcba"; // This is the reverse of the alphabet

        // Act
        String decodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);

        // Assert
        assertEquals("mlowob", decodedMessage);  // 'n' decoded to 'm', 'o' to 'l', 'b' to 'o', and so on...
    }

    @Test
    public void decodeTestWithNonAlphabeticCharacters() {
        // Arrange
        String encryptedMessage = "nvobyd123!";
        String cipherSmall = "zyxwvutsrqponmlkjihgfedcba";

        // Act
        String decodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);

        // Assert
        assertEquals("mlowbyw123!", decodedMessage);  // Non-alphabet characters '123!' should remain unchanged
    }
}