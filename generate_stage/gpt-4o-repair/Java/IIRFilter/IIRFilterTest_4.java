package com.thealgorithms.audiofilters;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class IIRFilterTest {

    @Test
    public void processTest() {
        int order = 2;
        double[] coeffsA = {1.0, -0.5, 0.25};
        double[] coeffsB = {0.5, 0.5, 0.5};
        
        IIRFilter filter = new IIRFilter(order);
        filter.setCoeffs(coeffsA, coeffsB);
        
        // Test with a sample input
        double sample = 1.0;
        double expectedOutput = 0.5;  // You'll need to calculate the expected output based on the logic
        double actualOutput = filter.process(sample);
        assertEquals(expectedOutput, actualOutput, 0.0001, "The processed sample did not match the expected output.");  // Allow small delta for floating-point comparison

        // Test with another sample (this is optional, add more if needed)
        sample = 2.0;
        expectedOutput = 1.5;  // Adjust this as the expected result for this input
        actualOutput = filter.process(sample);
        assertEquals(expectedOutput, actualOutput, 0.0001, "The processed sample did not match the expected output.");
    }
}