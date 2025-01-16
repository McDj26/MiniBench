package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {

    @Test
    public void decodeTest() {
        // Arrange
        String encryptedMessage = "nob";
        String cipherSmall = "zyxwvutsrqponmlkjihgfedcba"; // reversed alphabet
        String expectedDecodedMessage = "mlk";

        // Act
        String actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);

        // Assert
        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }

    @Test
    public void decodeTestWithCapitalLetters() {
        // Arrange
        String encryptedMessage = "NoB";
        String cipherSmall = "zyxwvutsrqponmlkjihgfedcba"; // reversed alphabet
        String expectedDecodedMessage = "MlK";

        // Act
        String actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);

        // Assert
        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }

    @Test
    public void decodeTestWithNonAlphabeticCharacters() {
        // Arrange
        String encryptedMessage = "nob123!";
        String cipherSmall = "zyxwvutsrqponmlkjihgfedcba"; // reversed alphabet
        String expectedDecodedMessage = "mlk123!";

        // Act
        String actualDecodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);

        // Assert
        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }
}