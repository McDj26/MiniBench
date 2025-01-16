package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class FFTTest {
    
    @Test
    public void fftTest() {
        ArrayList<FFT.Complex> input = new ArrayList<>();
        input.add(new FFT.Complex(1, 0));
        input.add(new FFT.Complex(1, 0));
        input.add(new FFT.Complex(1, 0));
        input.add(new FFT.Complex(1, 0));
        
        ArrayList<FFT.Complex> expectedOutput = new ArrayList<>();
        expectedOutput.add(new FFT.Complex(4, 0));
        expectedOutput.add(new FFT.Complex(0, 0));
        expectedOutput.add(new FFT.Complex(0, 0));
        expectedOutput.add(new FFT.Complex(0, 0));

        ArrayList<FFT.Complex> result = FFT.fft(input, false);

        for (int i = 0; i < expectedOutput.size(); i++) {
            FFT.Complex expected = expectedOutput.get(i);
            FFT.Complex actual = result.get(i);
            assertEquals(expected.getReal(), actual.getReal(), 1e-9, "Real part mismatch at index " + i);
            assertEquals(expected.getImaginary(), actual.getImaginary(), 1e-9, "Imaginary part mismatch at index " + i);
        }
    }
}