package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class FFTTest {
    @Test
    public void fftTest() {
        // Sample test case for FFT algorithm with simple signal and non-inverse FFT
        ArrayList<Complex> signal = new ArrayList<>();
        signal.add(new Complex(1, 0)); // Test with a simple signal
        signal.add(new Complex(2, 0));
        signal.add(new Complex(3, 0)); // Padded with zero for 8 power of two
        signal.add(new Complex(0, 0)); // Padded with zero for 8 power of two
        signal.add(new Complex(5, 0)); // Padded with zero for 8 power of two
        signal.add(new Complex(6, 0)); // Padded with zero for 8 power of two
        signal.add(new Complex(7, 0)); // Padded with zero for 8 power of two
        signal.add(new Complex(0, 0)); // Padded with zero for 8 power of two
        signal = FFT.fftBitReversal(signal.size(), Integer.toBinaryString(signal.size()).length(), signal); // Bit reversal permutation
        ArrayList<Complex> result = FFT.fft(signal, false); // Perform FFT on the signal without inverse operation
        assertNotNull(result); // Assert that the result is not null
        assertEquals(signal.size(), result.size()); // Assert that the size of the result is equal to the input size after padding (since we are using padding to make it a power of two)
        // Perform further assertions on the actual FFT values if you have a reference or expected output
    }
}