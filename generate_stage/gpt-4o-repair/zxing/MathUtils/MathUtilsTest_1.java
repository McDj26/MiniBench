package com.google.zxing.common.detector;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void distanceTest() {
        // Test with points at (0, 0) and (0, 0)
        assertEquals(0.0f, MathUtils.distance(0, 0, 0, 0), 0.0001);

        // Test with points at (0, 0) and (3, 4)
        assertEquals(5.0f, MathUtils.distance(0, 0, 3, 4), 0.0001);

        // Test with points at (1, 1) and (4, 5)
        assertEquals(5.0f, MathUtils.distance(1, 1, 4, 5), 0.0001);

        // Test with negative coordinates
        assertEquals(5.0f, MathUtils.distance(-1, -1, -4, -5), 0.0001);

        // Test with points at (-3, -4) and (3, 4)
        assertEquals(10.0f, MathUtils.distance(-3, -4, 3, 4), 0.0001);
    }
}