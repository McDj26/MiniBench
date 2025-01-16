package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WhiteRectangleDetectorTest {

    @Test
    public void detectTest_successfulDetection() {
        // Create a BitMatrix with a white rectangle in it
        BitMatrix image = new BitMatrix(10, 10);
        // Create a white rectangle from (2, 2) to (7, 7)
        for (int i = 2; i <= 7; i++) {
            for (int j = 2; j <= 7; j++) {
                image.set(j, i);
            }
        }

        WhiteRectangleDetector detector = new WhiteRectangleDetector(image);

        try {
            ResultPoint[] points = detector.detect();
            assertNotNull(points);
            assertEquals(4, points.length);
            // Validate positions of the points
            assertTrue(isCorner(points[0], 2, 2));
            assertTrue(isCorner(points[1], 7, 2));
            assertTrue(isCorner(points[2], 7, 7));
            assertTrue(isCorner(points[3], 2, 7));
        } catch (NotFoundException e) {
            fail("Rectangle should be detected");
        }
    }

    @Test
    public void detectTest_noDetection() {
        // Create a BitMatrix without any white rectangle
        BitMatrix image = new BitMatrix(10, 10);

        WhiteRectangleDetector detector = new WhiteRectangleDetector(image);

        assertThrows(NotFoundException.class, detector::detect);
    }

    private boolean isCorner(ResultPoint point, int expectedX, int expectedY) {
        return (int) point.getX() == expectedX && (int) point.getY() == expectedY;
    }
}