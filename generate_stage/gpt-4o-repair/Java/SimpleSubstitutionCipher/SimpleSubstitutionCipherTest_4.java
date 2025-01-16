package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSubstitutionCipherTest {

    @Test
    public void decodeTest() {
        // Test case 1: Basic decoding
        String encryptedMessage = "qwerty";
        String cipherSmall = "qwertyuiopasdfghjklzxcvbnm";
        String expectedMessage = "abcde";
        assertEquals(expectedMessage, SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall));

        // Test case 2: Handles uppercase letters
        encryptedMessage = "QWERTY";
        expectedMessage = "ABCDE";
        assertEquals(expectedMessage, SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall));

        // Test case 3: Mixed case and symbols
        encryptedMessage = "QwErTy!";
        expectedMessage = "AbCdE!";
        assertEquals(expectedMessage, SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall));

        // Test case 4: Empty string
        encryptedMessage = "";
        expectedMessage = "";
        assertEquals(expectedMessage, SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall));

        // Test case 5: Symbols only
        encryptedMessage = "!!@@##";
        expectedMessage = "!!@@##";
        assertEquals(expectedMessage, SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall));

        // Test case 6: Full alphabet
        encryptedMessage = "mnbvcxzasdfghjklpoiuytrewq";
        expectedMessage = "zyxwvutsrqponmlkjihgfedcba";
        assertEquals(expectedMessage, SimpleSubstitutionCipher.decode(encryptedMessage, cipherSmall));
    }
}