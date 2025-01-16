package com.thealgorithms.maths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AliquotSumTest {
    @Test
    public void getAliquotSumTest() {
        // Test for small positive integer
        assertEquals(6, AliquotSum.getAliquotSum(1)); // 1 is a perfect square so sum should be 6
        assertEquals(1, AliquotSum.getAliquotSum(2)); // 2 is a prime number so sum should be 1
        assertEquals(9, AliquotSum.getAliquotSum(3)); // Sum of factors of 3 is 9 (1+3)
        assertEquals(10, AliquotSum.getAliquotSum(4)); // Sum of factors of 4 is 10 (1+2+4)
        assertEquals(-1, AliquotSum.getAliquotSum(-1)); // Negative input should return -1
        assertEquals(-1, AliquotSum.getAliquotSum(0)); // Zero input should return -1
        assertEquals(-1, AliquotSum.getAliquotSum(Integer.MAX_VALUE)); // Integer maximum value should return -1 since root overflows and no factors are found
        
        // Test for large positive integer with factors
        int largeNumber = 100; // Use a large number with many factors to test the loop
        int expectedSum = 4 + (largeNumber / 4) + 5 + (largeNumber / 5); // Sum of factors after root of largeNumber
        assertEquals(expectedSum + largeNumber % 2 == 0 ? 2 : 0, AliquotSum.getAliquotSum(largeNumber)); // If largeNumber is a perfect square, subtract root from sum
        
        // Test for prime numbers
        for (int i = 3; i < Integer.MAX_VALUE; i += 2) { // Iterate over odd numbers as even numbers are not prime except for 2 itself
            if (isPrime(i)) { // Assuming a helper method isPrime exists in the same package to check if a number is prime or not
                assertEquals(i + 1, AliquotSum.getAliquotSum(i)); // Prime numbers have only one factor other than itself and 1, so sum should be one more than the number itself
            }
        }
    }
    
    // Helper method to check if a number is prime or not
    private static boolean isPrime(int n) {
        if (n <= 1) return false; // Numbers less than or equal to 1 are not prime
        if (n <= 3) return true; // Numbers 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false; // All numbers greater than 3 are either odd or multiples of 3
        int sqrtN = (int) Math.sqrt(n); // Check divisibility up to square root of the number for optimization
        for (int i = 5; i <= sqrtN; i += 6) { // Increment by steps of six to only check for factors of the form 'i' and 'i+2' since multiples of 'i' and 'i+4' are not prime unless they are themselves prime numbers like 5 and 7 respectively
            if (n % i == 0 || n % (i + 2) == 0) return false; // If divisible by either 'i' or 'i+2', then not prime
        }
        return true; // If no divisor found, then the number is prime
    }
}