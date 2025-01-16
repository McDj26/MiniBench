package com.google.zxing.common.detector;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    public void distanceTest() {
        // Test case for distance method with integer inputs
        int aX = 5; // Point A x coordinate
        int aY = 10; // Point A y coordinate
        int bX = 8; // Point B x coordinate
        int bY = 15; // Point B y coordinate
        float expectedDistance = (float) Math.sqrt((aX - bX) * (aX - bX) + (aY - bY) * (aY - bY));
        float actualDistance = MathUtils.distance(aX, aY, bX, bY);
        assertEquals(expectedDistance, actualDistance, "Distance calculation between two points is incorrect.");
        
        // Test case for distance method with negative inputs
        aX = -5; // Point A x coordinate is negative
        aY = -10; // Point A y coordinate is negative
        bX = 0; // Point B x coordinate is zero
        bY = 0; // Point B y coordinate is zero
        expectedDistance = (float) Math.sqrt((aX - bX) * (aX - bX) + (aY - bY) * (aY - bY));
        actualDistance = MathUtils.distance(aX, aY, bX, bY);
        assertEquals(expectedDistance, actualDistance, "Distance calculation with negative values is incorrect.");
        
        // Test case for distance method with zero distance between points
        aX = 0; // Both points have the same coordinates (0, 0) or overlap at a point
        aY = 0; // Same as above for y coordinate
        bX = 0; // Same as above for x coordinate of point B
        bY = 0; // Same as above for y coordinate of point B
        expectedDistance = 0f; // Distance between two points should be zero when they are at the same point
        actualDistance = MathUtils.distance(aX, aY, bX, bY);
        assertEquals(expectedDistance, actualDistance, "Distance should be zero when points overlap.");
    }
}