package com.google.zxing.common.detector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    public void distanceTest() {
        // Test case 1: Positive integers
        int aX1 = 3, aY1 = 4, bX1 = 7, bY1 = 1;
        float expectedDistance1 = 5.0f; // Using the distance formula, sqrt((3-7)^2 + (4-1)^2) = 5
        assertEquals(expectedDistance1, MathUtils.distance(aX1, aY1, bX1, bY1), 0.0001, "Distance calculation is incorrect");

        // Test case 2: Points on the same spot
        int aX2 = 0, aY2 = 0, bX2 = 0, bY2 = 0;
        float expectedDistance2 = 0.0f; // Distance is 0 when both points are the same
        assertEquals(expectedDistance2, MathUtils.distance(aX2, aY2, bX2, bY2), 0.0001, "Distance of the same points should be 0");

        // Test case 3: Horizontal distance
        int aX3 = 1, aY3 = 5, bX3 = 4, bY3 = 5;
        float expectedDistance3 = 3.0f; // Horizontal distance, sqrt((1-4)^2 + (5-5)^2) = 3
        assertEquals(expectedDistance3, MathUtils.distance(aX3, aY3, bX3, bY3), 0.0001, "Horizontal distance calculation is incorrect");

        // Test case 4: Vertical distance
        int aX4 = 2, aY4 = 1, bX4 = 2, bY4 = 6;
        float expectedDistance4 = 5.0f; // Vertical distance, sqrt((2-2)^2 + (1-6)^2) = 5
        assertEquals(expectedDistance4, MathUtils.distance(aX4, aY4, bX4, bY4), 0.0001, "Vertical distance calculation is incorrect");

        // Test case 5: Points with the same coordinates but negative
        int aX5 = -3, aY5 = -4, bX5 = -7, bY5 = -1;
        float expectedDistance5 = 5.0f; // Similar to Test case 1 but in negative quadrant
        assertEquals(expectedDistance5, MathUtils.distance(aX5, aY5, bX5, bY5), 0.0001, "Distance calculation is incorrect for negative coordinates");
    }
}