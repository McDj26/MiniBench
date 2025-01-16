package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegressionTest {
    @Test
    public void calculateSubMatrixTest() {
        // Test case for the calculateSubMatrix method
        double[][] inputMatrix = {
                {1, 2, 3}, // first equation
                {4, 5, 6}, // second equation
                {7, 8, 9}  // third equation
        };
        double[][] expectedMatrix = {
                {-0.666666666666667, -1}, // sub matrix after removing first equation and column
                {-0.22222222222222, -0.88888888888888}  // sub matrix after removing second equation and column
        };
        double[][] resultMatrix = Regression.calculateSubMatrix(inputMatrix);
        assertEquals(expectedMatrix[0].length, resultMatrix[0].length); // Asserting the dimensions of the result matrix
        assertEquals(expectedMatrix[0].length + 1, resultMatrix.length); // Asserting the number of rows in the result matrix
        assertArrayEquals(expectedMatrix[0], resultMatrix[0]); // Asserting the first row of the result matrix is as expected
        assertArrayEquals(expectedMatrix[1], resultMatrix[1]); // Asserting the second row of the result matrix is as expected
        assertArrayEquals(new double[]{0}, resultMatrix[2]); // Asserting the third row is all zeros as per the logic of the method
    }
}