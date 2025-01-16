package com.thealgorithms.audiofilters;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class IIRFilterTest {

    @Test
    public void processTest() {
        int order = 2;
        double[] coeffsA = {1.0, -0.5, 0.25};
        double[] coeffsB = {0.5, 0.0, -0.25};
        
        // Create an instance of IIRFilter with the specified order
        IIRFilter filter = new IIRFilter(order);

        // Set the filter coefficients
        filter.setCoeffs(coeffsA, coeffsB);

        // Test the process method with a sample value
        double sample = 1.0;
        double expectedProcessedSample = (0.5 * sample - 0.5 * 0 - 0.25 * 0) / 1.0; // Simplified calculation
        
        double processedSample = filter.process(sample);
        
        // Assert that the processed sample is as expected
        assertEquals(expectedProcessedSample, processedSample, 1e-9, "The processed sample is incorrect");
    }
}