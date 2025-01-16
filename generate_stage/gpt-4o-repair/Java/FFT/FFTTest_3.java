package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class FFTTest {
    @Test
    public void fftTest() {
        ArrayList<FFT.Complex> signal = new ArrayList<>();
        // Adding sample complex numbers to the input signal
        signal.add(new FFT.Complex(1, 0));
        signal.add(new FFT.Complex(2, 0));
        signal.add(new FFT.Complex(3, 0));
        signal.add(new FFT.Complex(4, 0));
        signal.add(new FFT.Complex(0, 0)); // Zero padding
        signal.add(new FFT.Complex(0, 0)); // Zero padding
        signal.add(new FFT.Complex(0, 0)); // Zero padding
        signal.add(new FFT.Complex(0, 0)); // Zero padding

        // Perform FFT
        ArrayList<FFT.Complex> fftResult = FFT.fft(signal, false);

        // Perform Inverse FFT
        ArrayList<FFT.Complex> ifftResult = FFT.fft(fftResult, true);

        // Validate if the IFFT result approximates the original signal within a tolerance
        for (int i = 0; i < 4; i++) {
            assertEquals(signal.get(i).getReal(), ifftResult.get(i).getReal(), 1e-9);
            assertEquals(signal.get(i).getImaginary(), ifftResult.get(i).getImaginary(), 1e-9);
        }
    }
}