package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {
    @Test
    public void floodFillTest() {
        int[][] image = {
            {1, 1, 1}, // Initialize the image with values that can be changed for testing purposes
            {1, 1, 1},
            {1, 0, 0} // Assuming '0' represents the color to be replaced and '1' is the new color to be filled
        };
        int x = 1; // x coordinate where flood fill starts
        int y = 1; // y coordinate where flood fill starts
        int newColor = 1; // New color to be filled in the image
        int oldColor = 0; // Old color to be replaced in the image
        FloodFill.floodFill(image, x, y, newColor, oldColor);
        assertEquals(FloodFill.getPixel(image, x, y), newColor); // Assert that the pixel at (x, y) is filled with new color
        assertEquals(FloodFill.getPixel(image, 0, 2), oldColor); // Assert that pixels outside the filled region remain unchanged
        assertEquals(FloodFill.getPixel(image, 2, 2), oldColor); // Test edge case on the right side of the image
        assertEquals(FloodFill.getPixel(image, 1, 3), oldColor); // Test edge case at the bottom of the image
    }
}