package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {
    @Test
    public void getTwinPrimeTest() {
        // Test case for valid input where both numbers are prime
        int inputNumber = 5; // Assume that inputNumber is prime and (inputNumber + 2) is also prime
        int expectedResult = inputNumber + 2; // Expected result is the twin prime of the input number
        int actualResult = TwinPrime.getTwinPrime(inputNumber); // Get the actual result from the method
        assertEquals(expectedResult, actualResult, "The expected twin prime is not returned."); // Assert the actual result with the expected result
        
        // Test case for invalid input where either number is not prime
        inputNumber = 6; // Assume that inputNumber is not prime but (inputNumber + 2) is prime
        expectedResult = -1; // Expected result is -1 as the input number is not a prime for which twin prime exists
        actualResult = TwinPrime.getTwinPrime(inputNumber); // Get the actual result from the method
        assertEquals(-1, actualResult, "The expected result for non-prime input is not returned."); // Assert the actual result with the expected result
        
        // Test case for negative input (or any other boundary condition)
        inputNumber = -1; // Assuming that the method can handle negative inputs without throwing exceptions, which is not stated in the context
        actualResult = TwinPrime.getTwinPrime(inputNumber); // Get the actual result from the method
        assertEquals(-1, actualResult, "The expected result for negative input should be -1."); // Assert that the result for negative input is -1 as per the current implementation logic
    }
}