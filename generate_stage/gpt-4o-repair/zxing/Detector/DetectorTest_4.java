package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DetectorTest {

    @Test
    public void getMatrixCenterTest() throws NotFoundException {
        // Create a mock BitMatrix
        BitMatrix mockImage = mock(BitMatrix.class);
        when(mockImage.getWidth()).thenReturn(100);
        when(mockImage.getHeight()).thenReturn(100);

        // Create mock ResultPoints
        ResultPoint pointA = new ResultPoint(10, 10);
        ResultPoint pointB = new ResultPoint(20, 10);
        ResultPoint pointC = new ResultPoint(20, 20);
        ResultPoint pointD = new ResultPoint(10, 20);

        // Create a WhiteRectangleDetector that returns the mock points
        WhiteRectangleDetector mockDetector = mock(WhiteRectangleDetector.class);
        when(mockDetector.detect()).thenReturn(new ResultPoint[]{pointA, pointB, pointC, pointD});

        // Override getMatrixCenter method to use the mock detector
        Detector detector = new Detector(mockImage) {
            @Override
            protected WhiteRectangleDetector createWhiteRectangleDetector(int cx, int cy) {
                return mockDetector;
            }
        };

        Point expectedCenter = new Detector.Point(15, 15);

        // Perform the test and assert the result
        Point actualCenter = detector.getMatrixCenter();
        assertEquals(expectedCenter.getX(), actualCenter.getX());
        assertEquals(expectedCenter.getY(), actualCenter.getY());
    }
}