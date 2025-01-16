package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {
    @Test
    public void getTwinPrimeTest() {
        // Test Case 1: Input is a prime number and (input + 2) is also a prime number
        int inputNumber = 5; // 5 is a prime number and (5 + 2) = 7 is also a prime number
        int expectedResult = inputNumber + 2; // Expected result should be 7
        int actualResult = TwinPrime.getTwinPrime(inputNumber); // Actual result from the method
        assertEquals(expectedResult, actualResult, "The method should return the twin prime of the input.");
        
        // Test Case 2: Input is a prime number but (input + 2) is not a prime number
        inputNumber = 3; // 3 is a prime number but (3 + 2) = 5 is not a prime number (has divisors other than 1 and itself)
        expectedResult = -1; // Expected result should be -1 as both numbers are not prime together
        actualResult = TwinPrime.getTwinPrime(inputNumber); // Actual result from the method
        assertEquals(expectedResult, actualResult, "The method should return -1 when both numbers are not prime.");
        
        // Test Case 3: Input is not a prime number but (input + 2) is a prime number
        inputNumber = 6; // 6 is not a prime number but (6 + 2) = 8 is a prime number
        expectedResult = -1; // Expected result should be -1 as both numbers are not prime together (though one of them is prime)
        actualResult = TwinPrime.getTwinPrime(inputNumber); // Actual result from the method
        assertEquals(expectedResult, actualResult, "The method should correctly handle cases where input itself is not a prime number.");
        
        // Test Case 4: Input is not a prime number and (input + 2) is also not a prime number
        inputNumber = 4; // 4 is not a prime number and (4 + 2) = 6 is also not a prime number (divisible by both 2 and 3)
        expectedResult = -1; // Expected result should be -1 as both numbers are not prime together
        actualResult = TwinPrime.getTwinPrime(inputNumber); // Actual result from the method
        assertEquals(expectedResult, actualResult, "The method should handle cases where both numbers are not prime.");
    }
}