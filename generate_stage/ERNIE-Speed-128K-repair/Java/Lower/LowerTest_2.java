package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {
    @Test
    public void toLowerCaseTest() {
        String originalString = "Hello World!"; // Test input string
        String expectedString = "hello world!"; // Expected lowercase string
        String actualString = Lower.toLowerCase(originalString); // Convert the input string to lowercase
        assertEquals(expectedString, actualString); // Assert that the actual string matches the expected lowercase string
    }
}