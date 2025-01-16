package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {

    @Test
    public void decodeTest() {
        // Given a cipher key and an encrypted message
        String cipherSmall = "zyxwvutsrqponmlkjihgfedcba";
        String encryptedMessage = "Svhg gsrh rh z nvhhztv!";
        
        // When decoding the message
        String decodedMessage = SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall);
        
        // Then the expected decoded message should match
        String expectedMessage = "Hello this is a message!";
        assertEquals(expectedMessage, decodedMessage);
    }
}