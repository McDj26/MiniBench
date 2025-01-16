package com.thealgorithms.audiofilters;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class IIRFilterTest {

    @Test
    public void processTest() {
        int order = 2;
        double[] coeffsA = {1.0, -0.5, 0.25};
        double[] coeffsB = {0.4, 0.3, 0.2};
        
        IIRFilter filter = new IIRFilter(order);
        filter.setCoeffs(coeffsA, coeffsB);
        
        // Testing processing of a sample, assuming some initial sample value
        double inputSample = 1.0;
        double expected = (0.4 * inputSample) / 1.0;  // initial computation with zeroed history
        
        double result = filter.process(inputSample);
        
        assertEquals(expected, result, 1e-9, "The processed sample did not match the expected value.");

        // Optionally: Additional assertions and processing steps can be tested here.
    }
}