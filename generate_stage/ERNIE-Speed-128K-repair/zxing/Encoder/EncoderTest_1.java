package com.google.zxing.aztec.encoder;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.Charset;

public class EncoderTest {
    @Test
    public void encodeTest() {
        String data = "Hello, Aztec Code!";
        int minECCPercent = 30; // using a value above the recommended minimum for testing
        int userSpecifiedLayers = 0; // using default layers
        Charset charset = StandardCharsets.UTF_8; // using a common charset for testing
        
        AztecCode encodedSymbol = Encoder.encode(data, minECCPercent, userSpecifiedLayers, charset);
        assertNotNull(encodedSymbol); // assert that the encoded symbol is not null
        assertNotNull(encodedSymbol.getMatrix()); // assert that the matrix is not null
        assertNotNull(encodedSymbol.getMetaData()); // assert that the metadata is not null
        
        // Assuming there is a method to get the encoded string from the AztecCode object
        String encodedString = encodedSymbol.getEncodedString(); 
        assertEquals(data, encodedString); // assert that the encoded string is equal to the original data
        
        // Additional assertions can be made on the matrix size, number of layers, etc., if such methods are available in AztecCode class.
    }
}