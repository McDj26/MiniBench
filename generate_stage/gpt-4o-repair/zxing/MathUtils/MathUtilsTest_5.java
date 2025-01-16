package com.google.zxing.common.detector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void distanceTest() {
        // Test case 1: Points are the same
        assertEquals(0.0f, MathUtils.distance(0, 0, 0, 0), 0.0001f);

        // Test case 2: Points are on the x-axis
        assertEquals(3.0f, MathUtils.distance(1, 0, 4, 0), 0.0001f);

        // Test case 3: Points are on the y-axis
        assertEquals(4.0f, MathUtils.distance(0, 0, 0, 4), 0.0001f);

        // Test case 4: General case with positive coordinates
        assertEquals(5.0f, MathUtils.distance(1, 1, 4, 5), 0.0001f);

        // Test case 5: General case with negative coordinates
        assertEquals(5.0f, MathUtils.distance(-1, -1, -4, -5), 0.0001f);

        // Test case 6: Mixed positive and negative coordinates
        assertEquals(7.8102f, MathUtils.distance(-3, 2, 4, -4), 0.0001f);
    }
}