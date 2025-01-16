package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WhiteRectangleDetectorTest {

    @Test
    public void detectTest() {
        // Create a BitMatrix with no barcodes (all white)
        BitMatrix image = new BitMatrix(10, 10);
        
        // Initialize the detector with the BitMatrix
        WhiteRectangleDetector detector = new WhiteRectangleDetector(image);

        // Attempt to detect the region and expect a NotFoundException
        assertThrows(NotFoundException.class, () -> {
            detector.detect();
        });
    }
}