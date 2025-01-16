package com.thealgorithms.audiofilters;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class IIRFilterTest {
    private IIRFilter iirFilter;
    private static final int ORDER = 3; // Assuming the order of the filter is 3 for this test case
    private static final double[] A_COEFFS = {1.0, 0.1, 0.2}; // Example coefficients for testing
    private static final double[] B_COEFFS = {0.5, 0.3, 0.8}; // Example coefficients for testing

    @BeforeEach
    public void setUp() {
        iirFilter = new IIRFilter(ORDER);
        iirFilter.setCoeffs(A_COEFFS, B_COEFFS); // Assuming setCoeffs method exists and works properly
    }

    @Test
    public void processTest() {
        double sample = 1.0; // Test sample value
        double expectedResult = iirFilter.process(sample); // Expected result from the process method
        double actualResult = iirFilterTest.processTestInput(); // Assuming iirFilterTest is a utility class with a method to test process method with given sample and coefficients
        assertEquals(expectedResult, actualResult, "The processed sample did not match the expected result.");
    }

    // Utility method to test the process method with a given sample value and coefficients
    public double iirFilterTestProcessInput() {
        return iirFilter.process(sample); // This will be used to return the actual result of the process method with a given sample value and coefficients set earlier in the setUp method
    }
}