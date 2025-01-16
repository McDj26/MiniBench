package com.google.zxing.common.detector;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    public void distanceTest() {
        // Test distance with integer coordinates
        int aX = 3; // Test coordinate X for point A
        int aY = 4; // Test coordinate Y for point A
        int bX = 5; // Test coordinate X for point B
        int bY = 6; // Test coordinate Y for point B
        float expectedDistance = (float) Math.sqrt((aX - bX) * (aX - bX) + (aY - bY) * (aY - bY)); // Expected distance between points A and B
        float actualDistance = MathUtils.distance(aX, aY, bX, bY); // Distance calculated by the method to test
        assertEquals(expectedDistance, actualDistance, "The distance should be equal to the expected value."); // Assert the actual distance is equal to the expected distance
        
        // Test distance with float coordinates
        float aXf = 3.5f; // Test coordinate X for point A in float format
        float aYf = 4.5f; // Test coordinate Y for point A in float format
        float bXf = 5.6f; // Test coordinate X for point B in float format
        float bYf = 6.7f; // Test coordinate Y for point B in float format
        expectedDistance = (float) Math.sqrt((aXf - bXf) * (aXf - bXf) + (aYf - bYf) * (aYf - bYf)); // Expected distance between points A and B in float format
        actualDistance = MathUtils.distance(aXf, aYf, bXf, bYf); // Distance calculated by the method to test with float inputs
        assertEquals(expectedDistance, actualDistance, "The distance with float inputs should be equal to the expected value."); // Assert the actual distance is equal to the expected distance with float inputs
    }
}