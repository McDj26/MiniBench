package com.google.zxing.common.detector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    public void distanceTest() {
        // Test case 1: Positive coordinates
        assertEquals(5.0f, MathUtils.distance(0, 0, 3, 4), 0.0001f);

        // Test case 2: Same point
        assertEquals(0.0f, MathUtils.distance(2, 2, 2, 2), 0.0001f);

        // Test case 3: Negative and positive coordinates
        assertEquals(5.0f, MathUtils.distance(-3, -4, 0, 0), 0.0001f);

        // Test case 4: Mixed coordinates
        assertEquals(10.0f, MathUtils.distance(-6, 8, 2, 2), 0.0001f);
    }
}