package com.google.zxing.aztec.encoder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.StandardCharsets;

public class EncoderTest {

    @Test
    public void encodeTest() {
        // Test data
        String data = "Hello, Aztec!";
        int minECCPercent = 30; // Minimum error correction percentage
        int userSpecifiedLayers = 0; // Let the encoder decide the number of layers
        Charset charset = StandardCharsets.UTF_8;

        // Call the encode method
        AztecCode aztecCode = Encoder.encode(data, minECCPercent, userSpecifiedLayers, charset);

        // Assert expected properties of the AztecCode
        assertNotNull(aztecCode, "The encoded AztecCode should not be null.");
        assertNotNull(aztecCode.getMatrix(), "The BitMatrix of the AztecCode should not be null.");
        
        // Check that the encoded matrix has non-zero width and height
        assertTrue(aztecCode.getMatrix().getWidth() > 0, "The width of the AztecCode matrix should be greater than zero.");
        assertTrue(aztecCode.getMatrix().getHeight() > 0, "The height of the AztecCode matrix should be greater than zero.");
        
        // Optionally, verify if error correction and layer settings are as expected
        assertEquals(minECCPercent, aztecCode.getEcPercentage(), "The error correction percentage should be as specified.");
        if (userSpecifiedLayers > 0) {
            assertEquals(userSpecifiedLayers, aztecCode.getLayers(), "The number of layers should match the user-specified layers.");
        }
        
        // Further verifications can be made depending on AztecCode's attributes.
        // For example, the test can validate specific encoding properties or constraints.
    }
}