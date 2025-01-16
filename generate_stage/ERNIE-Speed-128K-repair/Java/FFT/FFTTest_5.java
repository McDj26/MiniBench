package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FFTTest {
    @Test
    public void fftTest() {
        ArrayList<Complex> inputSignal = new ArrayList<>();
        inputSignal.add(new Complex(1, 0)); // Sample signal: cos(0)
        inputSignal.add(new Complex(1, 1)); // Sample signal: cos(pi/2) + sin(pi/2) = sin(pi/2) = 1
        inputSignal.add(new Complex(0, 1)); // Sample signal: sin(pi) = 0 (should be padded with zeros)
        boolean inverseFFT = false; // Perform the forward FFT, not the inverse one
        ArrayList<Complex> result = FFT.fft(inputSignal, inverseFFT); // Execute the FFT algorithm
        assertNotNull(result); // Ensure the result is not null
        assertEquals(inputSignal.size(), result.size()); // Ensure the size of the result is the same as the input signal size (padded with zeros)
        // Assert that some specific components are close to the expected values for FFT of simple signals (for testing purposes)
        // The precision might be not perfect due to floating-point arithmetic approximations and complexity of the FFT algorithm itself
        assertTrue(Math.abs((result.get(0)).getReal() - (double)(inputSignal.get(0)).getReal()) < 0.05); // Expect cos(0) close to 1 (since the first value of FFT of cos(0) is its DC component, it should be 1 in case of pure cosine)
        assertTrue(Math.abs((result.get(1)).getReal() - (double)(inputSignal.get(1)).getReal()) < 0.05); // Expect sin(pi/2) close to 1 (since the first value of FFT of sin should be ~ImaginaryComponent at frequency index pi/omega)
        assertTrue(Math.abs((result.get(result.size()-1)).getReal() < 0.5); // Expect the last value to be close to zero due to padding with zeros and zero frequency component in Fourier Transform output after summing the coefficients at frequency indexes multiplied by imaginary exponent zero, which should result in zero or very close to zero value due to rounding errors in floating-point arithmetic calculations
    }
}