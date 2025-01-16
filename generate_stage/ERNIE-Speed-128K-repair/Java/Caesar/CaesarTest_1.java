package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {
    @Test
    public void decodeTest() {
        Caesar caesar = new Caesar();
        String encryptedMessage = "HELLO"; // Assuming a shift of 1 character for testing purposes
        int shift = 1; // Here the shift value will be applied to the encoded message
        String expectedDecodedMessage = "GDK"; // Expected result after decoding with a shift of 1
        String actualDecodedMessage = caesar.decode(encryptedMessage, shift); // Execution of the decode method with given input
        assertEquals(expectedDecodedMessage, actualDecodedMessage, "Decoding failed"); // Asserting if the actual decoded message matches the expected result
    }
}

Note: Additional test cases can be added for various inputs, such as messages with both uppercase and lowercase letters, non-alphabetical characters, negative shifts, etc., to ensure the code is thoroughly tested for edge cases and different scenarios.