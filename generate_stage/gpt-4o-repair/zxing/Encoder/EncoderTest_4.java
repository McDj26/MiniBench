package com.google.zxing.aztec.encoder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncoderTest {
    
    @Test
    public void encodeTest() {
        String testData = "Hello, World!";
        int minECCPercent = 25;
        int userSpecifiedLayers = 0;
        Charset charset = StandardCharsets.ISO_8859_1;
        
        AztecCode aztecCode = Encoder.encode(testData, minECCPercent, userSpecifiedLayers, charset);
        
        // Assuming the AztecCode class has methods getData(),
        // getMinECCPercent(), getUserSpecifiedLayers(), and getCharset()
        
        assertNotNull(aztecCode, "Aztec code should not be null");
        assertEquals(testData, new String(aztecCode.getData(), charset), "Encoded data should match the input data");
        assertEquals(minECCPercent, aztecCode.getMinECCPercent(), "Error checking percentage should match the input");
        assertEquals(userSpecifiedLayers, aztecCode.getUserSpecifiedLayers(), "Number of layers should match the input");
        assertEquals(charset, aztecCode.getCharset(), "Charset should match the input");
    }
}