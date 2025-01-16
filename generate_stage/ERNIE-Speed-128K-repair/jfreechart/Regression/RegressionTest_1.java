package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegressionTest {
    
    @Test
    public void calculateSubMatrixTest() {
        // Test case for a matrix with equations and coefficients of size 1
        double[][] matrix = {{2}};
        double[][] expectedResult = {{0}}; // Expected result for this case is an empty matrix
        assertArrayEquals(expectedResult, Regression.calculateSubMatrix(matrix)); // Assert that the result matches the expected output
        
        // Test case for a matrix with equations and coefficients of size 2x2
        double[][] matrix2 = {{2, 3}, {4, 5}}; // Input matrix for testing
        double[][] expectedResult2 = {{-1, 0}, {0, 0}}; // Expected result for this case after applying calculations
        assertArrayEquals(expectedResult2, Regression.calculateSubMatrix(matrix2)); // Assert that the result matches the expected output
        
        // Test case for a matrix with equations > 1 and coefficients > 1
        double[][] matrix3 = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}}; // Input matrix for testing
        double[][] expectedResult3 = {{-4, -1}, {0, 0}}; // Expected result after applying calculations on this matrix
        assertArrayEquals(expectedResult3, Regression.calculateSubMatrix(matrix3)); // Assert that the result matches the expected output
        
        // Test case with zero pivot element scenario (swap rows)
        double[][] matrix4 = {{0, 2}, {4, 5}, {6, 7}}; // Input matrix with zero pivot element (first row)
        double[][] expectedResult4 = {{-2, -3}, {2, 0}}; // Expected result after swapping rows in this scenario
        assertArrayEquals(expectedResult4, Regression.calculateSubMatrix(matrix4)); // Assert that the result matches the expected output after swapping rows to find non-zero pivot element
        
        // Additional test cases can be added to cover more scenarios and edge cases if needed.
    }
}