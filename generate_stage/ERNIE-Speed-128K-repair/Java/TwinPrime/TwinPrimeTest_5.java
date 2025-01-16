package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {
    @Test
    public void getTwinPrimeTest() {
        // Test case for input number being prime and (inputNumber + 2) being prime
        int inputNumber = 3; // 3 is a prime number and (3 + 2) is also a prime number
        int expectedResult = 5; // Expected result should be (inputNumber + 2)
        assertEquals(expectedResult, TwinPrime.getTwinPrime(inputNumber), "Twin prime test case failed");
        
        // Test case for input number being prime but (inputNumber + 2) not being prime
        inputNumber = 7; // 7 is a prime number but (7 + 2) is not a prime number
        expectedResult = -1; // Expected result should be -1 as one of the numbers is not prime
        assertEquals(-1, TwinPrime.getTwinPrime(inputNumber), "Twin prime test case failed for non-prime twin");
        
        // Test case for input number not being prime but (inputNumber + 2) being prime
        inputNumber = 4; // 4 is not a prime number but (4 + 2) is a prime number
        assertEquals(-1, TwinPrime.getTwinPrime(inputNumber), "Twin prime test case failed for non-prime input");
        
        // Test case for input number not being prime and (inputNumber + 2) also not being prime
        inputNumber = 9; // Both 9 and (9 + 2) are not prime numbers
        assertEquals(-1, TwinPrime.getTwinPrime(inputNumber), "Twin prime test case failed for both numbers not prime");
    }
}