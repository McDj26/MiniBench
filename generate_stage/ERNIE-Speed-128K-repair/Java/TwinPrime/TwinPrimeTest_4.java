package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {
    @Test
    public void getTwinPrimeTest() {
        // Test case for valid input where both numbers are prime
        int inputNumber = 5; // Assuming 5 and 7 are both prime numbers
        int expectedResult = 7; // Expected twin prime of 5 is 7
        assertEquals(expectedResult, TwinPrime.getTwinPrime(inputNumber));
        
        // Test case for invalid input where both numbers are not prime
        inputNumber = 4; // Both 4 and 6 are not prime numbers
        expectedResult = -1; // Expected result should be -1 for invalid input
        assertEquals(-1, TwinPrime.getTwinPrime(inputNumber));
        
        // Test case for prime number but the next number is not prime
        inputNumber = 7; // 7 is a prime number but 9 is not a prime number
        expectedResult = -1; // Expected result should be -1 as the next number is not prime
        assertEquals(-1, TwinPrime.getTwinPrime(inputNumber));
        
        // Test case for the number one (as per Java rules it should be considered as valid input)
        inputNumber = 1; // Both 1 and 3 are not prime numbers (considering 1 as not prime)
        expectedResult = -1; // Expected result should be -1 for invalid input as per the context logic
        assertEquals(-1, TwinPrime.getTwinPrime(inputNumber));
    }
}