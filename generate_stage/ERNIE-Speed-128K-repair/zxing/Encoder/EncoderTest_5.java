package com.google.zxing.aztec.encoder;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.Charset;

public class EncoderTest {
    @Test
    public void encodeTest() {
        // Test encode with default parameters
        String testString = "Test Aztec Encoding";
        AztecCode encodedSymbol = Encoder.encode(testString);
        assertNotNull(encodedSymbol);
        assertNotNull(encodedSymbol.getMatrix());
        assertArrayNotNull(encodedSymbol.getModeMessage());
        assertArrayNotNull(encodedSymbol.getCheckWords());
        assertNotNull(encodedSymbol.getECCPercentage());
        assertEquals(Encoder.DEFAULT_AZTEC_LAYERS, encodedSymbol.getNumLayers());
        assertEquals(testString, encodedSymbol.getData());
        assertEquals(Charset.defaultCharset(), encodedSymbol.getCharset());
        assertEquals(Encoder.DEFAULT_EC_PERCENT, encodedSymbol.getECCPercentage());
        assertEquals(testString, encodedSymbol.getDataDecoded()); // Make sure we can decode the data as well
    }
    
    @Test
    public void encodeWithCustomParametersTest() {
        String testString = "Test Aztec Encoding with Custom Parameters";
        int minECCPercent = 30; // Test with non-default ECC percentage for additional scenarios
        int userSpecifiedLayers = 5; // Test with a user-specified number of layers for additional scenarios
        Charset charset = Charset.forName("UTF-8"); // Test with a non-default charset for additional scenarios
        AztecCode encodedSymbol = Encoder.encode(testString, minECCPercent, userSpecifiedLayers, charset);
        assertNotNull(encodedSymbol);
        assertNotNull(encodedSymbol.getMatrix());
        assertArrayNotNull(encodedSymbol.getModeMessage());
        assertArrayNotNull(encodedSymbol.getCheckWords());
        assertEquals(userSpecifiedLayers, encodedSymbol.getNumLayers()); // Check if the specified layers are used
        assertEquals(testString, encodedSymbol.getDataDecoded()); // Make sure we can decode the data as well with custom parameters
        assertEquals(charset, encodedSymbol.getCharset()); // Check if the specified charset is used in encoding
    }
}