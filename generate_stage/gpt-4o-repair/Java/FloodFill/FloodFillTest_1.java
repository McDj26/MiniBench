package com.thealgorithms.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {

    @Test
    public void testFloodFill() {
        int[][] image = {
            {1, 1, 1, 2},
            {1, 1, 0, 2},
            {1, 0, 1, 2},
            {0, 2, 2, 2}
        };

        int x = 1;
        int y = 1;
        int newColor = 3;
        int oldColor = 1;

        // Expected result after flood fill
        int[][] expectedImage = {
            {3, 3, 3, 2},
            {3, 3, 0, 2},
            {3, 0, 1, 2},
            {0, 2, 2, 2}
        };

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        assertArrayEquals(expectedImage, image, "The image should have been flood filled correctly.");
    }

    @Test
    public void testFloodFillNoChange() {
        int[][] image = {
            {0, 0, 0},
            {0, 1, 1},
            {1, 1, 0}
        };

        int x = 1;
        int y = 1;
        int newColor = 1;
        int oldColor = 1;

        // Expected result is same as original since newColor is same as oldColor
        int[][] expectedImage = {
            {0, 0, 0},
            {0, 1, 1},
            {1, 1, 0}
        };

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        assertArrayEquals(expectedImage, image, "The image should be unchanged when newColor is the same as oldColor.");
    }

    @Test
    public void testFloodFillOutOfBounds() {
        int[][] image = {
            {1, 1, 1},
            {1, 0, 0},
            {1, 0, 2}
        };

        int x = 3; // Out of bounds
        int y = 3; // Out of bounds
        int newColor = 1;
        int oldColor = 1;

        int[][] expectedImage = {
            {1, 1, 1},
            {1, 0, 0},
            {1, 0, 2}
        };

        FloodFill.floodFill(image, x, y, newColor, oldColor);

        assertArrayEquals(expectedImage, image, "The image should be unchanged when starting point is out of bounds.");
    }
}