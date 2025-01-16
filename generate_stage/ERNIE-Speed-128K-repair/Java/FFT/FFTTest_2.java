package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class FFTTest {
    @Test
    public void fftTest() {
        // Test case for FFT with a simple signal of size 4
        ArrayList<Complex> signal = new ArrayList<>();
        signal.add(new Complex(1, 0)); // Real value 1
        signal.add(new Complex(0, 1)); // Imaginary value 1 (i.e., sin(π/2)) for a simple sine wave of frequency π/2
        signal.add(new Complex(-1, 0)); // Real value -1
        signal.add(new Complex(0, -1)); // Imaginary value -1 (i.e., sin(-π/2)) for a simple sine wave of frequency π/2 with negative imaginary part
        ArrayList<Complex> expectedFFT = new ArrayList<>();
        expectedFFT.add(new Complex(2, 0)); // Expected FFT output: real part is sum of all real values, imaginary part is sum of all imaginary values
        expectedFFT.add(new Complex(-Complex.sqrt(2)/2, Complex.sqrt(2)/2)); // Expected FFT output for sin(π/2) component
        expectedFFT.add(new Complex(-2, 0)); // Expected FFT output for repeated value (-1) with phase shift π
        expectedFFT.add(new Complex(-Complex.sqrt(2)/2, -Complex.sqrt(2)/2)); // Expected FFT output for sin(-π/2) component with phase shift π and sign change in imaginary part
        ArrayList<Complex> actualFFT = FFT.fft(signal, false); // Perform the FFT without inverse mode
        assertEquals(expectedFFT, actualFFT); // Assert that the expected and actual FFT outputs are equal
    }
}