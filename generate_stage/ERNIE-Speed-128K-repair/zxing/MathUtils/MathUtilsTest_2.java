package com.google.zxing.common.detector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    public void distanceTest() {
        // Test case for distance method with integer inputs
        int aX = 5;
        int aY = 10;
        int bX = 15;
        int bY = 20;
        float expectedDistance = Math.sqrt(MathUtils.distance(aX, aY, bX, bY)); // Expected distance is calculated manually for comparison
        float actualDistance = MathUtils.distance(aX, aY, bX, bY); // Using the method to be tested
        assertEquals(expectedDistance, actualDistance, 0.0f); // Assert that the actual distance is close to the expected distance
        
        // Test case for distance method with float inputs
        float aXFloat = 5.5f;
        float aYFloat = 10.3f;
        float bXFloat = 15.8f;
        float bYFloat = 20.6f;
        float expectedDistanceFloat = (float) Math.sqrt((aXFloat - bXFloat) * (aXFloat - bXFloat) + (aYFloat - bYFloat) * (aYFloat - bYFloat)); // Expected distance is calculated manually for comparison
        float actualDistanceFloat = MathUtils.distance(aXFloat, aYFloat, bXFloat, bYFloat); // Using the method to be tested with float inputs
        assertEquals(expectedDistanceFloat, actualDistanceFloat, 0.0f); // Assert that the actual distance is close to the expected distance for float inputs too
    }
}