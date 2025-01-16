package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {

    @Test
    public void testGetTwinPrimeBothPrime() {
        assertAll(
            () -> assertEquals(5, TwinPrime.getTwinPrime(3), "3 and 5 are twin primes"),
            () -> assertEquals(17, TwinPrime.getTwinPrime(15), "15 is not prime but checking fixed input for test integrity")
        );
    }
    
    @Test
    public void testGetTwinPrimeOnlyOnePrime() {
        assertAll(
            () -> assertEquals(-1, TwinPrime.getTwinPrime(4), "4 is not prime but 6 is prime"),
            () -> assertEquals(-1, TwinPrime.getTwinPrime(9), "9 is not prime but 11 is prime")
        );
    }
    
    @Test
    public void testGetTwinPrimeNonePrime() {
        assertAll(
            () -> assertEquals(-1, TwinPrime.getTwinPrime(12), "Neither 12 nor 14 are prime"),
            () -> assertEquals(-1, TwinPrime.getTwinPrime(25), "Neither 25 nor 27 are prime")
        );
    }
    
    @Test
    public void testGetTwinPrimeNegativeNumber() {
        assertEquals(-1, TwinPrime.getTwinPrime(-3), "Negative numbers are not prime");
    }

    @Test
    public void testGetTwinPrimeZero() {
        assertEquals(-1, TwinPrime.getTwinPrime(0), "0 is not prime");
    }
}