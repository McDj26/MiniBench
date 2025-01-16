package org.jfree.data.statistics;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegressionTest {
    @Test
    public void calculateSubMatrixTest() {
        // Test case 1: Standard 3x3 matrix
        double[][] matrix1 = {
            {4, 2, 3},
            {2, 1, 1},
            {6, 0, 2}
        };
        
        double[][] expected1 = {
            {3, 2.5},
            {0, 1}
        };
        
        double[][] result1 = Regression.calculateSubMatrix(matrix1);
        assertArrayEquals(expected1, result1);

        // Test case 2: Matrix with one zero pivot element
        double[][] matrix2 = {
            {1, 2, 3},
            {0, 1, -1},
            {4, 5, 6}
        };
        
        double[][] expected2 = {
            {5, 3},
            {0, -5}
        };
        
        double[][] result2 = Regression.calculateSubMatrix(matrix2);
        assertArrayEquals(expected2, result2);

        // Test case 3: Identity matrix 2x2
        double[][] matrix3 = {
            {1, 0},
            {0, 1}
        };
        
        double[][] expected3 = {
            {0}
        };
        
        double[][] result3 = Regression.calculateSubMatrix(matrix3);
        assertArrayEquals(expected3, result3);

        // Test case 4: Zero matrix edge case
        double[][] matrix4 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        
        double[][] expected4 = {
            {0, 0},
            {0, 0}
        };
        
        double[][] result4 = Regression.calculateSubMatrix(matrix4);
        assertArrayEquals(expected4, result4);
    }
}