package org.apache.commons.math4.core.jdkmath;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccurateMathCalcTest {

    @Test
    public void splitReciprocalTest() {
        double[] in = {0.25, 1}; // example input for testing
        double[] expectedResult = {4, 0}; // expected result for comparison
        double[] actualResult = new double[2]; // result of the function call
        
        // Call the function to test
        AccurateMathCalc.splitReciprocal(in, actualResult);
        
        // Assert the results are as expected within a reasonable tolerance
        assertEquals(expectedResult[0], actualResult[0], 1e-5); // tolerance set to 1e-5 for comparison
        assertEquals(expectedResult[1], actualResult[1], 1e-14); // might need a smaller tolerance for second value
    }
}