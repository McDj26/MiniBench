package org.apache.commons.math4.core.jdkmath;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccurateMathCalcTest {

    @Test
    public void splitReciprocalTest() {
        // Test case 1: Normal input
        double[] input = {4.0, 0.5};
        double[] result = new double[2];
        AccurateMathCalc.splitReciprocal(input, result);
        double expectedReciprocal = 1.0 / (input[0] + input[1]);
        
        // Validate the result: result[0] + result[1] should be approximately equal to expectedReciprocal
        assertEquals(expectedReciprocal, result[0] + result[1], 1e-15);

        // Test case 2: Input where in[0] is zero
        double[] inputZero = {0.0, 2.0};
        AccurateMathCalc.splitReciprocal(inputZero, result);
        expectedReciprocal = 1.0 / (inputZero[0] + inputZero[1]);
        
        assertEquals(expectedReciprocal, result[0] + result[1], 1e-15);

        // Test case 3: Large input values
        double[] largeInput = {1e150, 1e150};
        AccurateMathCalc.splitReciprocal(largeInput, result);
        expectedReciprocal = 1.0 / (largeInput[0] + largeInput[1]);
        
        // For large numbers, check the precision of the computation is within a reasonable range
        assertEquals(expectedReciprocal, result[0] + result[1], 1e-300);

        // Additional test cases can cover edge cases like NaN, negative numbers, etc.
    }
}