package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {

    @Test
    public void testGetTwinPrimeWithTwinPrimes() {
        // Testing a known pair of twin primes: 3 and 5
        assertEquals(5, TwinPrime.getTwinPrime(3));
        // Testing another known pair: 11 and 13
        assertEquals(13, TwinPrime.getTwinPrime(11));
    }

    @Test
    public void testGetTwinPrimeWithNonPrime() {
        // Testing when the input is not a prime number
        assertEquals(-1, TwinPrime.getTwinPrime(4));
    }
    
    @Test
    public void testGetTwinPrimeWithNonTwinPrimes() {
        // Testing a prime that is part of non-twin primes
        assertEquals(-1, TwinPrime.getTwinPrime(2)); // 2 and 4, where 4 is not prime
        assertEquals(-1, TwinPrime.getTwinPrime(37)); // 37 and 39, where 39 is not prime
    }

    @Test
    public void testGetTwinPrimeWithNegativeInput() {
        // Testing a negative input for robust handling
        assertEquals(-1, TwinPrime.getTwinPrime(-5));
    }

    @Test
    public void testGetTwinPrimeWithLargeNumber() {
        // Testing with a known larger twin prime number
        assertEquals(101, TwinPrime.getTwinPrime(99)); // 101 is twin prime of 99
    }
}