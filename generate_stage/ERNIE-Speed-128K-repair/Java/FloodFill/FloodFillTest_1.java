package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {
    private final int[][] image = {
        {1, 1, 1},
        {1, 0, 0}, // 0 represents the empty space to be filled
        {1, 1, 0},
        {1, 0, 1}
    };
    private final int x = 1; // x coordinate of the starting point for flood fill
    private final int y = 1; // y coordinate of the starting point for flood fill
    private final int newColor = 2; // new color to be filled in the image
    private final int oldColor = 0; // old color to be replaced in the image
    private final int[][] expectedImageAfterFill = {
        {1, 2, 2}, // after flood fill operation
        {1, 2, 2}, // the empty space is filled with new color
        {1, 2, 2}, // the adjacent empty spaces are also filled recursively
        {1, 0, 1}  // other regions remain unchanged as they are not adjacent to the starting point
    };

    @Test
    public void floodFillTest() {
        FloodFill.floodFill(image, x, y, newColor, oldColor);
        assertArrayEquals(expectedImageAfterFill, image); // Assert that the image is filled as expected
    }
}