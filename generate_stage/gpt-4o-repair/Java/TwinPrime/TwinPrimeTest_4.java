package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {
    @Test
    public void getTwinPrimeTest() {
        // Test case 1: input is a known twin prime (e.g., 3)
        assertEquals(5, TwinPrime.getTwinPrime(3), "3 is a twin prime with 5");

        // Test case 2: input is not a prime number (e.g., 4)
        assertEquals(-1, TwinPrime.getTwinPrime(4), "4 is not a prime number");

        // Test case 3: input is a prime but does not have a twin prime (e.g., 11)
        assertEquals(-1, TwinPrime.getTwinPrime(11), "11 is a prime but 13 is not twin with any");

        // Test case 4: input is a negative number (e.g., -5)
        assertEquals(-1, TwinPrime.getTwinPrime(-5), "-5 is not a positive integer");

        // Test case 5: input is zero, which is not a prime number
        assertEquals(-1, TwinPrime.getTwinPrime(0), "0 is not a prime number");

        // Test case 6: input is a large prime number with a twin (e.g., 41)
        assertEquals(43, TwinPrime.getTwinPrime(41), "41 and 43 are twin primes");
    }
}