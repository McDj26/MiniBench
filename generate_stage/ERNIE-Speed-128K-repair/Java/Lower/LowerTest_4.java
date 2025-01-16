package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {
    @Test
    public void toLowerCaseTest() {
        // Test the functionality of toLowerCase method with various inputs
        String originalString = "Hello World!"; // Test with a string containing both uppercase and lowercase letters
        String expectedString = "hello world!"; // Expected lowercase string after conversion
        String actualString = Lower.toLowerCase(originalString); // Convert the original string to lowercase using the method
        assertEquals(expectedString, actualString); // Assert that the actual string matches the expected lowercase string
        
        originalString = "HELLO"; // Test with an all-uppercase string
        expectedString = "hello"; // Expected lowercase string after conversion
        actualString = Lower.toLowerCase(originalString); // Convert the original string to lowercase using the method again
        assertEquals(expectedString, actualString); // Assert that the conversion is successful for all uppercase characters
        
        originalString = "HELLO WORLD!"; // Test with a string containing both uppercase and special characters
        expectedString = "hello world!"; // Expected lowercase string after conversion, but special characters should remain unchanged
        actualString = Lower.toLowerCase(originalString); // Convert the original string to lowercase once more
        assertTrue(actualString.matches("hello world!")); // Assert that only letters are converted to lowercase while special characters remain unchanged
    }
}