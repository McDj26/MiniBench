package com.google.zxing.common.detector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    
    @Test
    public void distanceTest() {
        // Test case 1: Zero distance
        assertEquals(0.0f, MathUtils.distance(0, 0, 0, 0), 0.0001f, "Distance should be zero for identical points");

        // Test case 2: Positive distance
        assertEquals(5.0f, MathUtils.distance(0, 0, 3, 4), 0.0001f, "Distance should be 5.0 for (0,0) to (3,4)");

        // Test case 3: Negative coordinates
        assertEquals(5.0f, MathUtils.distance(-3, -4, 0, 0), 0.0001f, "Distance should be 5.0 for (-3,-4) to (0,0)");

        // Test case 4: Mixed positive and negative coordinates
        assertEquals(10.0f, MathUtils.distance(5, -5, -5, 5), 0.0001f, "Distance should be 10.0 for (5,-5) to (-5,5)");
        
        // Test case 5: Horizontal distance
        assertEquals(4.0f, MathUtils.distance(2, 0, 6, 0), 0.0001f, "Distance should be 4.0 for (2,0) to (6,0)");

        // Test case 6: Vertical distance
        assertEquals(7.0f, MathUtils.distance(0, 2, 0, 9), 0.0001f, "Distance should be 7.0 for (0,2) to (0,9)");
    }
}