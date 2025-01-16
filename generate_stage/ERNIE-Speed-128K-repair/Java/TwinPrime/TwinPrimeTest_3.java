package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TwinPrimeTest {
    @Test
    public void getTwinPrimeTest() {
        // Test case for input number being prime and (inputNumber + 2) being prime
        int inputNumber = 3; // Assume that inputNumber is prime and (inputNumber + 2) is also prime
        int expectedResult = inputNumber + 2; // Expected result should be the next twin prime
        int result = TwinPrime.getTwinPrime(inputNumber); // Call the method to test
        assertEquals(expectedResult, result, "The method did not return the correct twin prime value."); // Assert if the result matches the expected twin prime value
        
        // Test case for input number being prime but (inputNumber + 2) not being prime
        inputNumber = 5; // Assume that inputNumber is prime but (inputNumber + 2) is not prime
        expectedResult = -1; // Expected result should be -1 as both numbers are not prime
        result = TwinPrime.getTwinPrime(inputNumber); // Call the method to test
        assertEquals(-1, result, "The method did not correctly detect that both numbers are not prime."); // Assert if the result is -1 as expected
        
        // Test case for input number not being prime but (inputNumber + 2) being prime
        inputNumber = 6; // Assume that inputNumber is not prime but (inputNumber + 2) is prime
        expectedResult = -1; // Expected result should be -1 as one of the numbers is not prime
        result = TwinPrime.getTwinPrime(inputNumber); // Call the method to test
        assertEquals(-1, result, "The method did not correctly detect that one of the numbers is not prime."); // Assert if the result is -1 as expected in this case too
        
        // Test case for input number being negative or zero (invalid input)
        inputNumber = -5; // Invalid input value to test error handling
        assertThrows(IllegalArgumentException.class, () -> TwinPrime.getTwinPrime(inputNumber), "Method should throw IllegalArgumentException for negative or zero input."); // Assert that an exception is thrown for invalid input
    }
}