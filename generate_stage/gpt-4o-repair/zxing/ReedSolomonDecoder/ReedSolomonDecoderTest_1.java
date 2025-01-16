package com.google.zxing.common.reedsolomon;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReedSolomonDecoderTest {

    @Test
    public void decodeWithECCountTest() {
        // Setup a known field
        GenericGF field = GenericGF.QR_CODE_FIELD_256;
        ReedSolomonDecoder decoder = new ReedSolomonDecoder(field);

        // Example data and received codewords
        int[] received = { 32, 45, 56, 23, 15, 0, 0, 0 }; // Assume first part is data, last part is error codewords
        int twoS = 3;  // Assuming we have three error-correction codewords

        try {
            // Forcing an error, assume two errors introduced
            received[1] ^= 1;
            received[3] ^= 1;

            int errorsCorrected = decoder.decodeWithECCount(received, twoS);

            assertEquals(2, errorsCorrected, "Should have corrected two errors");
            assertArrayEquals(new int[]{32, 44, 56, 22, 15, 0, 0, 0}, received, "The original message should be correctly restored");
        } catch (ReedSolomonException e) {
            fail("Decoding failed with an exception: " + e.getMessage());
        }
    }
}