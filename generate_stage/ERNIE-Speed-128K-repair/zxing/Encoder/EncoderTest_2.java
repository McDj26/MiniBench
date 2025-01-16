package com.google.zxing.aztec.encoder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncoderTest {
    @Test
    public void encodeTest() {
        String testData = "Hello, Aztec!"; // Test string content
        int minECCPercent = 25; // Set the minimal percentage of error check words as per ISO/IEC 24778:2008 recommendation
        int userSpecifiedLayers = 0; // Using default layers or user-specified value
        Charset charset = StandardCharsets.UTF_8; // Test charset
        Charset isoCharset = StandardCharsets.ISO_8859_1; // Default encoding charset if no ECI provided

        AztecCode encodedSymbol = Encoder.encode(testData, minECCPercent, userSpecifiedLayers, charset);
        assertNotNull(encodedSymbol); // Expect non-null encoded symbol
        assertNotNull(encodedSymbol.getMatrix()); // Expect non-null matrix in the encoded symbol
        assertNotNull(encodedSymbol.getMetaData()); // Expect non-null metadata in the encoded symbol
        assertTrue(encodedSymbol.getMatrix().isRectangular()); // Expect a rectangular matrix
        assertTrue(encodedSymbol.getMetaData().isValid()); // Expect valid metadata for the encoded symbol

        byte[] dataInBytes = testData.getBytes(charset); // Convert test string to bytes using the provided charset
        encodedSymbol = Encoder.encode(dataInBytes, minECCPercent, userSpecifiedLayers); // Encode without specifying charset (should default to ISO_8859_1)
        assertNotNull(encodedSymbol); // Expect non-null encoded symbol without charset specified
        assertNotNull(encodedSymbol.getMatrix()); // Expect non-null matrix in the encoded symbol without charset specified
        assertNotNull(encodedSymbol.getMetaData()); // Expect non-null metadata in the encoded symbol without charset specified
        assertTrue(encodedSymbol.getMatrix().isRectangular()); // Expect a rectangular matrix without charset specified
        assertTrue(encodedSymbol.getMetaData().isValid()); // Expect valid metadata for the encoded symbol without charset specified
    }
}