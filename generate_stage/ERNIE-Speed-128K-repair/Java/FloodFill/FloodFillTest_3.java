package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {
    private static final int[][] IMAGE = {
        {1, 1, 1},
        {1, 0, 0}, // Starting point (x=1, y=1)
        {1, 0, 0}  // Old color is 0, new color is 2 (replacement value)
    };
    private static final int START_X = 1;
    private static final int START_Y = 1;
    private static final int NEW_COLOR = 2;
    private static final int OLD_COLOR = 0;
    private static final int EXPECTED_FILL_COUNT = 9; // Including the starting point

    @Test
    public void floodFillTest() {
        FloodFill.floodFill(IMAGE, START_X, START_Y, NEW_COLOR, OLD_COLOR);
        int fillCount = countFilledPixels(IMAGE); // Utility method to count pixels filled with new color
        assertEquals(EXPECTED_FILL_COUNT, fillCount); // Assert that the correct number of pixels are filled with new color
        assertEquals(NEW_COLOR, IMAGE[START_X][START_Y]); // Assert that the starting point is filled with new color
        assertEquals(NEW_COLOR, FloodFill.getPixel(IMAGE, START_X + 1, START_Y)); // Check horizontally adjacent coordinates are filled with new color
        assertEquals(NEW_COLOR, FloodFill.getPixel(IMAGE, START_X - 1, START_Y)); // Check horizontally adjacent coordinates are filled with new color
        assertEquals(NEW_COLOR, FloodFill.getPixel(IMAGE, START_X, START_Y + 1)); // Check vertically adjacent coordinates are filled with new color
        assertEquals(NEW_COLOR, FloodFill.getPixel(IMAGE, START_X, START_Y - 1)); // Check vertically adjacent coordinates are filled with new color
        // You can add more assertions for diagonal coordinates if needed. The test would be similar to the above ones.
    }

    private int countFilledPixels(int[][] image) {
        int count = 0;
        for (int[] row : image) {
            for (int pixel : row) {
                if (pixel == NEW_COLOR) { // Count pixels filled with new color
                    count++;
                }
            }
        }
        return count; // Return the count of pixels filled with new color
    }
}