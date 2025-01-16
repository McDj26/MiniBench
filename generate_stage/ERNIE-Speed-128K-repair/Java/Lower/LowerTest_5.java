package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {
    @Test
    public void toLowerCaseTest() {
        String originalString = "Hello World!"; // Test case with both uppercase and lowercase letters
        String expectedString = "hello world!"; // Expected lowercase string
        String actualString = Lower.toLowerCase(originalString); // Using the method to convert to lowercase
        assertEquals(expectedString, actualString, "The string should be converted to lowercase."); // Asserting the expected output
    }
}