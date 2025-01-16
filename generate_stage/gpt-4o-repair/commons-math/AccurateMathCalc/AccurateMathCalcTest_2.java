package org.apache.commons.math4.core.jdkmath;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccurateMathCalcTest {

    @Test
    public void splitReciprocalTest() {
        // Input setup
        double[] in = {2.0, 0.0}; // Example input
        double[] result = new double[2];

        // Expected result setup (calculated based on expected reciprocal)
        double[] expected = new double[2];
        AccurateMathCalc.split(1.0 / 2.0, expected);

        // Method under test
        AccurateMathCalc.splitReciprocal(in, result);

        // Verify each part of the result with an acceptable error margin
        assertEquals(expected[0], result[0], 1e-12, "Result[0] did not match expected value");
        assertEquals(expected[1], result[1], 1e-12, "Result[1] did not match expected value");
    }
}