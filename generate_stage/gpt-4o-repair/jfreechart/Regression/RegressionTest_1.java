package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegressionTest {

    @Test
    public void calculateSubMatrixTest() {
        // Test case 1: Regular matrix
        double[][] matrix1 = {
            {4, 8, 12},
            {2, 5, 7},
            {1, 2, 3}
        };
        double[][] expected1 = {
            {0, 2},
            {0, 0}
        };
        double[][] result1 = calculateSubMatrix(matrix1);
        assertArrayEquals(expected1, result1);

        // Test case 2: Single row matrix
        double[][] matrix2 = {
            {3, 6, 9}
        };
        double[][] expected2 = {};
        double[][] result2 = calculateSubMatrix(matrix2);
        assertArrayEquals(expected2, result2);

        // Test case 3: Matrix with zero pivot that requires row swap
        double[][] matrix3 = {
            {0, 2, 3},
            {1, 4, 5},
            {2, 8, 9}
        };
        double[][] expected3 = {
            {0, -1},
            {0, 0}
        };
        double[][] result3 = calculateSubMatrix(matrix3);
        assertArrayEquals(expected3, result3);

        // Test case 4: Matrix with no solution (all zero pivot elements)
        double[][] matrix4 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        double[][] expected4 = {
            {0, 0},
            {0, 0}
        };
        double[][] result4 = calculateSubMatrix(matrix4);
        assertArrayEquals(expected4, result4);

        // Test case 5: Larger matrix
        double[][] matrix5 = {
            {10, 20, 30, 40},
            {5, 12, 15, 18},
            {2.5, 6, 7.5, 9},
            {1.25, 3, 3.75, 4.5}
        };
        double[][] expected5 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        double[][] result5 = calculateSubMatrix(matrix5);
        assertArrayEquals(expected5, result5);
    }

    private double[][] calculateSubMatrix(double[][] matrix) {
        return Regression.calculateSubMatrix(matrix); // Assuming Regression class is accessible
    }
}