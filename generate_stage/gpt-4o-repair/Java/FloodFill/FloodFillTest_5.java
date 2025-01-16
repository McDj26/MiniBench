package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {

    @Test
    public void floodFillTest() {
        int[][] image = {
            {1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 0, 0}
        };

        int x = 1, y = 1, newColor = 2, oldColor = 0;

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        int[][] expectedImage = {
            {1, 1, 1, 0, 0},
            {1, 2, 2, 1, 1},
            {1, 1, 2, 2, 2},
            {0, 0, 2, 1, 1},
            {1, 1, 1, 0, 0}
        };

        assertArrayEquals(expectedImage, image, "The floodFill method should fill the connected area with the new color.");
    }

    @Test
    public void floodFillSameColorTest() {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int x = 0, y = 0, newColor = 1, oldColor = 1;

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        int[][] expectedImage = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        assertArrayEquals(expectedImage, image, "The image should remain unchanged if the new color is the same as the old color.");
    }

    @Test
    public void floodFillEdgeCaseTest() {
        int[][] image = {
            {0}
        };

        int x = 0, y = 0, newColor = 1, oldColor = 0;

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        int[][] expectedImage = {
            {1}
        };

        assertArrayEquals(expectedImage, image, "The floodFill method should correctly handle a single element image.");
    }
}