package com.thealgorithms.audiofilters;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class IIRFilterTest {

    @Test
    public void processTest() {
        int order = 2; // Define the order of the filter
        double[] aCoeffs = {1.0, -0.5, 0.25}; // Example coefficients for A
        double[] bCoeffs = {0.5, 0.1, 0.05}; // Example coefficients for B

        IIRFilter filter = new IIRFilter(order);
        filter.setCoeffs(aCoeffs, bCoeffs);

        double inputSample = 1.0;
        double expectedOutput = (bCoeffs[0] * inputSample) / aCoeffs[0]; // Expected result calculation for an initialized state where historyX and historyY are zeros

        // This initial expected output assumes no history yet, meaning only the input sample is being processed
        double actualOutput = filter.process(inputSample);

        assertEquals(expectedOutput, actualOutput, 1e-9, "The processed sample should match the expected output");
    }
}