package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FFTTest {
    @Test
    public void fftTest() {
        ArrayList<Complex> x = new ArrayList<>();
        x.add(new Complex(1, 0)); // Add your other complex numbers here to test the FFT function
        x.add(new Complex(0, 1)); // For example, you can add more signals to x
        // ... add more signals if necessary to make the size a power of 2
        boolean inverse = false; // Set to true if you want to test the inverse FFT
        ArrayList<Complex> result = FFT.fft(x, inverse);
        
        // Test the result against expected values or other known solutions
        assertEquals(x.size(), result.size(), "The size of the result should be equal to the size of the input.");
        // You can add more assertions here to check specific values in the result
        // For example:
        // assertEquals(result.get(0).getReal(), expectedValue1, "The real part of the result at index 0 should be equal to expectedValue1");
        // assertEquals(result.get(0).getImaginary(), expectedValue2, "The imaginary part of the result at index 0 should be equal to expectedValue2");
        // ... add more assertions for other indices and values if necessary
    }
}

Note: You need to add more complex numbers to the `x` list to make sure the size of the input signal is a power of 2, as specified in the source code comments. Also, you can add more assertions to check specific values in the FFT result against expected values or other known solutions. These expected values should be calculated using other methods or verified using other sources.