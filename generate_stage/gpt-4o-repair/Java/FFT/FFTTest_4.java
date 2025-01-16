package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class FFTTest {

    @Test
    public void fftTest() {
        // Create test data: {1 + 0i, 1 + 0i, 0 + 0i, 0 + 0i}
        ArrayList<FFT.Complex> testInput = new ArrayList<>();
        testInput.add(new FFT.Complex(1, 0));
        testInput.add(new FFT.Complex(1, 0));
        testInput.add(new FFT.Complex(0, 0));
        testInput.add(new FFT.Complex(0, 0));

        // Expected output for the input after FFT:
        // {2 + 0i, 1 + 0i, 0 + 0i, 1 + 0i}, based on the FFT property
        ArrayList<FFT.Complex> expectedOutput = new ArrayList<>();
        expectedOutput.add(new FFT.Complex(2, 0));
        expectedOutput.add(new FFT.Complex(1, 0));
        expectedOutput.add(new FFT.Complex(0, 0));
        expectedOutput.add(new FFT.Complex(1, 0));

        // Perform the FFT
        ArrayList<FFT.Complex> actualOutput = FFT.fft(testInput, false);

        // Validate the actual output with the expected output
        for (int i = 0; i < actualOutput.size(); i++) {
            assertEquals(expectedOutput.get(i).getReal(), actualOutput.get(i).getReal(), 1e-9, "Real part mismatch at index " + i);
            assertEquals(expectedOutput.get(i).getImaginary(), actualOutput.get(i).getImaginary(), 1e-9, "Imaginary part mismatch at index " + i);
        }
    }
}