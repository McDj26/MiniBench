package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegressionTest {

    @Test
    public void calculateSubMatrixTest() {
        // Test 1: Basic test with a 2x2 matrix
        double[][] matrix1 = {
            {4, 8},
            {2, 5}
        };
        double[][] expected1 = {
            {0, 0}
        };
        assertArrayEquals(expected1, Regression.calculateSubMatrix(matrix1), "The submatrix is not as expected.");

        // Test 2: 3x3 matrix test
        double[][] matrix2 = {
            {6, 15, 55},
            {1, 1, 1},
            {2, 2, 2}
        };
        double[][] expected2 = {
            {0, 5},
            {0, 0}
        };
        assertArrayEquals(expected2, Regression.calculateSubMatrix(matrix2), "The submatrix is not as expected.");

        // Test 3: Check for zero pivot element
        double[][] matrix3 = {
            {0, 8, 7},
            {1, 1, 1},
            {1, 2, 3}
        };
        double[][] expected3 = {
            {0, 0},
            {0, 0}
        };
        assertArrayEquals(expected3, Regression.calculateSubMatrix(matrix3), "The submatrix is not as expected for zero pivot check.");

        // Test 4: Edge case with 1x1 matrix
        double[][] matrix4 = {
            {1}
        };
        double[][] expected4 = {};
        assertArrayEquals(expected4, Regression.calculateSubMatrix(matrix4), "The submatrix is not as expected for 1x1 matrix.");
    }
}