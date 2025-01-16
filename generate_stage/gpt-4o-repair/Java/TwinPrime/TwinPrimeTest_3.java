package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {

    // Assume that PrimeCheck.isPrime() is a correctly functioning utility method.
    
    @Test
    public void getTwinPrimeTest() {
        // Case 1: Input number is part of a twin prime pair (e.g., 3 and 5)
        assertEquals(5, TwinPrime.getTwinPrime(3), "3 is part of twin prime 3 and 5");

        // Case 2: Input number is not part of a twin prime pair (e.g., 4)
        assertEquals(-1, TwinPrime.getTwinPrime(4), "4 is not part of a twin prime");

        // Case 3: Input number is part of another twin prime pair (e.g., 11 and 13)
        assertEquals(13, TwinPrime.getTwinPrime(11), "11 is part of twin prime 11 and 13");

        // Case 4: Edge case where the input is a small prime not forming a twin prime pair (e.g., 2)
        assertEquals(-1, TwinPrime.getTwinPrime(2), "2 does not form a twin prime pair");

        // Case 5: Edge case with a large prime number as input
        assertEquals(-1, TwinPrime.getTwinPrime(17), "17 does not form a twin prime pair with 19");

        // Case 6: Verify with a larger known twin prime pair (e.g., 29 and 31)
        assertEquals(31, TwinPrime.getTwinPrime(29), "29 is part of twin prime 29 and 31");
    }
}