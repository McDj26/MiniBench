package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {
    private final int[][] image = {
        {1, 1, 1},
        {1, 0, 0}, // This is the starting point for flood fill
        {1, 1, 1}
    };
    private final int newColor = 0; // New color to be filled
    private final int oldColor = 1; // Old color to be replaced in the image
    private final int x = 1; // Starting x coordinate for flood fill
    private final int y = 1; // Starting y coordinate for flood fill

    @BeforeEach
    public void setUp() {
        // Initialize image with a pattern for testing flood fill algorithm
    }

    @Test
    public void floodFillTest() {
        FloodFill.floodFill(image, x, y, newColor, oldColor);
        assertEquals(newColor, image[x][y]); // Check if the starting point is filled with new color
        assertEquals(newColor, image[x + 1][y]); // Check if the right adjacent point is filled with new color
        assertEquals(newColor, image[x - 1][y]); // Check if the left adjacent point is filled with new color
        assertEquals(newColor, image[x][y + 1]); // Check if the bottom adjacent point is filled with new color
        assertEquals(newColor, image[x][y - 1]); // Check if the top adjacent point is filled with new color
        assertEquals(oldColor, image[x + 2][y]); // Check if a point not in contact with starting region is unchanged with old color
        assertEquals(oldColor, image[x][y + 2]); // Check if a point not in contact with starting region is unchanged with old color
    }
}