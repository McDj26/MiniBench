package com.thealgorithms.audiofilters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IIRFilterTest {

    @Test
    public void processTest() {
        // Initialize filter parameters
        int order = 2; // assuming order 2 filter for the test
        double[] coeffsA = {1.0, -0.5, 0.25};
        double[] coeffsB = {0.5, 0.3, 0.1};

        // Create an IIR filter instance
        IIRFilter filter = new IIRFilter(order);
        filter.setCoeffs(coeffsA, coeffsB);

        // Define a test sample and expected output
        double sample = 1.0;
        double expectedOutput = (0.5 * sample) / 1.0; // Initial expected output calculation for order = 2
        
        // Run process method
        double output = filter.process(sample);

        // Validate the output
        assertEquals(expectedOutput, output, 1e-9);
        
        // Now process another sample to test the history components
        sample = 2.0;
        expectedOutput = (0.3 * 1.0 + 0.5 * sample - 0.5 * filter.historyY[0]) / 1.0;
        
        // Run process method with new sample
        output = filter.process(sample);

        // Validate the output
        assertEquals(expectedOutput, output, 1e-9);
    }
}