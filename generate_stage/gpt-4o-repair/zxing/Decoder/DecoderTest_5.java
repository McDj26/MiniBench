package com.google.zxing.aztec.decoder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecoderTest {

    @Test
    public void getCharacterTestUpper() {
        // Assuming UPPER_TABLE is initialized as {"A", "B", "C", ..., "Z"}
        assertEquals("A", Decoder.getCharacter(Decoder.Table.UPPER, 0));
        assertEquals("Z", Decoder.getCharacter(Decoder.Table.UPPER, 25));
    }

    @Test
    public void getCharacterTestLower() {
        // Assuming LOWER_TABLE is initialized as {"a", "b", "c", ..., "z"}
        assertEquals("a", Decoder.getCharacter(Decoder.Table.LOWER, 0));
        assertEquals("z", Decoder.getCharacter(Decoder.Table.LOWER, 25));
    }

    @Test
    public void getCharacterTestMixed() {
        // Assuming MIXED_TABLE contains a mix of characters, let's presume {"m1", "m2", ...}
        assertEquals("m1", Decoder.getCharacter(Decoder.Table.MIXED, 0));
        assertEquals("m2", Decoder.getCharacter(Decoder.Table.MIXED, 1));
    }

    @Test
    public void getCharacterTestPunct() {
        // Assuming PUNCT_TABLE is initialized as {"!", "@", "#", ...}
        assertEquals("!", Decoder.getCharacter(Decoder.Table.PUNCT, 0));
        assertEquals("@", Decoder.getCharacter(Decoder.Table.PUNCT, 1));
    }

    @Test
    public void getCharacterTestDigit() {
        // Assuming DIGIT_TABLE is initialized as {"0", "1", "2", ..., "9"}
        assertEquals("0", Decoder.getCharacter(Decoder.Table.DIGIT, 0));
        assertEquals("9", Decoder.getCharacter(Decoder.Table.DIGIT, 9));
    }

    @Test
    public void getCharacterTestInvalidTable() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            Decoder.getCharacter(Decoder.Table.BINARY, 0);
        });
        assertEquals("Bad table", exception.getMessage());
    }
}