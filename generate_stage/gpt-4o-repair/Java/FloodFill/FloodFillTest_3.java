package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {

    @Test
    public void testFloodFillNormalCase() {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int x = 1, y = 1;
        int newColor = 2;
        int oldColor = 1;

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        int[][] expectedImage = {
            {2, 2, 2},
            {2, 2, 0},
            {2, 0, 1}
        };

        assertArrayEquals(expectedImage, image, "Flood fill did not produce expected output.");
    }
    
    @Test
    public void testFloodFillNoChange() {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int x = 0, y = 0;
        int newColor = 1; // Same as old color
        int oldColor = 1;

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        int[][] expectedImage = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        assertArrayEquals(expectedImage, image, "Image should remain unchanged when newColor is same as oldColor.");
    }

    @Test
    public void testFloodFillEdgeCase() {
        int[][] image = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int x = 1, y = 1;
        int newColor = 2;
        int oldColor = 1;

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        int[][] expectedImage = {
            {0, 0, 0},
            {0, 2, 0},
            {0, 0, 0}
        };

        assertArrayEquals(expectedImage, image, "Flood fill did not produce expected output for a single pixel area.");
    }
}