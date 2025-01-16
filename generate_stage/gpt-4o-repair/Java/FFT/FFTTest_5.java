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

        assertEquals(expectedOutput.size(), result.size(), "The output size is incorrect.");
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertEquals(expectedOutput.get(i).getReal(), result.get(i).getReal(), 0.0001, "Real part at index " + i + " is incorrect.");
            assertEquals(expectedOutput.get(i).getImaginary(), result.get(i).getImaginary(), 0.0001, "Imaginary part at index " + i + " is incorrect.");
        }
    }
}