package com.google.zxing.common.detector;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    public void distanceTest() {
        // Test case for distance method with integer inputs
        int aX = 10, aY = 20, bX = 30, bY = 40; // Test points coordinates
        float expectedDistance = (float) Math.sqrt((aX - bX) * (aX - bX) + (aY - bY) * (aY - bY));
        float actualDistance = MathUtils.distance(aX, aY, bX, bY);
        assertEquals(expectedDistance, actualDistance, "Distance calculation with integer inputs is incorrect.");
        
        // Test case for distance method with float inputs
        float aXf = 5.5f, aYf = 7.5f, bXf = 9f, bYf = 11f; // Test points coordinates with float values
        expectedDistance = (float) Math.sqrt((aXf - bXf) * (aXf - bXf) + (aYf - bYf) * (aYf - bYf));
        actualDistance = MathUtils.distance(aXf, aYf, bXf, bYf);
        assertEquals(expectedDistance, actualDistance, "Distance calculation with float inputs is incorrect.");
        
        // Additional test case for negative coordinates
        int negativeAX = -10, negativeAY = -20, negativeBX = -30, negativeBY = -40; // Negative test points coordinates
        expectedDistance = (float) Math.sqrt((negativeAX - negativeBX) * (negativeAX - negativeBX) + (negativeAY - negativeBY) * (negativeAY - negativeBY));
        actualDistance = MathUtils.distance(negativeAX, negativeAY, negativeBX, negativeBY);
        assertEquals(expectedDistance, actualDistance, "Distance calculation with negative inputs is incorrect.");
    }
}