package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {

    @Test
    public void testValidTwinPrime() {
        // Testing with a known twin prime
        assertEquals(5, TwinPrime.getTwinPrime(3), 
                     "3 and 5 should be twin primes.");
        assertEquals(11, TwinPrime.getTwinPrime(9), 
                     "9 and 11 should be twin primes.");
    }

    @Test
    public void testInvalidTwinPrime() {
        // Testing with a number that does not have a twin prime
        assertEquals(-1, TwinPrime.getTwinPrime(4), 
                     "4 does not have a twin prime.");
        assertEquals(-1, TwinPrime.getTwinPrime(10), 
                     "10 does not have a twin prime.");
    }

    @Test
    public void testEdgeCases() {
        // Testing with edge cases
        assertEquals(-1, TwinPrime.getTwinPrime(0), 
                     "0 does not have a twin prime.");
        assertEquals(-1, TwinPrime.getTwinPrime(-3), 
                     "-3 does not have a twin prime.");
        assertEquals(-1, TwinPrime.getTwinPrime(1), 
                     "1 does not have a twin prime.");
    }
}