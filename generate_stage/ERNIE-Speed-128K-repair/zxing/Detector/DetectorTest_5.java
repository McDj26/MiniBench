package com.google.zxing.aztec.detector;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import com.google.zxing.*;
import com.google.zxing.common.Point;
import java.util.*;

public class DetectorTest {
    @Test
    public void getMatrixCenterTest() {
        // Assume a BitMatrix image is available for testing purposes
        BitMatrix image = new BitMatrix(20, 20);
        Detector detector = new Detector(image);
        Point expectedCenter = new Point(image.getWidth() / 2, image.getHeight() / 2); // Expected center for this test case
        ResultPoint actualCenterResultPoint = detector.getMatrixCenter(); // This is the actual center point obtained from the method to be tested
        Point actualCenter = actualCenterResultPoint.toResultPoint(); // Convert ResultPoint to Point for comparison with expectedCenter
        assertEquals(expectedCenter, actualCenter); // Assert that the actual center is the same as the expected center
    }
}