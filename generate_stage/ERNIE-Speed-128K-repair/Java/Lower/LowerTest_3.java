package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {
    @Test
    public void toLowerCaseTest() {
        // Arrange
        String originalString = "Hello World!"; // Arrange your test data here
        String expectedString = "hello world!"; // Expected lowercase string
        String actualString = Lower.toLowerCase(originalString); // Call the method to test
        
        // Assert
        assertEquals(expectedString, actualString); // Compare the actual result with the expected result
    }
}