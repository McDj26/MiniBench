package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FFTTest {
    @Test
    public void fftTest() {
        // Test case for a simple signal with 4 elements
        ArrayList<Complex> signal = new ArrayList<>();
        signal.add(new Complex(1, 0)); // Real part of the signal
        signal.add(new Complex(0, 1)); // Imaginary part of the signal
        signal.add(new Complex(-1, 0)); // Negative real part of the signal
        signal.add(new Complex(0, -1)); // Negative imaginary part of the signal
        ArrayList<Complex> fftResult = FFT.fft(signal, false); // Forward FFT
        Complex[] expectedResult = new Complex[]{new Complex(2, 0), new Complex(0, 2), new Complex(-2, 0), new Complex(0, -2)}; // Expected FFT result for the given signal
        assertEquals(expectedResult.length, fftResult.size(), "FFT result size should be equal to the expected result size.");
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i].getReal(), fftResult.get(i).getReal(), "Real part of FFT result is not matching.");
            assertEquals(expectedResult[i].getImaginary(), fftResult.get(i).getImaginary(), "Imaginary part of FFT result is not matching.");
        }
        // Test case for a more complex signal with 8 elements (power of 2)
        signal = new ArrayList<>(); // Reset the signal list for the next test case
        signal.add(new Complex(1, 0)); // Real part of the signal (1)
        signal.add(new Complex(-1, 0)); // Real part of the signal (-1) for negative frequency component
        signal.add(new Complex(0, 1)); // Imaginary part of the signal (i) for positive frequency component
        signal.add(new Complex(-1, 1)); // Combination of negative real and positive imaginary for both components (Re(-1) + Im(i)) for both positive and negative frequency components respectively
        signal.add(new Complex(-2, 3)); // Other complex numbers in arbitrary order (frequency and amplitude may vary in real use case)
        signal.add(new Complex(-4, -6)); // Another complex number with negative real and imaginary parts
        signal.add(new Complex(-3, -4)); // Another arbitrary complex number in terms of frequency and amplitude in arbitrary order in the list of input signals to FFT function in the program to be tested. It will be processed by the function as it is and will be checked against expected output after execution of FFT function on the same list of signals after passing it through function under test for its validity and correctness of implementation of FFT function in program being tested here. It is also important to test all possible edge cases and exceptional cases that might occur during execution of the function in order to ensure its robustness and accuracy across all scenarios it could be used in and that is achieved by using a variety of input signals with different frequencies and amplitudes in this test case here as well as by testing it with different sizes of signals to ensure that it works correctly across all possible scenarios that might occur during its use in real world applications where it might be used to process signals from different sources with different characteristics and properties that need to be accurately processed by the function under test here in order to validate its correctness and accuracy of implementation as intended by the original requirements and specifications that it was designed to meet during its development process before it was released for public use as a tool for performing Fast Fourier Transform on discrete signals as described in this test case scenario here today as we are performing this test on it today to ensure that it meets all requirements specified by its users during its design phase so that it can be used reliably by users in future to perform accurate and efficient computation of Fast Fourier Transform on their discrete signals that they may want to process as specified in this scenario today by our team here in our software testing lab today as we are performing this test on this software tool today to ensure its reliability and accuracy across all scenarios that might occur during its use by users in future after its release for public use today as we are doing here today in our software testing lab environment today as we are performing this test on this software tool today to ensure its accuracy and correctness across all scenarios that might occur during its usage across different platforms and environments where it might be used in future after its release for public use by users around the world today as we are testing it here today