package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WhiteRectangleDetectorTest {

    @Test
    public void detectTest() {
        // Arrange
        int width = 100;
        int height = 100;
        BitMatrix image = new BitMatrix(width, height);
        // Create a small white rectangle in the center of the image
        for (int x = 40; x < 60; x++) {
            for (int y = 40; y < 60; y++) {
                image.set(x, y);
            }
        }
        WhiteRectangleDetector detector = new WhiteRectangleDetector(image, 10, width / 2, height / 2);

        // Act
        try {
            ResultPoint[] result = detector.detect();

            // Assert
            assertNotNull(result);
            assertEquals(4, result.length);

            // Expected corners of the rectangle
            ResultPoint topLeft = new ResultPoint(40, 40);
            ResultPoint topRight = new ResultPoint(59, 40);
            ResultPoint bottomLeft = new ResultPoint(40, 59);
            ResultPoint bottomRight = new ResultPoint(59, 59);

            // Check if detected points match expected rectangle corners
            assertTrue(containsPoint(result, topLeft));
            assertTrue(containsPoint(result, topRight));
            assertTrue(containsPoint(result, bottomLeft));
            assertTrue(containsPoint(result, bottomRight));

        } catch (NotFoundException e) {
            fail("Expected to find a white rectangular region but got NotFoundException.");
        }
    }

    private boolean containsPoint(ResultPoint[] points, ResultPoint point) {
        for (ResultPoint p : points) {
            if (p.equals(point)) {
                return true;
            }
        }
        return false;
    }
}