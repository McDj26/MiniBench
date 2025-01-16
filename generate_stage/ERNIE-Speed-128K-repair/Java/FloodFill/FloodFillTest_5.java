package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {
    @Test
    public void floodFillTest() {
        int[][] image = {
            {1, 1, 1},
            {1, 0, 1}, // The '0' represents the point to be filled.
            {1, 1, 1}
        };
        int x = 1; // x coordinate of the point to be filled
        int y = 1; // y coordinate of the point to be filled
        int newColor = 0; // New color to fill in the image
        int oldColor = 1; // Old color to be replaced in the image
        int expectedColor = 0; // Expected color after flood fill operation
        FloodFill.floodFill(image, x, y, newColor, oldColor);
        assertEquals(expectedColor, FloodFill.getPixel(image, x, y), "The color at the given coordinates should be updated.");
        // Now, we should test recursively with multiple calls to floodFill to ensure it works properly.
        // This includes testing the boundary cases like crossing the boundary or when old and new colors are the same.
        FloodFill.floodFill(image, x + 1, y - 1, newColor, oldColor); // top left neighbor pixel coordinates test case
        assertEquals(expectedColor, FloodFill.getPixel(image, x + 1, y - 1), "The top left neighbor pixel should be updated.");
        FloodFill.floodFill(image, x - 1, y + 2, newColor, oldColor); // bottom right neighbor pixel coordinates test case
        assertEquals(expectedColor, FloodFill.getPixel(image, x - 1, y + 2), "The bottom right neighbor pixel should be updated.");
        FloodFill.floodFill(image, x + 2, y + 2, newColor + 1, oldColor); // with a new newColor test case
        assertNotEquals(expectedColor, FloodFill.getPixel(image, x + 2, y + 2), "The color should be different since we provided a new newColor.");
        assertEquals(newColor + 1, FloodFill.getPixel(image, x + 2, y + 2), "The color should be equal to the new provided color.");
        FloodFill.floodFill(imageWithBoundaryCaseCoordinates, boundaryCaseXCoordinate - 1, boundaryCaseYCoordinate + 3, newColor + 2, oldColor); // boundary case test case (assuming imageWithBoundaryCaseCoordinates is defined and boundaryCaseXCoordinate and boundaryCaseYCoordinate represent the boundary cases coordinates)
        // Here you would assert that floodFill does not go beyond the image boundaries by checking if pixels outside the boundaries remain unchanged.
    }
}