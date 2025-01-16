package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {

    @Test
    public void floodFillTest() {
        // Initializing a 2D image array
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        // Call floodFill with starting at coordinates (1, 1), 
        // newColor as 2, oldColor as 1
        FloodFill.floodFill(image, 1, 1, 2, 1);

        // Expected image after flood fill operation
        int[][] expectedImage = {
            {2, 2, 2},
            {2, 2, 0},
            {2, 0, 1}
        };

        assertArrayEquals(expectedImage, image, "Image should be flood filled correctly");
    }
    
    // Assume necessary stubs since original methods aren't provided
    private static int getPixel(int[][] image, int x, int y) {
        return image[x][y];
    }
    
    private static void putPixel(int[][] image, int x, int y, int newColor) {
        image[x][y] = newColor;
    }
}