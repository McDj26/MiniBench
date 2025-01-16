package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class FFTTest {

    @Test
    public void fftTest() {
        // Test case for FFT
        ArrayList<FFT.Complex> inputSignal = new ArrayList<>();
        inputSignal.add(new FFT.Complex(1, 0));
        inputSignal.add(new FFT.Complex(1, 0));
        inputSignal.add(new FFT.Complex(1, 0));
        inputSignal.add(new FFT.Complex(1, 0));

        ArrayList<FFT.Complex> expectedOutput = new ArrayList<>();
        expectedOutput.add(new FFT.Complex(4, 0));
        expectedOutput.add(new FFT.Complex(0, 0));
        expectedOutput.add(new FFT.Complex(0, 0));
        expectedOutput.add(new FFT.Complex(0, 0));

        ArrayList<FFT.Complex> result = FFT.fft(inputSignal, false);

        assertEquals(expectedOutput.size(), result.size(), "The size of output does not match expected size.");
        
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertEquals(expectedOutput.get(i).getReal(), result.get(i).getReal(), 1e-9, "Real part does not match at index " + i);
            assertEquals(expectedOutput.get(i).getImaginary(), result.get(i).getImaginary(), 1e-9, "Imaginary part does not match at index " + i);
        }
    }

    @Test
    public void inverseFftTest() {
        // Test case for Inverse FFT
        ArrayList<FFT.Complex> inputSignal = new ArrayList<>();
        inputSignal.add(new FFT.Complex(4, 0));
        inputSignal.add(new FFT.Complex(0, 0));
        inputSignal.add(new FFT.Complex(0, 0));
        inputSignal.add(new FFT.Complex(0, 0));

        ArrayList<FFT.Complex> expectedOutput = new ArrayList<>();
        expectedOutput.add(new FFT.Complex(1, 0));
        expectedOutput.add(new FFT.Complex(1, 0));
        expectedOutput.add(new FFT.Complex(1, 0));
        expectedOutput.add(new FFT.Complex(1, 0));

        ArrayList<FFT.Complex> result = FFT.fft(inputSignal, true);

        assertEquals(expectedOutput.size(), result.size(), "The size of output does not match expected size.");
        
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertEquals(expectedOutput.get(i).getReal(), result.get(i).getReal(), 1e-9, "Real part does not match at index " + i);
            assertEquals(expectedOutput.get(i).getImaginary(), result.get(i).getImaginary(), 1e-9, "Imaginary part does not match at index " + i);
        }
    }
}