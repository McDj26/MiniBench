package org.jfree.data.statistics;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegressionTest {
    @Test
    public void calculateSubMatrixTest() {
        double[][] inputMatrix = {
            {2, 3, 4},
            {4, 6, 8},
            {6, 9, 12}
        };

        double[][] expectedOutput = {
            {0, 0},
            {0, 0}
        };

        double[][] result = Regression.calculateSubMatrix(inputMatrix);

        assertArrayEquals(expectedOutput, result);
    }
    
    @Test
    public void calculateSubMatrixZeroPivotTest() {
        double[][] inputMatrix = {
            {0, 3, 4},
            {4, 6, 8},
            {6, 9, 12}
        };

        double[][] expectedOutput = {
            {0, 0},
            {0, 0}
        };

        double[][] result = Regression.calculateSubMatrix(inputMatrix);

        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void calculateSubMatrixSingleElementTest() {
        double[][] inputMatrix = {
            {5}
        };

        double[][] expectedOutput = new double[0][0];

        double[][] result = Regression.calculateSubMatrix(inputMatrix);

        assertArrayEquals(expectedOutput, result);
    }
}