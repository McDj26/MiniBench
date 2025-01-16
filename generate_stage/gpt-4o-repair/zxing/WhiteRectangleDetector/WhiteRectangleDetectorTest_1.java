package com.google.zxing.common.detector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public class WhiteRectangleDetectorTest {

    @Test
    public void detectTest() {
        // Initialize dimensions and data for BitMatrix
        int width = 10;
        int height = 10;
        BitMatrix matrix = new BitMatrix(width, height);

        // Simulate a rectangle in the BitMatrix
        // Here a sample rectangle from (2,2) to (7,7) will be white
        for (int x = 2; x <= 7; x++) {
            for (int y = 2; y <= 7; y++) {
                matrix.set(x, y);
            }
        }

        try {
            WhiteRectangleDetector detector = new WhiteRectangleDetector(matrix);
            ResultPoint[] points = detector.detect();
            assertNotNull(points);
            assertEquals(4, points.length);

            // Check coordinates of detected points
            // Expected coordinates based on the placed rectangle
            assertEquals(new ResultPoint(2, 2), points[0]);
            assertEquals(new ResultPoint(7, 2), points[1]);
            assertEquals(new ResultPoint(7, 7), points[2]);
            assertEquals(new ResultPoint(2, 7), points[3]);

        } catch (NotFoundException e) {
            fail("Rectangle should be detected.");
        }
    }
}