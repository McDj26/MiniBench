package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegressionTest {
    @Test
    public void calculateSubMatrixTest() {
        // Arrange
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int equations = matrix.length; // should be 3 in this case
        int coefficients = matrix[0].length; // should be 3 in this case
        double[][] expectedResult = {
            {-1, -3}, // First row of sub matrix after calculations
            {-4, -6}  // Second row of sub matrix after calculations
        };
        
        // Act & Assert
        double[][] result = Regression.calculateSubMatrix(matrix);
        assertNotNull(result); // Make sure result is not null
        assertEquals(equations - 1, result.length); // Check number of equations in result matrix
        assertEquals(coefficients - 1, result[0].length); // Check number of coefficients in result matrix
        assertArrayEquals(expectedResult, result); // Check if the result matches the expected result
    }
    
    @Test
    public void calculateSubMatrixWithPivotZeroTest() {
        // Arrange
        double[][] matrixWithPivotZero = {
            {0, 2, 3}, // Pivot element is zero here
            {4, 5, 6}, // The rest of the matrix is non-zero values for test case sake
            {7, 8, 9}  // ... so this is a test case for the code handling zero pivot element scenario
        };
        // Act & Assert for this test case should be done after actual calculation logic is implemented correctly
    }
}