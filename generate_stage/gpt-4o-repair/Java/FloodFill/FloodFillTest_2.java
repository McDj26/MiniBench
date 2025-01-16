package com.thealgorithms.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FloodFillTest {

    @Test
    public void floodFillTest() {
        int[][] image = {
            {1, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
        };
        int x = 0;
        int y = 0;
        int newColor = 2;
        int oldColor = 1;
        
        FloodFill.floodFill(image, x, y, newColor, oldColor);

        int[][] expectedImage = {
            {2, 2, 0, 0},
            {2, 0, 0, 0},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
        };
        
        assertArrayEquals(expectedImage, image);
    }

    @Test
    public void testNoChangeIfNewColorIsSameAsOldColor() {
        int[][] image = {
            {1, 1},
            {1, 1}
        };
        int[][] expectedImage = {
            {1, 1},
            {1, 1}
        };
        
        FloodFill.floodFill(image, 0, 0, 1, 1);

        assertArrayEquals(expectedImage, image);
    }

    @Test
    public void testIgnoreOutOfBounds() {
        int[][] image = {
            {0, 0},
            {0, 0}
        };
        int[][] expectedImage = {
            {0, 0},
            {0, 0}
        };
        
        FloodFill.floodFill(image, 2, 2, 1, 0);

        assertArrayEquals(expectedImage, image);
    }
}