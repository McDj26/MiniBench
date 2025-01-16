package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTest {

    @Test
    public void decodeTest() {
        Caesar caesar = new Caesar();
        
        // Test case 1: Simple shift
        String encryptedMessage1 = "BCD";
        int shift1 = 1;
        String expected1 = "ABC";
        assertEquals(expected1, caesar.decode(encryptedMessage1, shift1), 
            "The decoded message with shift 1 should be 'ABC'.");

        // Test case 2: No shift
        String encryptedMessage2 = "HELLO";
        int shift2 = 0;
        String expected2 = "HELLO";
        assertEquals(expected2, caesar.decode(encryptedMessage2, shift2), 
            "The decoded message with shift 0 should remain 'HELLO'.");

        // Test case 3: Full cycle shift
        String encryptedMessage3 = "WORLD";
        int shift3 = 26;
        String expected3 = "WORLD";
        assertEquals(expected3, caesar.decode(encryptedMessage3, shift3), 
            "The decoded message with a full cycle shift (26) should remain 'WORLD'.");

        // Test case 4: Negative shift
        String encryptedMessage4 = "XYZ";
        int shift4 = -3;
        String expected4 = "ABC";
        assertEquals(expected4, caesar.decode(encryptedMessage4, shift4), 
            "The decoded message with shift -3 should be 'ABC'.");

        // Test case 5: Different case letters and special characters
        String encryptedMessage5 = "Uif!Dbftbs.Dpef!";
        int shift5 = 1;
        String expected5 = "The!Caesar.Code!";
        assertEquals(expected5, caesar.decode(encryptedMessage5, shift5), 
            "The decoded message should handle both upper and lower case correctly along with special characters.");
    }
}