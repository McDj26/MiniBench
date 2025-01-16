package org.apache.commons.math4.core.jdkmath;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccurateMathCalcTest {

    @Test
    public void splitReciprocalTest() {
        double[] in = {2.0, 0.0}; // Example input where 2.0 is c and 0.0 is d
        double[] result = new double[2];
        
        // Expected result for 1/(2+0) is 0.5
        double[] expected = {0.5, 0.0}; 
        
        // Call the method under test
        AccurateMathCalc.splitReciprocal(in, result);
        
        // Assert that the result is close to the expected values
        assertEquals(expected[0], result[0], 1e-10, "The first part of the reciprocal is incorrect");
        assertEquals(expected[1], result[1], 1e-10, "The second part of the reciprocal is incorrect");
        
        // Additional case to handle input where c is 0, needing the swap to occur
        double[] in2 = {0.0, 3.0};
        double[] result2 = new double[2];
        
        // Expected result after swap should be the same as 1/3
        double[] expected2 = {1.0/3.0, 0.0};
        
        // Call the method under test
        AccurateMathCalc.splitReciprocal(in2, result2);
        
        // Assert that the result is close to the expected values
        assertEquals(expected2[0], result2[0], 1e-10, "The first part of the reciprocal after swap is incorrect");
        assertEquals(expected2[1], result2[1], 1e-10, "The second part of the reciprocal after swap is incorrect");
    }
}