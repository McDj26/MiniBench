package org.apache.commons.math4.core.jdkmath;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccurateMathCalcTest {
    @Test
    public void splitReciprocalTest() {
        double[] in = {2.0, 0.0};
        double[] result = new double[2];
        
        AccurateMathCalc.splitReciprocal(in, result);

        // Verifying the results
        double expected_x = 0.5;   // 1.0 / 2.0 = 0.5, the leading part
        double expected_y = 0.0;   // Since original second component of 'in' is 0.0
        
        // Check x is close to expected value
        assertEquals(expected_x, result[0], 1e-15);
        
        // Check y is small, acceptable difference because b * in[0] - a * in[1] should be very small
        assertEquals(expected_y, result[1], 1e-15);
        
        // Further test with a non-zero second part
        double[] in2 = {2.0, -1e-14};
        double[] result2 = new double[2];
        
        AccurateMathCalc.splitReciprocal(in2, result2);

        // Test the correctness of results
        double reconstructed = result2[0] + result2[1];
        double original_reciprocal = 1.0 / (in2[0] + in2[1]);
        
        // Test reconstructed sum is close to true reciprocal
        assertEquals(original_reciprocal, reconstructed, 1e-15);
    }
}