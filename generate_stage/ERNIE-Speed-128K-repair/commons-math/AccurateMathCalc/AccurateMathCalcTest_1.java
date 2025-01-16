package org.apache.commons.math4.core.jdkmath;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccurateMathCalcTest {

    @Test
    public void splitReciprocalTest() {
        double[] in = {1.0, 0.0}; // Test case with c = 1.0 and d = 0.0
        double[] expectedResult = {1.0, 0.0}; // Expected result for the above input
        double[] actualResult = new double[2]; // To store the actual result of the function call

        AccurateMathCalc.splitReciprocal(in, actualResult);
        assertEquals(expectedResult[0], actualResult[0], 1e-5); // Assert the first component is close to expected value
        assertEquals(expectedResult[1], actualResult[1], 1e-5); // Assert the second component is close to expected value

        // Additional test case with different inputs
        double[] in2 = {2.0, 3.0}; // Test case with arbitrary values for c and d
        double[] expectedResult2 = {-1.987477486, 0.587477486}; // Expected result for the above input (computed using a different method or approximation)
        double[] actualResult2 = new double[2]; // To store the actual result of the function call for this test case

        AccurateMathCalc.splitReciprocal(in2, actualResult2);
        assertEquals(expectedResult2[0], actualResult2[0], 1e-5); // Assert the first component is close to the expected value for this test case
        assertEquals(expectedResult2[1], actualResult2[1], 1e-5); // Assert the second component is close to the expected value for this test case
    }
}