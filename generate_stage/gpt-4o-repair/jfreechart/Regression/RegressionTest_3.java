package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegressionTest {

    @Test
    public void calculateSubMatrixTest() {
        // Test case with a valid matrix input
        double[][] matrix = {
            {2, 4, 6},
            {4, 8, 12},
            {1, 3, 5}
        };

        double[][] expected = {
            {0, 0},
            {0, -0.5}
        };

        double[][] result = Regression.calculateSubMatrix(matrix);
        assertArrayEquals(expected, result);

        // Test case with another valid matrix input where pivot is not zero
        double[][] matrix2 = {
            {3, 5, 7},
            {6, 10, 14},
            {2, 6, 8}
        };

        double[][] expected2 = {
            {0, 0},
            {0, -4}
        };

        double[][] result2 = Regression.calculateSubMatrix(matrix2);
        assertArrayEquals(expected2, result2);

        // Test matrix size 1
        double[][] matrix3 = {
            {1}
        };

        double[][] expected3 = new double[0][0]; // Expecting an empty matrix
        double[][] result3 = Regression.calculateSubMatrix(matrix3);
        assertArrayEquals(expected3, result3);
    }
}